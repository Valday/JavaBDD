/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Modele.Hotel;
import com.julienCreach.agenceVoyage.managers.TableManager;
import com.julienCreach.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ajoutHotelController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit() {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit) {
        ajoutHotelController.isNewOrEdit = isNewOrEdit;
    }

    private static Hotel _selectedHotel;

    public static void set_selectedHotel(Hotel _selectedHotel)
    {
        ajoutHotelController._selectedHotel = _selectedHotel;
    }

    @FXML
    private Button butCancel;

    @FXML
    private Button butValider;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private TextField textFieldStreetNumber;

    @FXML
    private TextField textFieldStreet;

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
            Hotel newHotel = new Hotel(-1,
                this.textFieldName.getText(),
                this.textFieldPhone.getText(),
                this.textFieldStreet.getText(),
                Integer.parseInt(this.textFieldStreetNumber.getText()));

            if(isNewOrEdit)
            {
                if(TableManager.Instance().get_hotelDAO().Add(newHotel))
                {
                    System.out.println(" => Hotel successfully add ...");
                    // get a handle to the stage
                    Stage stage = (Stage) butValider.getScene().getWindow();

                    // do what you have to do
                    stage.close();
                }
            }
            else
            {
                newHotel.set_idHotel(_selectedHotel.get_idHotel());
                if(TableManager.Instance().get_hotelDAO().Edit(newHotel))
                {
                    System.out.println(" => Hotel successfully updated ...");
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
        this.textFieldName.setText(_selectedHotel.get_nameHotel());
        this.textFieldPhone.setText(_selectedHotel.get_telephoneHotel());
        this.textFieldStreet.setText(_selectedHotel.get_rueHotel());
        this.textFieldStreetNumber.setText(Integer.toString(_selectedHotel.get_numRueHotel()));
    }
}
