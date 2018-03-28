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
                    stage.showAndWait();
                    this.LoadTables();
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
                    stage.showAndWait();
                    this.LoadTables();
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
                    this.LoadTables();
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
                    this.LoadTables();
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
                    this.LoadTables();
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
    private void initialize()
    {
        this.LoadTables();
    }

    private void LoadTables()
    {
        tableView_Circuits.setItems(TableManager.LoadCircuits());
        tableView_Clients.setItems(TableManager.LoadClients());
        tableView_Hotels.setItems(TableManager.LoadHotels());
        tableView_Villes.setItems(TableManager.LoadVilles());
        tableView_Accompagnateurs.setItems(TableManager.LoadAccompagnateurs());
        tableView_Reservations.setItems(TableManager.LoadReservations());

        this.selectionModel = this.tabPane_main.getSelectionModel();
    }
}
