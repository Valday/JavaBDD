package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.ClientDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.Table.Client;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class ajoutClientController
{
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
        DAO<Client> clientDAO = new ClientDAO(JdbcConnectionManager.Instance().get_connector());
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        Client newClient = new Client(clientDAO.Count()+1,
                this.textField_lName.getText(),
                "",
                "",
                this.textField_fName.getText(),
                this.textField_phone.getText(),
                this.textField_city.getText(),
                this.textField_street.getText(),
                Integer.parseInt(this.textField_streetNumber.getText()),
                this.textField_postalCode.getText(),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePicker_birthDate.getValue())));

        if(clientDAO.Add(newClient))
        {
            System.out.println(" => Client successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }
    }
}
