/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Accompagnateur;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ajoutAccompagnateurController
{

    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit() {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit) {
        ajoutAccompagnateurController.isNewOrEdit = isNewOrEdit;
    }

    private static Accompagnateur _selectedAccompagnateur;

    public static void set_selectedAccompagnateur(Accompagnateur _selectedAccompagnateur)
    {
        ajoutAccompagnateurController._selectedAccompagnateur = _selectedAccompagnateur;
    }

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

        Accompagnateur newAccompagnateur = new Accompagnateur(-1,
                this.textField_name.getText(),
                this.textField_prenom.getText(),
                this.textField_telephone.getText(),
                Integer.parseInt(this.textField_numRue.getText()),
                this.textField_rue.getText(),
                this.textField_ville.getText(),
                this.textField_codePostal.getText());

        if(isNewOrEdit)
        {
            newAccompagnateur.set_idAccompagnateur(TableManager.Instance().get_accompagnateurDAO().Count()+1);
            if(TableManager.Instance().get_accompagnateurDAO().Add(newAccompagnateur))
            {
                System.out.println(" => Accompagnateur successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }
        else
        {
            newAccompagnateur.set_idAccompagnateur(_selectedAccompagnateur.get_idAccompagnateur());
            if(TableManager.Instance().get_accompagnateurDAO().Edit(newAccompagnateur))
            {
                System.out.println(" => Accompagnateur successfully updated ...");
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
        this.textField_name.setText(_selectedAccompagnateur.get_nameAccompagnateur());
        this.textField_prenom.setText(_selectedAccompagnateur.get_prenomAccompagnateur());
        this.textField_codePostal.setText(_selectedAccompagnateur.get_codePostalAccompagnateur());
        this.textField_numRue.setText(Integer.toString(_selectedAccompagnateur.get_numRueAccompagnateur()));
        this.textField_rue.setText(_selectedAccompagnateur.get_rueAccompagnateur());
        this.textField_ville.setText(_selectedAccompagnateur.get_villeAccompagnateur());
        this.textField_telephone.setText(_selectedAccompagnateur.get_telephoneAccompagnateur());
    }
}
