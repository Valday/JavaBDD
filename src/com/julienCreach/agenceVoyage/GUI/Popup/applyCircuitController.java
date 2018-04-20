/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Accompagnateur;
import com.julienCreach.agenceVoyage.Table.Circuit;
import com.julienCreach.agenceVoyage.managers.JdbcConnectionManager;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class applyCircuitController
{
    /**
     * Accompagnateur Selectionné
     */
    private static Accompagnateur _actualAccompagnateur;

    /**
     * Assesseur sur le client selectioné
     * @param _selectedAccompagnateur Accompagnateur a afficher
     */
    public static void set_actualAccompagnateur(Accompagnateur _selectedAccompagnateur)
    {
        applyCircuitController._actualAccompagnateur = _selectedAccompagnateur;
    }

    private ObservableList<String> _listNomCircuits;

    private List<Circuit> _listCircuits;

    private ResultSet resultSet;

    @FXML
    private ComboBox comboBox_circuit;

    @FXML
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private Label lblDepart;

    @FXML
    private Label lblFin;

    @FXML
    private void but_AnnulerClick()
    {
        // get a handle to the stage
        Stage stage = (Stage) but_cancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    @FXML
    private void but_ValiderClick()
    {
        try
        {

            SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
            Circuit newCircuit = new Circuit(
                    resultSet.getInt("idCircuit"),
                    resultSet.getString("nom"),
                    resultSet.getInt("places"),
                    resultSet.getInt("prix"),
                    simpleDateFormater.format(resultSet.getDate("dateDepart")),
                    simpleDateFormater.format(resultSet.getDate("dateFin")),
                    resultSet.getBoolean("open"),
                    _actualAccompagnateur.get_idAccompagnateur()

            );

            if(TableManager.Instance().get_circuitDAO().Edit(newCircuit))
            {
                System.out.println(" => Circuit successfully updated ...");
                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    private void comboBox_circuitClick()
    {
        try
        {
            resultSet = JdbcConnectionManager.Instance().get_connector().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE nom = '"+this.comboBox_circuit.getSelectionModel().getSelectedItem().toString()+"'");

            if (resultSet.first())
            {
                this.lblDepart.setText(resultSet.getString("dateDepart").substring(0,10));
                this.lblFin.setText(resultSet.getString("dateFin").substring(0,10));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize()
    {
        this.loadComboBoxValues();
    }

    private void loadComboBoxValues()
    {
        try
        {
            this._listNomCircuits = this.comboBox_circuit.getItems();
            this._listCircuits = new ArrayList<>();

            ResultSet allCircuits = TableManager.Instance().get_circuitDAO().selectAll();

            while (allCircuits.next())
            {
                Circuit newCircuit = new Circuit(allCircuits.getInt(1),
                        allCircuits.getString(2),
                        allCircuits.getInt(3),
                        allCircuits.getInt(4),
                        allCircuits.getString(5),
                        allCircuits.getString(6),
                        allCircuits.getBoolean(7),
                        allCircuits.getInt(8));

                if(newCircuit.is_open())
                {
                    this._listCircuits.add(newCircuit);
                    this._listNomCircuits.add(newCircuit.get_nameCircuit());
                }
            }

            this.comboBox_circuit.setItems(this._listNomCircuits);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
