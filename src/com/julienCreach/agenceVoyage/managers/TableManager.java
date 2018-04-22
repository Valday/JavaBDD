/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.managers;

import com.julienCreach.agenceVoyage.DAO.*;
import com.julienCreach.agenceVoyage.Table.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class TableManager
{
    //region Private Attributs

    private volatile static TableManager _instance;

    private ObservableList<Circuit> _circuitObservableList;

    private ObservableList<Accompagnateur> _accompagnateurObservableList;

    private ObservableList<Client> _clientObservableList;

    private ObservableList<Hotel> _hotelObservableList;

    private ObservableList<Reservation> _reservationObservableList;

    private ObservableList<Ville> _villeObservableList;

    private ObservableList<Passwd> _passwdObservableList;

    private ObservableList<User> _userObservableList;

    private static DAO<Accompagnateur> _accompagnateurDAO;

    private static DAO<Circuit> _circuitDAO;

    private static DAO<Client> _clientDAO;

    private static DAO<Hotel> _hotelDAO;

    private static DAO<Ville> _villeDAO;

    private static DAO<Reservation> _reservationDAO;

    private static DAO<Passwd> _passwdDAO;

    private static DAO<User> _userDAO;

    private ResultSet _allAccompagnateurs;

    private ResultSet _allCircuits;

    private ResultSet _allClients;

    private ResultSet _allHotels;

    private ResultSet _allVilles;

    private ResultSet _allReservations;

    private ResultSet _allPasswd;

    private ResultSet _allUser;

    //endregion Private Attributs

    //region Public Attributs

    public DAO<Accompagnateur> get_accompagnateurDAO()
    {
        return _accompagnateurDAO;
    }

    public DAO<Circuit> get_circuitDAO()
    {
        return _circuitDAO;
    }

    public DAO<Client> get_clientDAO()
    {
        return _clientDAO;
    }

    public DAO<Hotel> get_hotelDAO()
    {
        return _hotelDAO;
    }

    public DAO<Ville> get_villeDAO()
    {
        return _villeDAO;
    }

    public DAO<Reservation> get_reservationDAO()
    {
        return _reservationDAO;
    }

    public DAO<Passwd> get_passwdDAO()
    {
        return _passwdDAO;
    }

    public DAO<User> get_userDAO()
    {
        return _userDAO;
    }

    //endregion Public Attributs

    //region Constructor

    private TableManager()
    {

    }

    public static TableManager Instance()
    {
        if (_instance == null)
        {
            synchronized(TableManager.class){
                if(_instance == null)
                {
                    _instance = new TableManager();
                    initDAO();
                }
            }
        }
        return _instance;
    }

    private static void initDAO()
    {
        _accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
        _circuitDAO = new CircuitDAO(JdbcConnectionManager.Instance().get_connector());
        _clientDAO = new ClientDAO(JdbcConnectionManager.Instance().get_connector());
        _hotelDAO = new HotelDAO(JdbcConnectionManager.Instance().get_connector());
        _reservationDAO = new ReservationDAO(JdbcConnectionManager.Instance().get_connector());
        _villeDAO = new VilleDAO(JdbcConnectionManager.Instance().get_connector());
        _passwdDAO = new PasswdDAO(JdbcConnectionManager.Instance().get_connector());
        _userDAO = new UserDAO(JdbcConnectionManager.Instance().get_connector());
    }

    //endregion Services

    //region Private Services


    //endregion Private Services

    //region Public Services

    public ObservableList<Accompagnateur> LoadAccompagnateurs()
    {

        this._accompagnateurObservableList = FXCollections.observableArrayList();

        try
        {

            this._allAccompagnateurs = this._accompagnateurDAO.selectAll("Accompagnateurs");

            while (this._allAccompagnateurs.next())
            {
                Accompagnateur newAccompagnateur = new Accompagnateur(this._allAccompagnateurs.getInt(1),
                        this._allAccompagnateurs.getString(2),
                        this._allAccompagnateurs.getString(3),
                        this._allAccompagnateurs.getString(4),
                        this._allAccompagnateurs.getInt(5),
                        this._allAccompagnateurs.getString(6),
                        this._allAccompagnateurs.getString(7),
                        this._allAccompagnateurs.getString(8));
                this._accompagnateurObservableList.add(newAccompagnateur);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this._accompagnateurObservableList;

    }

    public ObservableList<Circuit> LoadCircuits()
    {

        this._circuitObservableList = FXCollections.observableArrayList();

        try
        {

            this._allCircuits = this._circuitDAO.selectAll("Circuits");

            while (this._allCircuits.next())
            {
                Circuit newCircuit = new Circuit(this._allCircuits.getInt(1),
                        this._allCircuits.getString(2),
                        this._allCircuits.getInt(3),
                        this._allCircuits.getInt(4),
                        this._allCircuits.getString(5).substring(0,10),
                        this._allCircuits.getString(6).substring(0,10),
                        this._allCircuits.getBoolean(7),
                        this._allCircuits.getInt(8));

                this._circuitObservableList.add(newCircuit);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this._circuitObservableList;

    }

    public  ObservableList<Client> LoadClients()
    {

        this._clientObservableList = FXCollections.observableArrayList();

        try
        {
            this._allClients = this._clientDAO.selectAll("Clients");

            while (this._allClients.next())
            {
                Client newClient = new Client(this._allClients.getInt(1),
                        this._allClients.getString(2),
                        this._allClients.getString(3),
                        this._allClients.getString(4),
                        this._allClients.getString(5),
                        this._allClients.getString(6),
                        this._allClients.getInt(7),
                        this._allClients.getString(8),
                        this._allClients.getString(9).substring(0,10));

                this._clientObservableList.add(newClient);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._clientObservableList;
    }

    public ObservableList<Hotel> LoadHotels()
    {

        this._hotelObservableList = FXCollections.observableArrayList();

        try
        {
            this._allHotels = this._hotelDAO.selectAll("Hotels");

            while(this._allHotels.next())
            {
                Hotel newHotel = new Hotel(this._allHotels.getInt(1),
                        this._allHotels.getString(2),
                        this._allHotels.getString(3),
                        this._allHotels.getString(4),
                        this._allHotels.getInt(5));

                this._hotelObservableList.add(newHotel);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._hotelObservableList;
    }

    public ObservableList<Ville> LoadVilles()
    {

        this._villeObservableList = FXCollections.observableArrayList();

        try
        {
            this._allVilles = this._villeDAO.selectAll("Villes");

            while(this._allVilles.next())
            {
                Ville newVille = new Ville(this._allVilles.getInt(1),
                        this._allVilles.getString(2),
                        this._allVilles.getInt(3));

                this._villeObservableList.add(newVille);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._villeObservableList;
    }

    public ObservableList<Reservation> LoadReservations()
    {

        this._reservationObservableList = FXCollections.observableArrayList();

        try
        {
            this._allReservations = this._reservationDAO.selectAll("Reservations");

            while (this._allReservations.next())
            {
                Reservation newReservation = new Reservation(this._allReservations.getInt(1),
                        this._allReservations.getBoolean(2),
                        this._allReservations.getBoolean(3),
                        this._allReservations.getString(4).substring(0,10),
                        this._allReservations.getString(5).substring(0,10),
                        this._allReservations.getBoolean(6),
                        this._allReservations.getInt(7),
                        this._allReservations.getInt(8),
                        this._allReservations.getInt(9),
                        this._allReservations.getInt(10));

                this._reservationObservableList.add(newReservation);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._reservationObservableList;
    }

    public ObservableList<Passwd> LoadPasswd()
    {

        this._passwdObservableList = FXCollections.observableArrayList();

        try
        {
            this._allPasswd = this._passwdDAO.selectAll("passwds");

            while(this._allPasswd.next())
            {
                Passwd newPasswd = new Passwd(this._allPasswd.getInt(1),
                        this._allPasswd.getString(2),
                        this._allPasswd.getString(3),
                        this._allPasswd.getInt(4));

                this._passwdObservableList.add(newPasswd);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._passwdObservableList;
    }

    public ObservableList<User> LoadUser()
    {

        this._userObservableList = FXCollections.observableArrayList();

        try
        {
            this._allUser = this._userDAO.selectAll("Users");

            while(this._allUser.next())
            {
                User newUser= new User(this._allUser.getInt(1),
                        this._allUser.getInt(2),
                        this._allUser.getInt(3),
                        this._allUser.getInt(4));

                this._userObservableList.add(newUser);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._userObservableList;
    }

    //endregion Public Services
}
