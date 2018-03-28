package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.ClientDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.Table.Client;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ajoutClientController
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
        DAO<Client> clientDAO = new ClientDAO(JdbcConnectionManager.Instance().get_connector());
        Client newClient = new Client(clientDAO.Count()+1, this.textField_name.getText());

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
