package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.AccompagnateurDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.Table.Accompagnateur;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ajoutAccompagnateurController
{
    @FXML
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private TextField textField_name;

    @FXML
    private  TextField textField_prenom;

    @FXML
    private TextField textField_telephone;

    @FXML
    private TextField textField_numRue;

    @FXML
    private TextField textField_rue;

    @FXML
    private  TextField textField_ville;

    @FXML
    private TextField textField_codePostal;

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

        DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
        Accompagnateur newAccompagnateur = new Accompagnateur(accompagnateurDAO.Count()+1,
                this.textField_name.getText(),
                this.textField_prenom.getText(),
                this.textField_telephone.getText(),
                Integer.parseInt(this.textField_numRue.getText()),
                this.textField_rue.getText(),
                this.textField_ville.getText(),
                this.textField_codePostal.getText());

        if(accompagnateurDAO.Add(newAccompagnateur))
        {
            System.out.println(" => Accompagnateur successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }


    }
}
