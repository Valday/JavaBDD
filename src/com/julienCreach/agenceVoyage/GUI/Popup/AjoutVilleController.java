/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Modele.Hotel;
import com.julienCreach.agenceVoyage.Modele.Ville;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AjoutVilleController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit()
    {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit)
    {
        AjoutVilleController.isNewOrEdit = isNewOrEdit;
    }

    private static Ville _selectedVille;

    public static void set_selectedVille(Ville _selectedVille)
    {
        AjoutVilleController._selectedVille = _selectedVille;
    }

    @FXML
    private Button butCancel;

    @FXML
    private Button butValider;

    @FXML
    private TextField textFieldName;

    @FXML
    private ComboBox comboBoxHotel;

    private ObservableList<String> _listNomHotels;

    private List<Hotel> _listHotels;

    /**
     * Constructeur pardefaut.
     */
    public AjoutVilleController()
    {

    }

    @FXML
    private void butAnnulerClick()
    {
        // get a handle to the stage
        Stage stage = (Stage)butCancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    @FXML
    private void butValiderClick()
    {
        int idHotel = 0;
        for(int i = 0; i < this._listHotels.size();i++)
        {
            if(this._listHotels.get(i).get_nameHotel() == this.comboBoxHotel.getSelectionModel().getSelectedItem().toString())
            {
                idHotel = this._listHotels.get(i).get_idHotel();
            }
        }

        Ville newVille = new Ville(-1,
                this.textFieldName.getText(),
                idHotel);

        if(isNewOrEdit)
        {
            if(TableManager.Instance().get_villeDAO().Add(newVille))
            {
                System.out.println(" => Ville successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage)butValider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }
        else
        {
            newVille.set_idVille(_selectedVille.get_idVille());
            if(TableManager.Instance().get_villeDAO().Edit(newVille))
            {
                System.out.println(" => Ville successfully updated ...");
                // get a handle to the stage
                Stage stage = (Stage)butValider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }


    }

    @FXML
    private void initialize()
    {
        this.loadComboBoxValues();
        if(!isNewOrEdit && _selectedVille != null)
        {
            this.loadEditValues();
        }
    }

    private void loadComboBoxValues()
    {
        try
        {
            this._listNomHotels = this.comboBoxHotel.getItems();
            this._listHotels = new ArrayList<>();

            ResultSet allHotels = TableManager.Instance().get_hotelDAO().selectAll("Hotels");

            while(allHotels.next())
            {
                Hotel newHotel = new Hotel(allHotels.getInt(1),
                        allHotels.getString(2),
                        allHotels.getString(3),
                        allHotels.getString(4),
                        allHotels.getInt(5));

                this._listHotels.add(newHotel);
                this._listNomHotels.add(newHotel.get_nameHotel());
            }
            this.comboBoxHotel.setItems(this._listNomHotels);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadEditValues()
    {
        this.textFieldName.setText(_selectedVille.get_nameVille());
        this.comboBoxHotel.getSelectionModel().select(_selectedVille.get_idHotel()-1);
    }

        @FXML
    private void butAddHotelClick()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjoutHotel.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Hotel");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboBoxValues();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
