/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Modele.Accompagnateur;
import com.julienCreach.agenceVoyage.managers.TableManager;
import com.julienCreach.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller vue ajout accompagnateur.
 * @author Julien Creach
 * @version 1.0
 */
public class AjoutAccompagnateurController
{

    /**
     * Permet de d'utiliser la vue en creation et en edition d'accompagnateur.
     */
    private static boolean isNewOrEdit;

    /**
     * Getter creation ou edition.
     * @return true ou false (creation ou edition)
     */
    public static boolean isIsNewOrEdit()
    {
        return isNewOrEdit;
    }

    /**
     * Setter creation ou edition.
     * @param isNewOrEdit true ou false (creation ou edition)
     */
    public static void setIsNewOrEdit(boolean isNewOrEdit)
    {
        AjoutAccompagnateurController.isNewOrEdit = isNewOrEdit;
    }

    /**
     * En mode edition, accompagnateur a editer.
     */
    private static Accompagnateur _selectedAccompagnateur;

    /**
     * Setter Accompagnateur a editer.
     * @param _selectedAccompagnateur accompagnateur
     */
    public static void set_selectedAccompagnateur(Accompagnateur _selectedAccompagnateur)
    {
        AjoutAccompagnateurController._selectedAccompagnateur = _selectedAccompagnateur;
    }

    /**
     * Bouton cancel.
     */
    @FXML
    private Button butCancel;

    /**
     * Bouton valider.
     */
    @FXML
    private Button butValider;

    /**
     * TExtfield nom.
     */
    @FXML
    private TextField textFieldName;

    /**
     * Textfield prenom.
     */
    @FXML
    private  TextField textFieldPrenom;

    /**
     * Textfield telephone.
     */
    @FXML
    private TextField textFieldTelephone;

    /**
     * Textfield numero de rue.
     */
    @FXML
    private TextField textFieldNumRue;

    /**
     * Trextfield rue.
     */
    @FXML
    private TextField textFieldRue;

    /**
     * Textfield ville.
     */
    @FXML
    private  TextField textFieldVille;

    /**
     * Textfield code postal.
     */
    @FXML
    private TextField textFieldCodePostal;

    /**
     * Constructeur par defaut.
     */
    public AjoutAccompagnateurController()
    {

    }

    /**
     * Action sur le bouton annuler.
     */
    @FXML
    private void butAnnulerClick()
    {
        // get a handle to the stage
        Stage stage = (Stage)butCancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    /**
     * Action sur le bouton valider.
     */
    @FXML
    private void butValiderClick()
    {
        try
        {
            if((this.textFieldName.getText().isEmpty())
                    && (!this.textFieldPrenom.getText().isEmpty())
                    && (!this.textFieldTelephone.getText().isEmpty())
                    && (!this.textFieldNumRue.getText().isEmpty())
                    && (!this.textFieldRue.getText().isEmpty())
                    && (!this.textFieldVille.getText().isEmpty())
                    && (!this.textFieldCodePostal.getText().isEmpty()))
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
                        Stage stage = (Stage)butValider.getScene().getWindow();

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
                        Stage stage = (Stage)butValider.getScene().getWindow();

                        // do what you have to do
                        stage.close();
                    }
                }
            }
            else
            {
                MessageBox.Show(Alert.AlertType.WARNING, "Champ(s) de saisie vide", "Merci de remplir tous les champs","");
            }
        }
                catch (NumberFormatException e)
        {
            MessageBox.Show(Alert.AlertType.ERROR,"Erreur de saisie","Le contenu du champ -Nombre de places- et -prix- doivent etre un nombre","");
        }
    }

    /**
     * Initialisation de la vue.
     */
    @FXML
    private void initialize()
    {
        if(!isNewOrEdit && _selectedAccompagnateur != null)
        {
            this.loadEditValues();
        }
    }

    /**
     * Chargement des valeurs dans la vue.
     */
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
