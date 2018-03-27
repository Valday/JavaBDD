package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.AccompagnateurDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.Table.Accompagnateur;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class ajoutAccompagnateurController
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
        Accompagnateur newAccompagnateur = new Accompagnateur(1, this.textField_name.getText());
        DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());

        if(accompagnateurDAO.Add(newAccompagnateur))
        {
            System.out.println(" => Accompagnateur successfully add ...");
        }

    }
}
