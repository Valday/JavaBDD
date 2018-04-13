package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.Table.Hotel;
import com.valday.agenceVoyage.managers.TableManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ajoutHotelController
{
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
        Hotel newHotel = new Hotel(TableManager.Instance().get_hotelDAO().Count()+1,
                this.textField_name.getText(),
                this.textField_phone.getText(),
                this.textField_street.getText(),
                Integer.parseInt(this.textField_streetNumber.getText()));

        if(TableManager.Instance().get_hotelDAO().Add(newHotel))
        {
            System.out.println(" => Hotel successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }
    }
}
