/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Client;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.fxml.FXML;
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
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private TextField textField_lName;

    @FXML
    private TextField textField_fName;

    @FXML
    private TextField textField_phone;

    @FXML
    private TextField textField_streetNumber;

    @FXML
    private TextField textField_street;

    @FXML
    private TextField textField_city;

    @FXML
    private TextField textField_postalCode;

    @FXML
    private DatePicker datePicker_birthDate;

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
        Client newClient = new Client(-1,
                this.textField_lName.getText(),
                this.textField_fName.getText(),
                this.textField_phone.getText(),
                this.textField_city.getText(),
                this.textField_street.getText(),
                Integer.parseInt(this.textField_streetNumber.getText()),
                this.textField_postalCode.getText(),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePicker_birthDate.getValue())));

        if(isNewOrEdit)
        {
            newClient.set_idClient(TableManager.Instance().get_clientDAO().Count()+1);
            if(TableManager.Instance().get_clientDAO().Add(newClient))
            {
                System.out.println(" => Client successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

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
                Stage stage = (Stage) but_Valider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
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
        this.textField_fName.setText(_selectedClient.get_prenomClient());
        this.textField_lName.setText(_selectedClient.get_nameClient());
        this.textField_city.setText(_selectedClient.get_villeClient());
        this.textField_street.setText(_selectedClient.get_rueClient());
        this.textField_phone.setText(_selectedClient.get_telephoneClient());
        this.textField_postalCode.setText(_selectedClient.get_codePostalClient());
        this.textField_streetNumber.setText(Integer.toString(_selectedClient.get_numRueClient()));
        this.datePicker_birthDate.setValue(LocalDate.parse(_selectedClient.get_dateNaissanceClient()));
    }
}
