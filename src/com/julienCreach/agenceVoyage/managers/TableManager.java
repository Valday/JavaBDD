/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.managers;

import com.julienCreach.agenceVoyage.DAO.*;
import com.julienCreach.agenceVoyage.Modele.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe tablemanager.
 * @author Julien Creach
 * @version 1.0
 */
public final class TableManager
{
    //region Private Attributs

    /**
     * Instance de classe.
     */
    private volatile static TableManager _instance;

    /**
     * Liste des circuits pour l'affichage dans la table.
     */
    private ObservableList<Circuit> _circuitObservableList;

    /**
     * Liste des accompagnateurs pour l'affichage dans la table.
     */
    private ObservableList<Accompagnateur> _accompagnateurObservableList;

    /**
     * Liste des clients pour l'affichage dans la table.
     */
    private ObservableList<Client> _clientObservableList;

    /**
     * Liste des hotels pour l'affichage dans la table.
     */
    private ObservableList<Hotel> _hotelObservableList;

    /**
     * Liste des Reservations pour l'affichage dans la table.
     */
    private ObservableList<Reservation> _reservationObservableList;

    /**
     * Liste des villes pour l'affichage dans la table.
     */
    private ObservableList<Ville> _villeObservableList;

    /**
     * Liste des passwds pour l'affichage dans la table.
     */
    private ObservableList<Passwd> _passwdObservableList;

    /**
     * Liste des users pour l'affichage dans la table.
     */
    private ObservableList<User> _userObservableList;

    /**
     * DAO accompagnateur.
     */
    private static DAO<Accompagnateur> _accompagnateurDAO;

    /**
     * DAO  circuit.
     */
    private static DAO<Circuit> _circuitDAO;

    /**
     * DAO client.
     */
    private static DAO<Client> _clientDAO;

    /**
     * DAO hotel.
     */
    private static DAO<Hotel> _hotelDAO;

    /**
     * DAO ville.
     */
    private static DAO<Ville> _villeDAO;

    /**
     * DAO reservation.
     */
    private static DAO<Reservation> _reservationDAO;

    /**
     * DAO passwd.
     */
    private static DAO<Passwd> _passwdDAO;

    /**
     * DAO user.
     */
    private static DAO<User> _userDAO;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter DAO accompagnateur.
     * @return DAO accompagnateur
     */
    public DAO<Accompagnateur> get_accompagnateurDAO()
    {
        return _accompagnateurDAO;
    }

    /**
     * Getter DAO circuit.
     * @return DAO circuit
     */
    public DAO<Circuit> get_circuitDAO()
    {
        return _circuitDAO;
    }

    /**
     * Getter DAO client.
     * @return DAO client
     */
    public DAO<Client> get_clientDAO()
    {
        return _clientDAO;
    }

    /**
     * Getter DAO hotel.
     * @return DAO hotel
     */
    public DAO<Hotel> get_hotelDAO()
    {
        return _hotelDAO;
    }

    /**
     * Getter DAO ville.
     * @return DAO ville
     */
    public DAO<Ville> get_villeDAO()
    {
        return _villeDAO;
    }

    /**
     * Getter DAO reservation.
     * @return DAO reservation
     */
    public DAO<Reservation> get_reservationDAO()
    {
        return _reservationDAO;
    }

    /**
     * Getter DAO passwd.
     * @return DAO passwd
     */
    public DAO<Passwd> get_passwdDAO()
    {
        return _passwdDAO;
    }

    /**
     * Getter DAO user.
     * @return DAO user
     */
    public DAO<User> get_userDAO()
    {
        return _userDAO;
    }

    //endregion Public Attributs

    //region Constructor

    /**
     * Constructeur par defaut.
     */
    private TableManager()
    {

    }

    /**
     * Constructeur.
     * @return Instance de classe
     */
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

    /**
     * Initialisation des DAO.
     */
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

