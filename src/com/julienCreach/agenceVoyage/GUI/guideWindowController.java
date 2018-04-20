/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.valday.agenceVoyage.GUI;

import com.valday.agenceVoyage.GUI.Popup.applyCircuitController;
import com.valday.agenceVoyage.Table.Accompagnateur;
import com.valday.agenceVoyage.Table.Circuit;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class guideWindowController
{

    /**
     * Accompagnateur sélectionné
     */
    private static Accompagnateur _selectedAccompagnateur;

    /**
     * Assesseur sur l'accompgnateur sélectionné
     * @param _selectedAccompagnateur Accompagnateur a afficher
     */
    public static void set_selectedAccompagnateur(Accompagnateur _selectedAccompagnateur)
    {
        guideWindowController._selectedAccompagnateur = _selectedAccompagnateur;
    }

    /**
     * Liste des circuits que l'acompagnateur sélectionné encadre
     */
    private ObservableList<Circuit> _guideCircuits;

    /**
     * Champ de saisie nom
     */
    @FXML
    private TextField textFieldLastName;

    /**
     * Champ de saisie prenom
     */
    @FXML
    private TextField textFieldFirstName;

    /**
     * Champ de saisie date de naissance
     */
    @FXML
    private DatePicker datePickerBirthDate;

    /**
     * Champ de saisie numero de telephone
     */
    @FXML
    private TextField textFieldPhoneNumber;

    /**
     * Champ de saisie numero de rue
     */
    @FXML
    private TextField textFieldStreetNumber;

    /**
     * Champ de saisie rue
     */
    @FXML
    private TextField textFieldStreet;

    /**
     * Champ de saisie code postal
     */
    @FXML
    private TextField textFieldPostalCode;

    /**
     * Champ de saisie ville
     */
    @FXML
    private TextField textFieldCity;

    /**
     * Table Permettant d'afficher les circuits de l'accompagnateur
     */
    @FXML
    private TableView tableView_Circuits;


    /**
     * Action sur le menuItem quitter de la menu bar
     */
    @FXML
    public void menuItem_QuitClick()
    {
        System.exit(0);
    }

    /**
     * Initialisation du contenu de la fenetre
     */
    @FXML
    private void initialize()
    {
        this.LoadValues();
    }

    @FXML
    private void but_ApplyJobClick()
    {
        try
        {
            applyCircuitController.set_actualAccompagnateur(_selectedAccompagnateur);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/applyCircuit.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Book now");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.LoadGuideCircuits();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void but_ValidModifClick()
    {

    }

        /**
         * Charge les données pour l'affichage dans la page de profil
         */
    private void LoadValues()
    {
        this.textFieldLastName.setText(_selectedAccompagnateur.get_nameAccompagnateur());
        this.textFieldFirstName.setText(_selectedAccompagnateur.get_prenomAccompagnateur());
        this.textFieldPhoneNumber.setText(_selectedAccompagnateur.get_telephoneAccompagnateur());
        this.textFieldStreetNumber.setText(Integer.toString(_selectedAccompagnateur.get_numRueAccompagnateur()));
        this.textFieldStreet.setText(_selectedAccompagnateur.get_rueAccompagnateur());
        this.textFieldPostalCode.setText(_selectedAccompagnateur.get_codePostalAccompagnateur());
        this.textFieldCity.setText(_selectedAccompagnateur.get_villeAccompagnateur());

        this.LoadGuideCircuits();

    }

    /**
     * Recherche tous les circuits pour l'accompagnateur sélectionné et met à jour la tableview
     */
    private void LoadGuideCircuits()
    {
        this._guideCircuits = FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try
        {
            resultSet = JdbcConnectionManager.Instance().get_connector().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE idAccompagnateur = "+_selectedAccompagnateur.get_idAccompagnateur());

            while (resultSet.next())
            {
                Circuit newCircuit = new Circuit(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5).substring(0,10),
                        resultSet.getString(6).substring(0,10),
                        resultSet.getBoolean(7),
                        resultSet.getInt(8));

                this._guideCircuits.add(newCircuit);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        this.tableView_Circuits.setItems(_guideCircuits);
    }
}
