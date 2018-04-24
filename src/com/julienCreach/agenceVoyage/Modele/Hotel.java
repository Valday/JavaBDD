/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Modele Hotel.
 * @author Julien Creach
 * @version 2.0
 */
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

    public void set_idHotel(int _idHotel)
    {
        this._idHotel.set(_idHotel);
    }

    public String get_nameHotel()
    {
        return _nameHotel.get();
    }

    public String get_telephoneHotel()
    {
        return _telephoneHotel.get();
    }

    public String get_rueHotel()
    {
        return _rueHotel.get();
    }

    public int get_numRueHotel()
    {
        return _numRueHotel.get();
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

    /**
     * Override toString
     * @return value
     */
    @Override
    public String toString()
    {
        return new String( "Id : "+this._idHotel+"\n"
                +"Nom : "+this._nameHotel+"\n");
    }

}
