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
    private Button butCancel;

    @FXML
    private Button butValider;

    @FXML
    private TextField textFieldName;

    @FXML
    private  TextField textFieldPrenom;

    @FXML
    private TextField textFieldTelephone;

    @FXML
    private TextField textFieldNumRue;

    @FXML
    private TextField textFieldRue;

    @FXML
    private  TextField textFieldVille;

    @FXML
    private TextField textFieldCodePostal;

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

        Accompagnateur newAccompagnateur = new Accompagnateur(-1,
                this.textFieldName.getText(),
                this.textFieldPrenom.getText(),
                this.textFieldTelephone.getText(),
                Integer.parseInt(this.textFieldNumRue.getText()),
                this.textFieldRue.getText(),
                this.textFieldVille.getText(),
                this.textFieldCodePostal.getText());

        if(isNewOrEdit)
        {
            if(TableManager.Instance().get_accompagnateurDAO().Add(newAccompagnateur))
            {
                System.out.println(" => Accompagnateur successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) butValider.getScene().getWindow();

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
                Stage stage = (Stage) butValider.getScene().getWindow();

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
        this.textFieldName.setText(_selectedAccompagnateur.get_nameAccompagnateur());
        this.textFieldPrenom.setText(_selectedAccompagnateur.get_prenomAccompagnateur());
        this.textFieldCodePostal.setText(_selectedAccompagnateur.get_codePostalAccompagnateur());
        this.textFieldNumRue.setText(Integer.toString(_selectedAccompagnateur.get_numRueAccompagnateur()));
        this.textFieldRue.setText(_selectedAccompagnateur.get_rueAccompagnateur());
        this.textFieldVille.setText(_selectedAccompagnateur.get_villeAccompagnateur());
        this.textFieldTelephone.setText(_selectedAccompagnateur.get_telephoneAccompagnateur());
    }
}