    /**
     * Chargement contenu de la table accompagnateur.
     * @return Liste d'accompagnateur
     */
    public ObservableList<Accompagnateur> LoadAccompagnateurs()
    {

        this._accompagnateurObservableList = FXCollections.observableArrayList();

        try
        {

            ResultSet allAccompagnateurs = _accompagnateurDAO.selectAll("Accompagnateurs");

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
                this._accompagnateurObservableList.add(newAccompagnateur);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this._accompagnateurObservableList;

    }

    /**
     * Chargement contenu de la table circuit.
     * @return Liste de circuit
     */
    public ObservableList<Circuit> LoadCircuits()
    {

        this._circuitObservableList = FXCollections.observableArrayList();

        try
        {

            ResultSet allCircuits = _circuitDAO.selectAll("Circuits");

            while (allCircuits.next())
            {
                Circuit newCircuit = new Circuit(allCircuits.getInt(1),
                        allCircuits.getString(2),
                        allCircuits.getInt(3),
                        allCircuits.getInt(4),
                        allCircuits.getString(5).substring(0,10),
                        allCircuits.getString(6).substring(0,10),
                        allCircuits.getBoolean(7),
                        allCircuits.getInt(8));

                this._circuitObservableList.add(newCircuit);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this._circuitObservableList;

    }

    /**
     * Chargement contenu de la table client.
     * @return Liste de client
     */
    public  ObservableList<Client> LoadClients()
    {

        this._clientObservableList = FXCollections.observableArrayList();

        try
        {
            ResultSet allClients = _clientDAO.selectAll("Clients");

            while (allClients.next())
            {
                Client newClient = new Client(allClients.getInt(1),
                        allClients.getString(2),
                        allClients.getString(3),
                        allClients.getString(4),
                        allClients.getString(5),
                        allClients.getString(6),
                        allClients.getInt(7),
                        allClients.getString(8),
                        allClients.getString(9).substring(0,10));

                this._clientObservableList.add(newClient);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._clientObservableList;
    }

    /**
     * Chargement contenu de la table hotel.
     * @return Liste d'hotel
     */
    public ObservableList<Hotel> LoadHotels()
    {

        this._hotelObservableList = FXCollections.observableArrayList();

        try
        {
            ResultSet allHotels = _hotelDAO.selectAll("Hotels");

            while(allHotels.next())
            {
                Hotel newHotel = new Hotel(allHotels.getInt(1),
                        allHotels.getString(2),
                        allHotels.getString(3),
                        allHotels.getString(4),
                        allHotels.getInt(5));

                this._hotelObservableList.add(newHotel);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._hotelObservableList;
    }

    /**
     * Chargement contenu de la table ville.
     * @return Liste de ville
     */
    public ObservableList<Ville> LoadVilles()
    {

        this._villeObservableList = FXCollections.observableArrayList();

        try
        {
            ResultSet allVilles = _villeDAO.selectAll("Villes");

            while(allVilles.next())
            {
                Ville newVille = new Ville(allVilles.getInt(1),
                        allVilles.getString(2),
                        allVilles.getInt(3));

                this._villeObservableList.add(newVille);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._villeObservableList;
    }

    /**
     * Chargement contenu de la table reservation.
     * @return Liste de reservation
     */
    public ObservableList<Reservation> LoadReservations()
    {

        this._reservationObservableList = FXCollections.observableArrayList();

        try
        {
            ResultSet allReservations = _reservationDAO.selectAll("Reservations");

            while (allReservations.next())
            {
                Reservation newReservation = new Reservation(allReservations.getInt(1),
                        allReservations.getBoolean(2),
                        allReservations.getBoolean(3),
                        allReservations.getString(4).substring(0,10),
                        allReservations.getString(5).substring(0,10),
                        allReservations.getBoolean(6),
                        allReservations.getInt(7),
                        allReservations.getInt(8),
                        allReservations.getInt(9),
                        allReservations.getInt(10));

                this._reservationObservableList.add(newReservation);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._reservationObservableList;
    }

    /**
     * Chargement contenu de la table passwd.
     * @return Liste de passwd
     */
    public ObservableList<Passwd> LoadPasswd()
    {

        this._passwdObservableList = FXCollections.observableArrayList();

        try
        {
            ResultSet allPasswd = _passwdDAO.selectAll("passwds");

            while(allPasswd.next())
            {
                Passwd newPasswd = new Passwd(allPasswd.getInt(1),
                        allPasswd.getString(2),
                        allPasswd.getString(3),
                        allPasswd.getInt(4));

                this._passwdObservableList.add(newPasswd);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return this._passwdObservableList;
    }

    /**
     * Chargement contenu de la table user.
     * @return Liste de user
     */
    public ObservableList<User> LoadUser()
    {

        this._userObservableList = FXCollections.observableArrayList();

        try
        {
            ResultSet allUser = _userDAO.selectAll("Users");

            while(allUser.next())
            {
                User newUser= new User(allUser.getInt(1),
                        allUser.getInt(2),
                        allUser.getInt(3),
                        allUser.getInt(4));

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
