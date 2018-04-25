/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import com.julienCreach.agenceVoyage.Modele.Accompagnateur;
import com.julienCreach.agenceVoyage.Modele.Client;
import com.julienCreach.agenceVoyage.Modele.Passwd;
import com.julienCreach.agenceVoyage.Modele.User;
import com.julienCreach.agenceVoyage.managers.TableManager;
import com.julienCreach.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controleur de la vue login.
 * @author Julien Creach
 * @version 1.0
 */
public class LoginWindowController
{
    //region Private Attributes

    /**
     * User correspondant au identifiants de connexion.
     */
    private User _user;

    /**
     * Bouton cancel.
     */
    @FXML
    private Button butCancel;

    /**
     * Champ de saisie login.
     */
    @FXML
    private TextField txtFieldLogin;

    /**
     * Champ de saisie Passwds.
     */
    @FXML
    private PasswordField passwdFieldPasswd;

    //endregion Private Attributes

    //region Constructor

    /**
     * Constructeur par defaut.
     */
    public LoginWindowController()
    {

    }

    //endregion Constructor

    //region Private Services

    /**
     * Action sur click bouton valider.
     */
    @FXML
    private void butValidateClick()
    {
        this.connect(this.txtFieldLogin.getText(),this.passwdFieldPasswd.getText());
    }

    /**
     * Action sur click bouton cancel
     */
    @FXML
    private void butCancelClick()
    {
        // get a handle to the stage
        Stage stage = (Stage)butCancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    /**
     * Methode gerant la conexion
     * @param id identifiant de connexion
     * @param passwd mot de passe
     */
    private void connect(String id, String passwd)
    {
        Passwd passd = TableManager.Instance().get_passwdDAO().find(id,passwd);

        if(passd != null)
        {
            this._user = TableManager.Instance().get_userDAO().find(passd.get_idUser());
            if(this._user != null)
            {
                switch (this._user.get_rank())
                {
                    case 1:
                        this.OpenCustomerView();
                        break;

                    case 2:
                        this.OpenGuideView();
                        break;

                    case 3:
                        this.OpenAdminView();
                        break;

                    default:
                        break;
                }
            }
        }
        else
        {
            MessageBox.Show(Alert.AlertType.ERROR,"User name or password not found", null,"Invalid datas, please try again!");
        }

        this.txtFieldLogin.clear();
        this.passwdFieldPasswd.clear();
    }

    //endregion Private Services

    /**
     * Methode de connexion vue admin.
     */
    private void OpenAdminView()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Methode de connexion vue Client.
     */
    private void OpenCustomerView()
    {
        try
        {
            Client client = TableManager.Instance().get_clientDAO().find(this._user.get_idClient());
            CustomerWindowController.set_selectedClient(client);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(client.get_prenomClient() + " " + client.get_nameClient());
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Methode de connexion vue accompagnateur.
     */
    private void OpenGuideView()
    {
        try
        {
            Accompagnateur accompagnateur = TableManager.Instance().get_accompagnateurDAO().find(this._user.get_idAccompagnateur());
            GuideWindowController.set_selectedAccompagnateur(accompagnateur);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuideWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(accompagnateur.get_prenomAccompagnateur()+" "+accompagnateur.get_nameAccompagnateur());
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
