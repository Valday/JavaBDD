/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Accompagnateur;
import com.julienCreach.agenceVoyage.Table.Circuit;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ajoutCircuitController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit()
    {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit)
    {
        ajoutCircuitController.isNewOrEdit = isNewOrEdit;
    }

    private static  Circuit _selectedCircuit;

    public static void set_selectedCircuit(Circuit _selectedCircuit)
    {
        ajoutCircuitController._selectedCircuit = _selectedCircuit;
    }

    @FXML
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private TextField textField_name;

    @FXML
    private TextField textField_placeDispo;

    @FXML
    private TextField textField_prix;

    @FXML
    private DatePicker datePick_depart;

    @FXML
    private DatePicker datePick_arrivee;

    @FXML
    private CheckBox checkBox_circuitOpen;

    @FXML
    private ComboBox comboBox_accompagnateurs;

    private ObservableList<String> _listNomAccompagnateurs;

    private List<Accompagnateur> _listAccompagnateurs;

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
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        int idAcc = -1;
        for(int i = 0; i < this._listAccompagnateurs.size();i++)
        {
            if(this.comboBox_accompagnateurs.getSelectionModel().getSelectedItem().toString().contains(this._listAccompagnateurs.get(i).get_nameAccompagnateur())
                    && this.comboBox_accompagnateurs.getSelectionModel().getSelectedItem().toString().contains(this._listAccompagnateurs.get(i).get_prenomAccompagnateur()))
            {
                idAcc = this._listAccompagnateurs.get(i).get_idAccompagnateur();
            }
        }


        Circuit newCircuit = new Circuit(-1,
                this.textField_name.getText(),
                Integer.parseInt(this.textField_placeDispo.getText()),
                Integer.parseInt(this.textField_prix.getText()),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePick_depart.getValue())),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePick_arrivee.getValue())),
                this.checkBox_circuitOpen.isSelected(),
                idAcc);
        if(isNewOrEdit)
        {

            newCircuit.set_idCircuit(TableManager.Instance().get_circuitDAO().Count()+1);

            if(TableManager.Instance().get_circuitDAO().Add(newCircuit))
            {
                System.out.println(" => Circuit "+newCircuit.get_idCircuit()+" successfully add ...");

                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }
        else
        {

            newCircuit.set_idCircuit(_selectedCircuit.get_idCircuit());

            if(TableManager.Instance().get_circuitDAO().Edit(newCircuit))
            {
                System.out.println(" => Circuit "+newCircuit.get_idCircuit()+" successfully updated ...");

                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }


    }

    @FXML
    private void but_addAccClick()
    {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutAccompagnateur.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Accompagnateur");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboxValue();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize()
    {
        this.loadComboxValue();
        if(!isNewOrEdit)
        {
            this.loadEditValues();
        }

    }

    private void loadComboxValue()
    {
        try
        {
            this._listNomAccompagnateurs = this.comboBox_accompagnateurs.getItems();
            this._listAccompagnateurs = new ArrayList<>();

            ResultSet allAccompagnateurs = TableManager.Instance().get_accompagnateurDAO().selectAll();

            while (allAccompagnateurs.next())
            {
                Accompagnateur newAccompagnateur = new Accompagnateur(allAccompagnateurs.getInt(1),
                        allAccompagnateurs.getString(2),
                        allAccompagnateurs.getString(3),
                        allAccompagnateurs.getString(4),
                        allAccompagnateurs.getInt(5),
                        allAccompagnateurs.getString(6),
                        allAccompagnateurs.getString(7),
                        allAccompagnateurs.getString(8));

                this._listAccompagnateurs.add(newAccompagnateur);
                this._listNomAccompagnateurs.add(newAccompagnateur.get_nameAccompagnateur()+" "+newAccompagnateur.get_prenomAccompagnateur());
            }
            this.comboBox_accompagnateurs.setItems(this._listNomAccompagnateurs);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadEditValues()
    {
            this.textField_name.setText(_selectedCircuit.get_nameCircuit());
            this.textField_placeDispo.setText(Integer.toString(_selectedCircuit.get_places()));
            this.textField_prix.setText(Integer.toString(_selectedCircuit.get_prix()));
            this.datePick_depart.setValue(LocalDate.parse(_selectedCircuit.get_dateDepart()));
            this.datePick_arrivee.setValue(LocalDate.parse(_selectedCircuit.get_dateFin()));
            this.checkBox_circuitOpen.setSelected(_selectedCircuit.is_open());
            this.comboBox_accompagnateurs.getSelectionModel().select(_selectedCircuit.get_idAccompagnateur()-1);
    }
}
