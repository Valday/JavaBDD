package com.valday.agenceVoyage.GUI;

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

import javax.swing.*;
import java.util.Hashtable;

public class loginWindowController
{
    //region Const Attributes

    private final Hashtable _passwd_Hashtable;

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
        Stage stage = (Stage) but_cancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    public loginWindowController()
    {
        this._passwd_Hashtable = new Hashtable();
        this._passwd_Hashtable.put("admin","root");
        this._passwd_Hashtable.put("toto","toto");
        this._passwd_Hashtable.put("guide","guide");
    }


    //region Private Services
    private void connect(String id, String passwd)
    {
        if (this._passwd_Hashtable.containsKey(id))
        {
            if (this._passwd_Hashtable.get(id).toString().equals(passwd))
            {
                switch (id)
                {
                    case "admin":
                        OpenAdminView();
                        break;
                    case "toto":
                        OpenCustomerView();
                        break;
                    case "guide":
                        OpenGuideView();
                        break;
                }
            }
            else
            {
                MessageBox.Show(Alert.AlertType.ERROR,"Invalid password", null,"Invalid password, please try again!");
            }
        }
        else
        {
            MessageBox.Show(Alert.AlertType.ERROR, "Invalid id", null, "Invalid id, There is no user for this id!\nPlease try again!");
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guideWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
