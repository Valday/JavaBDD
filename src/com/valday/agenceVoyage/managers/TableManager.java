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

    private volatile static TableManager _instance;

    private ObservableList<Circuit> _circuitObservableList;

    private ObservableList<Accompagnateur> _accompagnateurObservableList;

    private ObservableList<Client> _clientObservableList;

    private ObservableList<Hotel> _hotelObservableList;

    private ObservableList<Reservation> _reservationObservableList;

    private ObservableList<Ville> _villeObservableList;

    private static DAO<Accompagnateur> _accompagnateurDAO;

    private static DAO<Circuit> _circuitDAO;

    private static DAO<Client> _clientDAO;

    private static DAO<Hotel> _hotelDAO;

    private static DAO<Ville> _villeDAO;

    private static DAO<Reservation> _reservationDAO;

    private ResultSet _allAccompagnateurs;

    private ResultSet _allCircuits;

    private ResultSet _allClients;

    private ResultSet _allHotels;

    private ResultSet _allVilles;

    private ResultSet _allReservations;

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


    //endregion Public Attributs

    //region Constructor

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

            this._allAccompagnateurs = this._accompagnateurDAO.selectAll();

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

            this._allCircuits = this._circuitDAO.selectAll();

            while (this._allCircuits.next())
            {
                Circuit newCircuit = new Circuit(this._allCircuits.getInt(1),
                        this._allCircuits.getString(2),
                        this._allCircuits.getInt(3),
                        this._allCircuits.getInt(4),
                        this._allCircuits.getString(5),
                        this._allCircuits.getString(6),
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
            this._allClients = this._clientDAO.selectAll();

            while (this._allClients.next())
            {
                Client newClient = new Client(this._allClients.getInt(1),
                        this._allClients.getString(2),
                        this._allClients.getString(3),
                        this._allClients.getString(4),
                        this._allClients.getString(5),
                        this._allClients.getString(6),
                        this._allClients.getString(7),
                        this._allClients.getString(8),
                        this._allClients.getInt(9),
                        this._allClients.getString(10),
                        this._allClients.getString(11));

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
            this._allHotels = this._hotelDAO.selectAll();

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
            this._allVilles = this._villeDAO.selectAll();

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
            this._allReservations = this._reservationDAO.selectAll();

            while (this._allReservations.next())
            {
                Reservation newReservation = new Reservation(this._allReservations.getInt(1),
                        this._allReservations.getBoolean(2),
                        this._allReservations.getBoolean(3),
                        this._allReservations.getString(4),
                        this._allReservations.getString(5),
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

    //endregion Public Services


}
