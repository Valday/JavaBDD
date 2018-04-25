/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Modele.Client;
import com.julienCreach.agenceVoyage.managers.TableManager;
import com.julienCreach.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ajoutClientController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit() {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit) {
        ajoutClientController.isNewOrEdit = isNewOrEdit;
    }

    private static Client _selectedClient;

    public static void set_selectedClient(Client _selectedClient)
    {
        ajoutClientController._selectedClient = _selectedClient;
    }

    @FXML
    private Button butCancel;

    @FXML
    private Button butValider;

    @FXML
    private TextField textFieldLName;

    @FXML
    private TextField textFieldFName;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private TextField textFieldStreetNumber;

    @FXML
    private TextField textFieldStreet;

    @FXML
    private TextField textFieldCity;

    @FXML
    private TextField textFieldPostalCode;

    @FXML
    private DatePicker datePickerBirthDate;

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
        try
        {
            SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
            Client newClient = new Client(-1,
                this.textFieldLName.getText(),
                this.textFieldFName.getText(),
                this.textFieldPhone.getText(),
                this.textFieldCity.getText(),
                this.textFieldStreet.getText(),
                Integer.parseInt(this.textFieldStreetNumber.getText()),
                this.textFieldPostalCode.getText(),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePickerBirthDate.getValue())));

            if(isNewOrEdit)
            {
                if(TableManager.Instance().get_clientDAO().Add(newClient))
                {
                    System.out.println(" => Client successfully add ...");
                    // get a handle to the stage
                    Stage stage = (Stage) butValider.getScene().getWindow();

                    // do what you have to do
                    stage.close();
                }
            }
            else
            {
                newClient.set_idClient(_selectedClient.get_idClient());
                if(TableManager.Instance().get_clientDAO().Edit(newClient))
                {
                    System.out.println(" => Client successfully updated ...");
                    // get a handle to the stage
                    Stage stage = (Stage) butValider.getScene().getWindow();

                    // do what you have to do
                    stage.close();
                }
            }
        }
        catch (NumberFormatException e)
        {
            MessageBox.Show(Alert.AlertType.ERROR,"Erreur de saisie","Le contenu du champ -Street number- doit etre un nombre","");
        }
    }

    @FXML
    private void initialize()
    {
        if(!isNewOrEdit)
        {
            this.loadEditValues();
        }

    }

    private void loadEditValues()
    {
        this.textFieldFName.setText(_selectedClient.get_prenomClient());
        this.textFieldLName.setText(_selectedClient.get_nameClient());
        this.textFieldCity.setText(_selectedClient.get_villeClient());
        this.textFieldStreet.setText(_selectedClient.get_rueClient());
        this.textFieldPhone.setText(_selectedClient.get_telephoneClient());
        this.textFieldPostalCode.setText(_selectedClient.get_codePostalClient());
        this.textFieldStreetNumber.setText(Integer.toString(_selectedClient.get_numRueClient()));
        this.datePickerBirthDate.setValue(LocalDate.parse(_selectedClient.get_dateNaissanceClient()));
    }
}
