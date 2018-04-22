/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import com.julienCreach.agenceVoyage.GUI.Popup.applyCircuitController;
import com.julienCreach.agenceVoyage.Table.Accompagnateur;
import com.julienCreach.agenceVoyage.Table.Circuit;
import com.julienCreach.agenceVoyage.managers.JdbcConnectionManager;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class guideWindowController
{

    //region Private Attributs

    /**
     * Accompagnateur sélectionné
     */
    private static Accompagnateur _selectedAccompagnateur;

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
    private TableView<Circuit> tableViewCircuits;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Assesseur sur l'accompgnateur sélectionné
     * @param _selectedAccompagnateur Accompagnateur a afficher
     */
    public static void set_selectedAccompagnateur(Accompagnateur _selectedAccompagnateur)
    {
        guideWindowController._selectedAccompagnateur = _selectedAccompagnateur;
    }

    //endregion Public Attributs

    //region  Private Services

    /**
     * Action sur le menuItem quitter de la menu bar
     */
    @FXML
    private void menuItemQuitClick()
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

    /**
     * Action sur click boutton ApplyJob
     */
    @FXML
    private void butApplyJobClick()
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

    /**
     * Action sur click boutton validModif
     */
    @FXML
    private void butValidModifClick()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Save your new datas");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Accompagnateur newAccompagnateur = new Accompagnateur(_selectedAccompagnateur.get_idAccompagnateur(),
                    this.textFieldLastName.getText(),
                    this.textFieldFirstName.getText(),
                    this.textFieldPhoneNumber.getText(),
                    Integer.parseInt(this.textFieldStreetNumber.getText()),
                    this.textFieldStreet.getText(),
                    this.textFieldCity.getText(),
                    this.textFieldPostalCode.getText());

            if(TableManager.Instance().get_accompagnateurDAO().Edit(newAccompagnateur))
            {
                System.out.println(" => Accompagnateur successfully updated ...");
            }
        }
    }

    /**
     * Action sur click boutton delete
     */
    @FXML
    private void butDeleteClick()
    {
        Circuit newCircuit = this.tableViewCircuits.getSelectionModel().getSelectedItem();
        if(newCircuit != null)
        {
            if(TableManager.Instance().get_circuitDAO().Delete(newCircuit))
            {
                this.LoadGuideCircuits();
            }
        }
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
        int indexCircuits = 1;
        this._guideCircuits = FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try
        {
            resultSet = JdbcConnectionManager.Instance().get_connector().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE idAccompagnateur = "+_selectedAccompagnateur.get_idAccompagnateur());

            while (resultSet.next())
            {
                Circuit newCircuit = new Circuit(indexCircuits++,
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

        this.tableViewCircuits.setItems(_guideCircuits);
    }

    //endregion Private Services

    //region  Public Services

    //endregion Public Services
}
