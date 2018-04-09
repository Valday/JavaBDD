package com.valday.agenceVoyage.managers;

import com.valday.agenceVoyage.DAO.*;
import com.valday.agenceVoyage.Table.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableManager
{

    //region Private Attributs

    private static ObservableList<Circuit> circuitObservableList;

    private static ObservableList<Accompagnateur> accompagnateurObservableList;

    private static ObservableList<Client> clientObservableList;

    private static ObservableList<Hotel> hotelObservableList;

    private static ObservableList<Reservation> reservationObservableList;

    private static ObservableList<Ville> villeObservableList;

    //endregion Private Attributs

    //region Public Attributs



    //endregion Public Attributs

    //region Constructor

    private TableManager()
    {

    }

    //endregion Services

    //region Private Services



    //endregion Private Services

    //region Public Services

    public static ObservableList<Accompagnateur> LoadAccompagnateurs()
    {

        accompagnateurObservableList = FXCollections.observableArrayList();

        try
        {

            DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allAccompagnateurs = accompagnateurDAO.selectAll();

            while (allAccompagnateurs.next())
            {
                Accompagnateur newAccompagnateur = new Accompagnateur(allAccompagnateurs.getInt(1),
                        allAccompagnateurs.getString(2),
                        allAccompagnateurs.getString(3),
                        allAccompagnateurs.getString(4),
                        allAccompagnateurs.getInt(5),
                        allAccompagnateurs.getString(6),
                        allAccompagnateurs.getString(7),
                        allAccompagnateurs.getString(8));
                accompagnateurObservableList.add(newAccompagnateur);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return accompagnateurObservableList;

    }

    public static ObservableList<Circuit> LoadCircuits()
    {

        circuitObservableList = FXCollections.observableArrayList();

        try
        {

            DAO<Circuit> circuitDAO = new CircuitDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allCircuits = circuitDAO.selectAll();

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

                circuitObservableList.add(newCircuit);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return circuitObservableList;

    }

    public static ObservableList<Client> LoadClients()
    {

        clientObservableList = FXCollections.observableArrayList();

        try
        {
            DAO<Client> clientDAO = new ClientDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allClients = clientDAO.selectAll();

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

                clientObservableList.add(newClient);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return clientObservableList;
    }

    public static ObservableList<Hotel> LoadHotels()
    {

        hotelObservableList = FXCollections.observableArrayList();

        try
        {
            DAO<Hotel> hotelDAO = new HotelDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allHotels = hotelDAO.selectAll();

            while(allHotels.next())
            {
                Hotel newHotel = new Hotel(allHotels.getInt(1),
                        allHotels.getString(2),
                        allHotels.getString(3),
                        allHotels.getString(4),
                        allHotels.getInt(5));

                hotelObservableList.add(newHotel);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return hotelObservableList;
    }

    public static ObservableList<Ville> LoadVilles()
    {

        villeObservableList = FXCollections.observableArrayList();

        try
        {
            DAO<Ville> villeDAO = new VilleDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allVilles = villeDAO.selectAll();

            while(allVilles.next())
            {
                Ville newVille = new Ville(allVilles.getInt(1),
                        allVilles.getString(2),
                        allVilles.getInt(3));

                villeObservableList.add(newVille);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return villeObservableList;
    }

    public static ObservableList<Reservation> LoadReservations()
    {

        reservationObservableList = FXCollections.observableArrayList();

        try
        {
            DAO<Reservation> reservationDAO = new ReservationDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allReservations = reservationDAO.selectAll();

            while (allReservations.next())
            {
                Reservation newReservation = new Reservation(allReservations.getInt(1),
                        allReservations.getBoolean(2),
                        allReservations.getBoolean(3),
                        allReservations.getString(4),
                        allReservations.getString(5),
                        allReservations.getBoolean(6),
                        allReservations.getInt(7),
                        allReservations.getInt(8),
                        allReservations.getInt(9),
                        allReservations.getInt(10));

                reservationObservableList.add(newReservation);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return reservationObservableList;
    }

    //endregion Public Services


}
