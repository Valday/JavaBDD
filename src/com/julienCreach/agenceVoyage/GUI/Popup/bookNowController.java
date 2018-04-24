/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Modele.Circuit;
import com.julienCreach.agenceVoyage.Modele.Client;
import com.julienCreach.agenceVoyage.Modele.Reservation;
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
import java.util.Calendar;
import java.util.List;


public class bookNowController
{
    /**
     * Client Selectionné
     */
    private static Client _actualClient;

    /**
     * Assesseur sur le client selectioné
     * @param _selectedClient client a afficher
     */
    public static void set_actualClient(Client _selectedClient)
    {
        bookNowController._actualClient = _selectedClient;
    }

    private ObservableList<String> _listNomCircuits;

    private List<Circuit> _listCircuits;

    private ResultSet resultSet;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblDepart;

    @FXML
    private Label lblFin;

    @FXML
    private ComboBox comboBoxCircuit;

    @FXML
    private Button butCancel;

    @FXML
    private Button butValider;

    @FXML
    private void butAnnulerClick()
    {
        // get a handle to the stage
        Stage stage = (Stage) butCancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    @FXML
    private void butValiderClick()
    {
        Calendar dateLimite = Calendar.getInstance();
        dateLimite.add(Calendar.DATE,10);
        try
        {
            SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
            Reservation newReservation = new Reservation(
                    -1,
                    false,
                    false,
                    simpleDateFormater.format(dateLimite.getTime()),
                    simpleDateFormater.format(Calendar.getInstance().getTime()),
                    false,
                    0,
                    0,
                    _actualClient.get_idClient(),
                    resultSet.getInt("idCircuit"));

            if(TableManager.Instance().get_reservationDAO().Add(newReservation))
            {
                System.out.println(" => Reservation successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) butValider.getScene().getWindow();

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
    private void comboBoxCircuitClick()
    {
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        try
        {
            resultSet = JdbcConnectionManager.Instance().get_connector().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE nom = '"+this.comboBoxCircuit.getSelectionModel().getSelectedItem().toString()+"'");

            if (resultSet.first())
            {
                this.lblPrice.setText(Integer.toString(resultSet.getInt("prix")));
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
            this._listNomCircuits = this.comboBoxCircuit.getItems();
            this._listCircuits = new ArrayList<>();

            ResultSet allCircuits = TableManager.Instance().get_circuitDAO().selectAll("Circuits");

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

                this._listCircuits.add(newCircuit);
                this._listNomCircuits.add(newCircuit.get_nameCircuit());
            }

            this.comboBoxCircuit.setItems(this._listNomCircuits);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
