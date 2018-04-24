/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import com.julienCreach.agenceVoyage.GUI.Popup.bookNowController;
import com.julienCreach.agenceVoyage.Modele.Client;
import com.julienCreach.agenceVoyage.Modele.Reservation;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

public class customerWindowController
{
    //region Private Attributs

    /**
     * Client Selectionné
     */
    private static Client _selectedClient;

    /**
     * Liste des réservations
     */
    private ObservableList<Reservation> _customerReservations;

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
     * Champ de saisie Ville
     */
    @FXML
    private TextField textFieldCity;

    /**
     * Modele Permettant d'afficher les réserations du client
     */
    @FXML
    private TableView<Reservation> tableViewReservations;

    //endregion Private Attributs

    //region Public Attributs

    /**
    * Assesseur sur le client selectioné
    * @param _selectedClient client a afficher
    */
    public static void set_selectedClient(Client _selectedClient)
    {
        customerWindowController._selectedClient = _selectedClient;
    }

    //endregion Public Attributs

    //region Private Services

    /**
     * Initialisation du contenu de la fenetre
     */
    @FXML
    private void initialize()
    {
        this.LoadValues();
    }

    /**
     * Actions sur click bouton butBook
     */
    @FXML
    private void butBookClick()
    {
        try
        {
            bookNowController.set_actualClient(_selectedClient);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/bookNow.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Book now");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.LoadCustomerReservations();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Actions sur click bouton butDelete
     */
    @FXML
    private void butDeleteClick()
    {
        Reservation newReservation = this.tableViewReservations.getSelectionModel().getSelectedItem();
        if(newReservation != null)
        {
            if(TableManager.Instance().get_reservationDAO().Delete(newReservation))
            {
                this.LoadCustomerReservations();
            }
        }
    }

    /**
     * Actions sur click bouton butValid
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
            SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
            Client newClient = new Client(_selectedClient.get_idClient(),
                    this.textFieldLastName.getText(),
                    this.textFieldFirstName.getText(),
                    this.textFieldPhoneNumber.getText(),
                    this.textFieldCity.getText(),
                    this.textFieldStreet.getText(),
                    Integer.parseInt(this.textFieldStreetNumber.getText()),
                    this.textFieldPostalCode.getText(),
                    simpleDateFormater.format(java.sql.Date.valueOf(this.datePickerBirthDate.getValue())));

            if(TableManager.Instance().get_clientDAO().Edit(newClient))
            {
                System.out.println(" => Client successfully updated ...");
            }
        }

    }

    /**
     * Action sur le menuItem quitter de la menu bar
     */
    @FXML
    private void menuItemQuitClick()
    {
        System.exit(0);
    }

    /**
     * Charge les données pour l'affichage dans la page de profil
     */
    private void LoadValues()
    {
        this.textFieldLastName.setText(_selectedClient.get_nameClient());
        this.textFieldFirstName.setText(_selectedClient.get_prenomClient());
        this.datePickerBirthDate.setValue(LocalDate.parse(_selectedClient.get_dateNaissanceClient().substring(0,10)));
        this.textFieldPhoneNumber.setText(_selectedClient.get_telephoneClient());
        this.textFieldStreetNumber.setText(Integer.toString(_selectedClient.get_numRueClient()));
        this.textFieldStreet.setText(_selectedClient.get_rueClient());
        this.textFieldPostalCode.setText(_selectedClient.get_codePostalClient());
        this.textFieldCity.setText(_selectedClient.get_villeClient());

        this.LoadCustomerReservations();
    }

    /**
     * Recherche toute les réservations pour le client connecté et met à jour la tableview
     */
    private void LoadCustomerReservations()
    {
        int indexReservations = 1;
        this._customerReservations = FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try
        {
            resultSet = JdbcConnectionManager.Instance().get_connector().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservations WHERE idClient = "+_selectedClient.get_idClient());

            while (resultSet.next())
            {
                Reservation newReservation = new Reservation(indexReservations++,
                        resultSet.getBoolean(2),
                        resultSet.getBoolean(3),
                        resultSet.getString(4).substring(0,10),
                        resultSet.getString(5).substring(0,10),
                        resultSet.getBoolean(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10));

                this._customerReservations.add(newReservation);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        this.tableViewReservations.setItems(_customerReservations);
    }

    //endregion private Services
}
