package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.DAO.HotelDAO;
import com.valday.agenceVoyage.Table.Hotel;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
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
        DAO<Hotel> hotelDAO = new HotelDAO(JdbcConnectionManager.Instance().get_connector());
        Hotel newHotel = new Hotel(hotelDAO.Count()+1, this.textField_name.getText());

        if(hotelDAO.Add(newHotel))
        {
            System.out.println(" => Hotel successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }

    }
}
