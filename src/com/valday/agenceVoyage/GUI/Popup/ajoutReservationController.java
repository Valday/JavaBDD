package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.CircuitDAO;
import com.valday.agenceVoyage.DAO.ClientDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.DAO.ReservationDAO;
import com.valday.agenceVoyage.Table.Circuit;
import com.valday.agenceVoyage.Table.Client;
import com.valday.agenceVoyage.Table.Reservation;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import com.valday.agenceVoyage.managers.TableManager;
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
import java.util.ArrayList;
import java.util.List;

public class ajoutReservationController
{
    @FXML
    private ComboBox comboBox_client;

    @FXML
    private CheckBox  checkBox_accompteOk;

    @FXML
    private  CheckBox checkBox_secondPaiementOk;

    @FXML
    private TextField textField_montantAccompte;

    @FXML
    private TextField textField_montantSecondPaiement;

    @FXML
    private DatePicker datePicker_reservation;

    @FXML
    private  DatePicker datePicker_limite;

    @FXML
    private ComboBox comboBox_circuit;

    @FXML
    private Button but_Valider;

    @FXML
    private Button but_cancel;

    private ObservableList<String> _listNomClients;

    private ObservableList<String> _listNomCircuits;

    private List<Client> _listClients;

    private List<Circuit> _listCircuits;

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
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        int idClient = -1;
        int idCircuit = -1;

        for(int i = 0; i < this._listClients.size();i++)
        {
            if(this.comboBox_client.getSelectionModel().getSelectedItem().toString().contains(this._listClients.get(i).get_nameClient())
                    && this.comboBox_client.getSelectionModel().getSelectedItem().toString().contains(this._listClients.get(i).get_prenomClient()))
            {
                idClient = this._listClients.get(i).get_idClient();
            }
        }

        for(int i = 0; i < this._listCircuits.size();i++)
        {
            if(this.comboBox_circuit.getSelectionModel().getSelectedItem().toString().contains(this._listCircuits.get(i).get_nameCircuit()))
            {
                idCircuit = this._listCircuits.get(i).get_idCircuit();
            }
        }

        Reservation newReservation = new Reservation(TableManager.Instance().get_reservationDAO().Count()+1,
                this.checkBox_accompteOk.isSelected(),
                this.checkBox_secondPaiementOk.isSelected(),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePicker_limite.getValue())),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePicker_reservation.getValue())),
                false, Integer.parseInt(this.textField_montantAccompte.getText()),
                Integer.parseInt(this.textField_montantSecondPaiement.getText()),
                idClient, idCircuit);

        if(TableManager.Instance().get_reservationDAO().Add(newReservation))
        {
            System.out.println(" => Reservation successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }
    }

    @FXML
    private void initialize()
    {
        this.loadComboBoxValues();
    }

    private void loadComboBoxValues()
    {
        try
        {
            this._listNomClients = this.comboBox_client.getItems();
            this._listClients = new ArrayList<>();

            ResultSet allClients = TableManager.Instance().get_clientDAO().selectAll();

            while (allClients.next())
            {
                Client newClient = new Client(allClients.getInt(1),
                        allClients.getString(2),
                        allClients.getString(3),
                        allClients.getString(4),
                        allClients.getString(5),
                        allClients.getString(6),
                        allClients.getString(7),
                        allClients.getString(8),
                        allClients.getInt(9),
                        allClients.getString(10),
                        allClients.getString(11));

                this._listClients.add(newClient);
                this._listNomClients.add(newClient.get_nameClient()+" "+newClient.get_prenomClient());
            }

            this._listNomCircuits = this.comboBox_circuit.getItems();
            this._listCircuits = new ArrayList<>();

            ResultSet allCircuits = TableManager.Instance().get_circuitDAO().selectAll();

            while (allCircuits.next())
            {
                Circuit newCircuit = new Circuit(allCircuits.getInt(1),
                        allCircuits.getString(2),
                        allCircuits.getInt(3),
                        allCircuits.getInt(4),
                        allCircuits.getString(5),
                        allCircuits.getString(6),
                        allCircuits.getBoolean(7),
                        allCircuits.getInt(8));

                this._listCircuits.add(newCircuit);
                this._listNomCircuits.add(newCircuit.get_nameCircuit());
            }

            this.comboBox_client.setItems(this._listNomClients);
            this.comboBox_circuit.setItems(this._listNomCircuits);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void but_addClientClick()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutClient.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Client");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboBoxValues();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void but_addCircuitClick()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutCircuit.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Client");
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
