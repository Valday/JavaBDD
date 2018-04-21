/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Hotel
{
    //region Private Attributs

    private SimpleIntegerProperty _idHotel;

    private SimpleStringProperty _nameHotel;

    private SimpleStringProperty _telephoneHotel;

    private SimpleStringProperty _rueHotel;

    private SimpleIntegerProperty _numRueHotel;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idHotel()
    {
        return _idHotel.get();
    }

    public SimpleIntegerProperty _idHotelProperty()
    {
        return _idHotel;
    }

    public void set_idHotel(int _idHotel)
    {
        this._idHotel.set(_idHotel);
    }

    public String get_nameHotel()
    {
        return _nameHotel.get();
    }

    public SimpleStringProperty _nameHotelProperty()
    {
        return _nameHotel;
    }

    public void set_nameHotel(String _nameHotel)
    {
        this._nameHotel.set(_nameHotel);
    }

    public String get_telephoneHotel()
    {
        return _telephoneHotel.get();
    }

    public SimpleStringProperty _telephoneHotelProperty()
    {
        return _telephoneHotel;
    }

    public void set_telephoneHotel(String _telephoneHotel)
    {
        this._telephoneHotel.set(_telephoneHotel);
    }

    public String get_rueHotel()
    {
        return _rueHotel.get();
    }

    public SimpleStringProperty _rueHotelProperty()
    {
        return _rueHotel;
    }

    public void set_rueHotel(String _rueHotel)
    {
        this._rueHotel.set(_rueHotel);
    }

    public int get_numRueHotel()
    {
        return _numRueHotel.get();
    }

    public SimpleIntegerProperty _numRueHotelProperty()
    {
        return _numRueHotel;
    }

    public void set_numRueHotel(int _numRueHotel)
    {
        this._numRueHotel.set(_numRueHotel);
    }


//endregion Public Attributs

    //region Constructors

    public Hotel()
    {

    }

    public Hotel(int id, String name, String telephone, String rue, int numRue)
    {
        this._idHotel = new SimpleIntegerProperty(id);
        this._nameHotel = new SimpleStringProperty(name);
        this._telephoneHotel = new SimpleStringProperty(telephone);
        this._rueHotel = new SimpleStringProperty(rue);
        this._numRueHotel = new SimpleIntegerProperty(numRue);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idHotel+"\n"
                +"Nom : "+this._nameHotel+"\n");
    }

}
