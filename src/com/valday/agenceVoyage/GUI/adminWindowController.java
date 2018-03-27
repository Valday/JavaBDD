package com.valday.agenceVoyage.GUI;

import com.valday.agenceVoyage.DAO.*;
import com.valday.agenceVoyage.Table.*;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
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

public class adminWindowController
{
    //region Private Attributs

    private ObservableList<Circuit> circuitObservableList;
    private ObservableList<Accompagnateur> accompagnateurObservableList;
    private ObservableList<Client> clientObservableList;
    private ObservableList<Hotel> hotelObservableList;
    private ObservableList<Reservation> reservationObservableList;
    private ObservableList<Ville> villeObservableList;
   //private ObservableList<Visite> visiteObservableList;

    //endregion Private Attributs

    //region Public Attributs


    //endregion Public Attributs

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

    @FXML
    public void menuItem_QuitClick()
    {
        System.exit(0);
    }

    @FXML void but_SuprClick()
    {
    }

    @FXML void but_AjoutClick()
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
                    stage.show();
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
                    stage.setTitle("Ajout Hotel");
                    stage.setScene(new Scene(root));
                    stage.show();
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
                    stage.show();
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
                    stage.show();
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
                    stage.show();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 5 :
                System.out.println(" => Tab Reservations ...");
                break;
        }
    }

    @FXML
    private void initialize() throws SQLException {
        circuitObservableList = FXCollections.observableArrayList();
        clientObservableList = FXCollections.observableArrayList();
        hotelObservableList = FXCollections.observableArrayList();
        villeObservableList = FXCollections.observableArrayList();
        accompagnateurObservableList = FXCollections.observableArrayList();
        reservationObservableList = FXCollections.observableArrayList();

        DAO<Circuit> circuitDAO = new CircuitDAO(JdbcConnectionManager.Instance().get_connector());
        ResultSet allCircuits = circuitDAO.selectAll();
        //ResultSetMetaData allCircuitsMetaData = allCircuits.getMetaData();

        DAO<Client> clientDAO = new ClientDAO(JdbcConnectionManager.Instance().get_connector());
        ResultSet allClients = clientDAO.selectAll();

        DAO<Hotel> hotelDAO = new HotelDAO(JdbcConnectionManager.Instance().get_connector());
        ResultSet allHotels = hotelDAO.selectAll();

        DAO<Ville> villeDAO = new VilleDAO(JdbcConnectionManager.Instance().get_connector());
        ResultSet allVilles = villeDAO.selectAll();

        DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
        ResultSet allAccompagnateurs = accompagnateurDAO.selectAll();

        DAO<Reservation> reservationDAO = new ReservationDAO(JdbcConnectionManager.Instance().get_connector());
        ResultSet allReservations = reservationDAO.selectAll();

        while (allCircuits.next())
        {
            Circuit newCircuit = new Circuit(allCircuits.getInt(1),allCircuits.getString(2),allCircuits.getInt(3),allCircuits.getDate(4),allCircuits.getDate(5),allCircuits.getBoolean(6));
            circuitObservableList.add(newCircuit);
        }

        while (allClients.next())
        {
            Client newClient = new Client(allClients.getInt(1),allClients.getString(2));
            clientObservableList.add(newClient);
        }

        while(allHotels.next())
        {
            Hotel newHotel = new Hotel(allHotels.getInt(1), allHotels.getString(2));
            hotelObservableList.add(newHotel);
        }

        while(allVilles.next())
        {
            Ville newVille = new Ville(allVilles.getInt(1), allVilles.getString(2));
            villeObservableList.add(newVille);
        }

        while (allAccompagnateurs.next())
        {
            Accompagnateur newAccompagnateur = new Accompagnateur(allAccompagnateurs.getInt(1), allAccompagnateurs.getString(2));
            accompagnateurObservableList.add(newAccompagnateur);
        }

        while (allReservations.next())
        {
            Reservation newReservation = new Reservation(allReservations.getInt(1),allReservations.getBoolean(2),allReservations.getBoolean(3),allReservations.getInt(4),allReservations.getInt(5),allReservations.getDate(6),allReservations.getDate(7),allReservations.getBoolean(8),allReservations.getInt(9),allReservations.getInt(10));
            reservationObservableList.add(newReservation);
        }

        tableView_Circuits.setItems(circuitObservableList);
        tableView_Clients.setItems(clientObservableList);
        tableView_Hotels.setItems(hotelObservableList);
        tableView_Villes.setItems(villeObservableList);
        tableView_Accompagnateurs.setItems(accompagnateurObservableList);
        tableView_Reservations.setItems(reservationObservableList);

        this.selectionModel = this.tabPane_main.getSelectionModel();
    }
}
