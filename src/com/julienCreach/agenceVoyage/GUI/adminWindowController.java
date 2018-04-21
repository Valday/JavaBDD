/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import com.julienCreach.agenceVoyage.GUI.Popup.*;
import com.julienCreach.agenceVoyage.Table.*;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class adminWindowController
{
    //region Private Attributs

    /**
     * selection model du TabPane.
     */
    private SingleSelectionModel<Tab> selectionModel;

    /**
     * TabPane principal.
     */
    @FXML
    private TabPane tabPane_main;

    /**
     * Datagrid circuits.
     */
    @FXML
    private TableView<Circuit> tableView_Circuits;

    /**
     * Datagrid Clients.
     */
    @FXML
    private TableView<Client> tableView_Clients;

    /**
     * Datagrid Hotels.
     */
    @FXML
    private TableView<Hotel> tableView_Hotels;

    /**
     * Datagrid Villes.
     */
    @FXML
    private TableView<Ville> tableView_Villes;

    /**
     * Datagrid Accompagnateurs.
     */
    @FXML
    private TableView<Accompagnateur> tableView_Accompagnateurs;

    /**
     * Datagrid Reservations.
     */
    @FXML
    private TableView<Reservation> tableView_Reservations;

    /**
     * Boutton exit de la barre de menu.
     */
    @FXML
    private MenuItem menuItem_Quit;

    //endregion Private Attributs

    //region Public Attributs

    //endregion Public Attributs

    //region Constructors / Initialisation

    /**
     * Constructeur par defaut
     */
    public adminWindowController()
    {
    }

    //endregion Constructors / Initialisation

    //region Private Services

    //region FXML

    /**
     * Actions au click sur le menuitem quit.
     */
    @FXML
    private void menuItem_QuitClick()
    {
        System.exit(0);
    }

    /**
     * Actions sur bouton de suppression
     */
    @FXML
    private void but_SuprClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0:
                System.out.println(" => Supression Circuit ...");
                Circuit newCircuit = tableView_Circuits.getSelectionModel().getSelectedItem();
                if(newCircuit != null)
                {
                    TableManager.Instance().get_circuitDAO().Delete(newCircuit);
                }
                break;

            case 1 :
                System.out.println(" => Supression Client ...");
                Client newClient = tableView_Clients.getSelectionModel().getSelectedItem();
                if(newClient != null)
                {

                    TableManager.Instance().get_clientDAO().Delete(newClient);
                }
                break;
            case 2 :
                System.out.println(" => Supression Hotel ...");
                Hotel newHotel = tableView_Hotels.getSelectionModel().getSelectedItem();
                if(newHotel != null)
                {
                    TableManager.Instance().get_hotelDAO().Delete(newHotel);
                }
                break;
            case 3 :
                System.out.println(" => Supression Ville ...");
                Ville newVille = tableView_Villes.getSelectionModel().getSelectedItem();
                if(newVille != null)
                {
                    TableManager.Instance().get_villeDAO().Delete(newVille);
                }
                break;
            case 4 :
                System.out.println(" => Supression Accompagnateur ...");
                Accompagnateur newAccompagnateur = tableView_Accompagnateurs.getSelectionModel().getSelectedItem();
                if(newAccompagnateur != null)
                {
                    TableManager.Instance().get_accompagnateurDAO().Delete(newAccompagnateur);
                }
                break;
            case 5 :
                System.out.println(" => Supression Reservation ...");
                Reservation newReservation = tableView_Reservations.getSelectionModel().getSelectedItem();
                if(newReservation != null)
                {
                    TableManager.Instance().get_reservationDAO().Delete(newReservation);
                }
                break;
        }
        this.LoadTables();
    }

    /**
     * Actions sur bouton d'ajout
     */
    @FXML
    private void but_AjoutClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0 :
                System.out.println(" => Tab Circuits ...");
                try
                {
                    ajoutCircuitController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutCircuit.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Circuit");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 1 :
                System.out.println(" => Tab Clients ...");
                try
                {
                    ajoutClientController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutClient.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Client");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 2 :
                System.out.println(" => Tab Hotels ...");
                try
                {
                    ajoutHotelController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutHotel.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Hotel");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 3 :
                System.out.println(" => Tab Villes ...");
                try
                {
                    ajoutVilleController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutVille.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Ville");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 4 :
                System.out.println(" => Tab Accompagnateurs ...");
                try
                {
                    ajoutAccompagnateurController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutAccompagnateur.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Accompagnateur");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 5 :
                System.out.println(" => Tab Reservations ...");
                try
                {
                    ajoutReservationController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutReservation.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Reservation");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.LoadTables();
    }

    /**
     * Actions sur bouton d'edition
     */
    @FXML
    private void but_EditClick()
    {
        try
        {

            switch (selectionModel.getSelectedIndex())
            {
                case 0:
                    try
                    {
                        ajoutCircuitController.setIsNewOrEdit(false);
                        ajoutCircuitController.set_selectedCircuit(tableView_Circuits.getSelectionModel().getSelectedItem());

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutCircuit.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Circuit");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                case 1 :
                    try
                    {
                        ajoutClientController.setIsNewOrEdit(false);
                        ajoutClientController.set_selectedClient(tableView_Clients.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutClient.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Client");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                            catch (LoadException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 2 :
                    try
                    {
                        ajoutHotelController.setIsNewOrEdit(false);
                        ajoutHotelController.set_selectedHotel(tableView_Hotels.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutHotel.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Hotel");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                     catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 3 :
                    try
                    {
                        ajoutVilleController.setIsNewOrEdit(false);
                        ajoutVilleController.set_selectedVille(tableView_Villes.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutVille.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Ville");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 4 :
                    try
                    {
                        ajoutAccompagnateurController.setIsNewOrEdit(false);
                        ajoutAccompagnateurController.set_selectedAccompagnateur(tableView_Accompagnateurs.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutAccompagnateur.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Accompagnateur");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 5 :
                    try
                    {
                        ajoutReservationController.setIsNewOrEdit(false);
                        ajoutReservationController.set_selectedReservation(tableView_Reservations.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutReservation.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Reservation");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        this.LoadTables();
    }

    /**
     * Initialisation des datas dans la fentere.
     */
    @FXML
    private void initialize()
    {
        this.LoadTables();
    }

    /**
     * Actions au double click sur un élément de la grid.
     * @param event
     */
    @FXML
    private void tableViewDoubleClick(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
        {
            switch (selectionModel.getSelectedIndex())
            {
                case 1 :
                    try
                    {
                        Client client = tableView_Clients.getSelectionModel().getSelectedItem();
                        customerWindowController.set_selectedClient(client);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerWindow.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle(client.get_prenomClient() + " " + client.get_nameClient());
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 4 :
                    try
                    {
                        Accompagnateur accompagnateur = tableView_Accompagnateurs.getSelectionModel().getSelectedItem();
                        guideWindowController.set_selectedAccompagnateur(accompagnateur);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guideWindow.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle(accompagnateur.get_prenomAccompagnateur()+" "+accompagnateur.get_nameAccompagnateur());
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;

                default:
                    break;
            }
        }
    }

    //endregion FXML

    /**
     * Chargement du contenu des tables de la base de donnée
     */
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
