/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Hotel;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.fxml.FXML;
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
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private TextField textField_name;

    @FXML
    private TextField textField_phone;

    @FXML
    private TextField textField_streetNumber;

    @FXML
    private TextField textField_street;

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
        Hotel newHotel = new Hotel(-1,
                this.textField_name.getText(),
                this.textField_phone.getText(),
                this.textField_street.getText(),
                Integer.parseInt(this.textField_streetNumber.getText()));

        if(isNewOrEdit)
        {
            newHotel.set_idHotel(TableManager.Instance().get_hotelDAO().Count()+1);
            if(TableManager.Instance().get_hotelDAO().Add(newHotel))
            {
                System.out.println(" => Hotel successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

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
        this.textField_name.setText(_selectedHotel.get_nameHotel());
        this.textField_phone.setText(_selectedHotel.get_telephoneHotel());
        this.textField_street.setText(_selectedHotel.get_rueHotel());
        this.textField_streetNumber.setText(Integer.toString(_selectedHotel.get_numRueHotel()));
    }
}
