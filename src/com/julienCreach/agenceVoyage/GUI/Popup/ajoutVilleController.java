/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Table.Hotel;
import com.julienCreach.agenceVoyage.Table.Ville;
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ajoutVilleController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit() {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit) {
        ajoutVilleController.isNewOrEdit = isNewOrEdit;
    }

    private static Ville _selectedVille;

    public static void set_selectedVille(Ville _selectedVille)
    {
        ajoutVilleController._selectedVille = _selectedVille;
    }

    @FXML
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private TextField textField_name;

    @FXML
    private ComboBox comboBox_hotel;

    private ObservableList<String> _listNomHotels;

    private List<Hotel> _listHotels;

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
        int idHotel = 0;
        for(int i = 0; i < this._listHotels.size();i++)
        {
            if(this._listHotels.get(i).get_nameHotel() == this.comboBox_hotel.getSelectionModel().getSelectedItem().toString())
            {
                idHotel = this._listHotels.get(i).get_idHotel();
            }
        }

        Ville newVille = new Ville(-1,
                this.textField_name.getText(),
                idHotel);

        if(isNewOrEdit)
        {
            newVille.set_idVille(TableManager.Instance().get_villeDAO().Count()+1);
            if(TableManager.Instance().get_villeDAO().Add(newVille))
            {
                System.out.println(" => Ville successfully add ...");
                // get a handle to the stage
                Stage stage = (Stage) but_Valider.getScene().getWindow();

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
                Stage stage = (Stage) but_Valider.getScene().getWindow();

                // do what you have to do
                stage.close();
            }
        }


    }

    @FXML
    private void initialize()
    {
        this.loadComboBoxValues();
        if(!isNewOrEdit)
        {
            this.loadEditValues();
        }
    }

    private void loadComboBoxValues()
    {
        try
        {
            this._listNomHotels = this.comboBox_hotel.getItems();
            this._listHotels = new ArrayList<>();

            ResultSet allHotels = TableManager.Instance().get_hotelDAO().selectAll();

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
            this.comboBox_hotel.setItems(this._listNomHotels);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadEditValues()
    {
        this.textField_name.setText(_selectedVille.get_nameVille());
        this.comboBox_hotel.getSelectionModel().select(_selectedVille.get_idHotel()-1);
    }

        @FXML
    private void but_addHotelClick()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutHotel.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Hotel");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboBoxValues();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
