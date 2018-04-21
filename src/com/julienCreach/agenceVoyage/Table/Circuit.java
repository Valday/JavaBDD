/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Table;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Circuit
{

    //region Private Attributs

    private SimpleIntegerProperty _idCircuit;

    private SimpleStringProperty _nameCircuit;

    private SimpleIntegerProperty _places;

    private SimpleIntegerProperty _prix;

    private SimpleStringProperty _dateDepart;

    private  SimpleStringProperty _dateFin;

    private SimpleBooleanProperty _open;

    private SimpleIntegerProperty _idAccompagnateur;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idCircuit()
    {
        return _idCircuit.get();
    }

    public SimpleIntegerProperty _idCircuitProperty()
    {
        return _idCircuit;
    }

    public void set_idCircuit(int _idCircuit)
    {
        this._idCircuit.set(_idCircuit);
    }

    public String get_nameCircuit()
    {
        return _nameCircuit.get();
    }

    public SimpleStringProperty _nameCircuitProperty()
    {
        return _nameCircuit;
    }

    public void set_nameCircuit(String _nameCircuit)
    {
        this._nameCircuit.set(_nameCircuit);
    }

    public int get_places()
    {
        return _places.get();
    }

    public SimpleIntegerProperty _placesProperty()
    {
        return _places;
    }

    public void set_places(int _places)
    {
        this._places.set(_places);
    }

    public int get_prix()
    {
        return _prix.get();
    }

    public SimpleIntegerProperty _prixProperty()
    {
        return _prix;
    }

    public void set_prix(int _prix)
    {
        this._prix.set(_prix);
    }

    public String get_dateDepart()
    {
        return _dateDepart.get();
    }

    public SimpleStringProperty _dateDepartProperty()
    {
        return _dateDepart;
    }

    public void set_dateDepart(String _dateDepart)
    {
        this._dateDepart.set(_dateDepart);
    }

    public String get_dateFin()
    {
        return _dateFin.get();
    }

    public SimpleStringProperty _dateFinProperty()
    {
        return _dateFin;
    }

    public void set_dateFin(String _dateFin)
    {
        this._dateFin.set(_dateFin);
    }

    public boolean is_open()
    {
        return _open.get();
    }

    public SimpleBooleanProperty _openProperty()
    {
        return _open;
    }

    public void set_open(boolean _open)
    {
        this._open.set(_open);
    }

    public int get_idAccompagnateur()
    {
        return _idAccompagnateur.get();
    }

    public SimpleIntegerProperty _idAccompagnateurProperty()
    {
        return _idAccompagnateur;
    }

    public void set_idAccompagnateur(int _idAccompagnateur)
    {
        this._idAccompagnateur.set(_idAccompagnateur);
    }


    //endregion Public Attributs

    //region Constructors

    public Circuit()
    {

    }

    public Circuit(int id, String name, int nbPlaces, int prix, String dateDepart, String dateFin, boolean open, int idAccompagnateur)
    {
        this._idCircuit = new SimpleIntegerProperty(id);
        this._nameCircuit = new SimpleStringProperty(name);
        this._places = new SimpleIntegerProperty(nbPlaces);
        this._prix = new SimpleIntegerProperty(prix);
        this._dateDepart = new SimpleStringProperty(dateDepart);
        this._dateFin = new SimpleStringProperty(dateFin);
        this._open = new SimpleBooleanProperty(open);
        this._idAccompagnateur = new SimpleIntegerProperty(idAccompagnateur);
    }
    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idCircuit+"\n"
                +"Nom : "+this._nameCircuit+"\n"
                +"Places disponnibles : "+this._places+"\n"
                +"Prix : "+this._prix+"\n"
                +"Date de départ : "+this._dateDepart+"\n"
                +"Date d'arrive : "+this._dateFin+"\n"
                +"Resevation annulée : "+this._open+"\n"
                +"Id accompagnateur : "+this._idAccompagnateur+"\n");
    }
}
