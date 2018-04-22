/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Circuit;
import com.julienCreach.agenceVoyage.Table.Client;
import com.julienCreach.agenceVoyage.Table.Reservation;
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

public class ajoutReservationController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit() {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit) {
        ajoutReservationController.isNewOrEdit = isNewOrEdit;
    }

    private static Reservation _selectedReservation;

    public static void set_selectedReservation(Reservation _selectedReservation)
    {
        ajoutReservationController._selectedReservation = _selectedReservation;
    }

    @FXML
    private ComboBox comboBoxClient;

    @FXML
    private CheckBox checkBoxAccompteOk;

    @FXML
    private  CheckBox checkBoxSecondPaiementOk;

    @FXML
    private TextField textFieldMontantAccompte;

    @FXML
    private TextField textFieldMontantSecondPaiement;

    @FXML
    private DatePicker datePickerReservation;

    @FXML
    private  DatePicker datePickerLimite;

    @FXML
    private ComboBox comboBoxCircuit;

    @FXML
    private Button butValider;

    @FXML
    private Button butCancel;

    private ObservableList<String> _listNomClients;

    private ObservableList<String> _listNomCircuits;

    private List<Client> _listClients;

    private List<Circuit> _listCircuits;

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
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        int idClient = -1;
        int idCircuit = -1;

        for(int i = 0; i < this._listClients.size();i++)
        {
            if(this.comboBoxClient.getSelectionModel().getSelectedItem().toString().contains(this._listClients.get(i).get_nameClient())
                    && this.comboBoxClient.getSelectionModel().getSelectedItem().toString().contains(this._listClients.get(i).get_prenomClient()))
            {
                idClient = this._listClients.get(i).get_idClient();
            }
        }

        for(int i = 0; i < this._listCircuits.size();i++)
        {
            if(this.comboBoxCircuit.getSelectionModel().getSelectedItem().toString().contains(this._listCircuits.get(i).get_nameCircuit()))
            {
                idCircuit = this._listCircuits.get(i).get_idCircuit();
            }
        }

        Reservation newReservation = new Reservation(-1,
                this.checkBoxAccompteOk.isSelected(),
                this.checkBoxSecondPaiementOk.isSelected(),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePickerLimite.getValue())),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePickerReservation.getValue())),
                false,
                Integer.parseInt(this.textFieldMontantAccompte.getText()),
                Integer.parseInt(this.textFieldMontantSecondPaiement.getText()),
                idClient,
                idCircuit);


        if(isNewOrEdit)
        {
            if(TableManager.Instance().get_reservationDAO().Add(newReservation))
            {
                System.out.println(" => Reservation successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) butValider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }
        else
        {
            newReservation.set_idResevation(_selectedReservation.get_idResevation());
            if(TableManager.Instance().get_reservationDAO().Add(newReservation))
            {
                System.out.println(" => Reservation successfully updated ...");
                // get a handle to the stage
                Stage stage = (Stage) butValider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }

    }

    @FXML
    private void initialize()
    {
        this.loadComboBoxValues();
        if(!isNewOrEdit)
        {
            this.loadEditValues();
        }
    }

    private void loadComboBoxValues()
    {
        try
        {
            this._listNomClients = this.comboBoxClient.getItems();
            this._listClients = new ArrayList<>();

            ResultSet allClients = TableManager.Instance().get_clientDAO().selectAll("Clients");

            while (allClients.next())
            {
                Client newClient = new Client(allClients.getInt(1),
                        allClients.getString(2),
                        allClients.getString(3),
                        allClients.getString(4),
                        allClients.getString(5),
                        allClients.getString(6),
                        allClients.getInt(7),
                        allClients.getString(8),
                        allClients.getString(9));

                this._listClients.add(newClient);
                this._listNomClients.add(newClient.get_nameClient()+" "+newClient.get_prenomClient());
            }

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

            this.comboBoxClient.setItems(this._listNomClients);
            this.comboBoxCircuit.setItems(this._listNomCircuits);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadEditValues()
    {
        this.checkBoxAccompteOk.setSelected(_selectedReservation.is_accompte());
        this.checkBoxSecondPaiementOk.setSelected(_selectedReservation.is_secondPaiement());
        this.textFieldMontantAccompte.setText(Integer.toString(_selectedReservation.get_accompteValue()));
        this.textFieldMontantSecondPaiement.setText(Integer.toString(_selectedReservation.get_secondPaiementValue()));
        this.datePickerLimite.setValue(LocalDate.parse(_selectedReservation.get_dateLimite()));
        this.datePickerReservation.setValue(LocalDate.parse(_selectedReservation.get_dateReservation()));
        this.comboBoxCircuit.getSelectionModel().select(_selectedReservation.get_idCircuit()-1);
        this.comboBoxClient.getSelectionModel().select(_selectedReservation.get_idClient()-1);
    }

    @FXML
    private void butAddClientClick()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutClient.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Client");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboBoxValues();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void butAddCircuitClick()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutCircuit.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Client");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboBoxValues();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
