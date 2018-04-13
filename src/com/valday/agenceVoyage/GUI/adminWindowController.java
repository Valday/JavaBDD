package com.valday.agenceVoyage.GUI;

import com.valday.agenceVoyage.Table.*;
import com.valday.agenceVoyage.managers.TableManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class adminWindowController
{
    //region Private Attributs

    private SingleSelectionModel<Tab> selectionModel;

    @FXML
    private TabPane tabPane_main;

    @FXML
    private TableView<Circuit> tableView_Circuits;

    @FXML
    private TableView<Client> tableView_Clients;

    @FXML
    private TableView<Hotel> tableView_Hotels;

    @FXML
    private TableView<Ville> tableView_Villes;

    @FXML
    private TableView<Accompagnateur> tableView_Accompagnateurs;

    @FXML
    private TableView<Reservation> tableView_Reservations;

    @FXML
    private MenuItem menuItem_Quit;

    //endregion Private Attributs

    //region Public Attributs

    //endregion Public Attributs

    //region Private Services

    //region Constructors / Initialisation


    //endregion Constructors / Initialisation

    //region Private Services

    //region FXML

    @FXML
    private void menuItem_QuitClick()
    {
        System.exit(0);
    }

    @FXML
    private void but_SuprClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0:
                System.out.println(" => Supression Circuit ...");
                Circuit newCircuit = tableView_Circuits.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_circuitDAO().Delete(newCircuit);
                break;

            case 1 :
                System.out.println(" => Supression Client ...");
                Client newClient = tableView_Clients.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_clientDAO().Delete(newClient);
                break;
            case 2 :
                System.out.println(" => Supression Hotel ...");
                Hotel newHotel = tableView_Hotels.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_hotelDAO().Delete(newHotel);
                break;
            case 3 :
                System.out.println(" => Supression Ville ...");
                Ville newVille = tableView_Villes.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_villeDAO().Delete(newVille);
                break;
            case 4 :
                System.out.println(" => Supression Accompagnateur ...");
                Accompagnateur newAccompagnateur = tableView_Accompagnateurs.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_accompagnateurDAO().Delete(newAccompagnateur);
                break;
            case 5 :
                System.out.println(" => Supression Reservation ...");
                Reservation newReservation = tableView_Reservations.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_reservationDAO().Delete(newReservation);
                break;
        }
        this.LoadTables();
    }

    @FXML
    private void but_AjoutClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0 :
                System.out.println(" => Tab Circuits ...");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutCircuit.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Ajout Circuit");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 1 :
                System.out.println(" => Tab Clients ...");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutClient.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Ajout Client");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 2 :
                System.out.println(" => Tab Hotels ...");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutHotel.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Ajout Hotel");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 3 :
                System.out.println(" => Tab Villes ...");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutVille.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Ajout Ville");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 4 :
                System.out.println(" => Tab Accompagnateurs ...");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutAccompagnateur.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Ajout Accompagnateur");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 5 :
                System.out.println(" => Tab Reservations ...");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutReservation.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Ajout Reservation");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
        this.LoadTables();
    }

    @FXML
    private void but_EditClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0:
                Circuit newCircuit = tableView_Circuits.getSelectionModel().getSelectedItem();
                TableManager.Instance().get_circuitDAO().Edit(newCircuit);
                break;
            case 1 :
                break;
            case 2 :
                break;
            case 3 :
                break;
            case 4 :
                break;
            case 5 :
                break;
        }

    }

    @FXML
    private void initialize()
    {
        this.LoadTables();
    }


    //endregion FXML

    private void LoadTables()
    {
        this.tableView_Circuits.setItems(TableManager.Instance().LoadCircuits());
        this.tableView_Clients.setItems(TableManager.Instance().LoadClients());
        this.tableView_Hotels.setItems(TableManager.Instance().LoadHotels());
        this.tableView_Villes.setItems(TableManager.Instance().LoadVilles());
        this.tableView_Accompagnateurs.setItems(TableManager.Instance().LoadAccompagnateurs());
        this.tableView_Reservations.setItems(TableManager.Instance().LoadReservations());

        this.selectionModel = this.tabPane_main.getSelectionModel();
    }

    //endregion Private Services
}
