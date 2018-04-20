/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.valday.agenceVoyage.GUI;

import com.valday.agenceVoyage.Table.Accompagnateur;
import com.valday.agenceVoyage.Table.Client;
import com.valday.agenceVoyage.Table.Passwd;
import com.valday.agenceVoyage.Table.User;
import com.valday.agenceVoyage.managers.TableManager;
import com.valday.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class loginWindowController
{
    //region Const Attributes

    //private final Hashtable _passwd_Hashtable;

    private Passwd _passd;

    private User _user;

    //endregion Const Attributes

    @FXML
    private Button but_cancel;

    @FXML
    private TextField txtField_login;

    @FXML
    private PasswordField passwdField_passwd;

    @FXML
    public void but_validateClick()
    {
        this.connect(this.txtField_login.getText(),this.passwdField_passwd.getText());
    }

    @FXML
    public void but_cancelClick()
    {
        // get a handle to the stage
        Stage stage = (Stage)but_cancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    public loginWindowController()
    {

    }


    //region Private Services

    private void connect(String id, String passwd)
    {
        this._passd = TableManager.Instance().get_passwdDAO().find(id,passwd);

        if(this._passd != null)
        {
            this._user = TableManager.Instance().get_userDAO().find(this._passd.get_idUser());
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

        this.txtField_login.clear();
        this.passwdField_passwd.clear();
    }

    //endregion Private Services

    private void OpenAdminView()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void OpenCustomerView()
    {
        try {
            Client client = TableManager.Instance().get_clientDAO().find(this._user.get_idClient());
            customerWindowController.set_selectedClient(client);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(client.get_prenomClient() + " " + client.get_nameClient());
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void OpenGuideView()
    {
        try {
            Accompagnateur accompagnateur = TableManager.Instance().get_accompagnateurDAO().find(this._user.get_idAccompagnateur());
            guideWindowController.set_selectedAccompagnateur(accompagnateur);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guideWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(accompagnateur.get_prenomAccompagnateur()+" "+accompagnateur.get_nameAccompagnateur());
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
