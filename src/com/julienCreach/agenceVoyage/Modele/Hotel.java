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

    /**
     * Index hotel.
     */
    private SimpleIntegerProperty _idHotel;

    /**
     * Nom hotel.
     */
    private SimpleStringProperty _nameHotel;

    /**
     * telephone hotel.
     */
    private SimpleStringProperty _telephoneHotel;

    /**
     * Rue de l'hotel.
     */
    private SimpleStringProperty _rueHotel;

    /**
     * Numero de rue hotel.
     */
    private SimpleIntegerProperty _numRueHotel;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index hotel.
     * @return index hotel
     */
    public int get_idHotel()
    {
        return _idHotel.get();
    }

    /**
     * Setter index Hotel.
     * @param _idHotel index hotel
     */
    public void set_idHotel(int _idHotel)
    {
        this._idHotel.set(_idHotel);
    }

    /**
     * Getter nom hotel.
     * @return nom hotel
     */
    public String get_nameHotel()
    {
        return _nameHotel.get();
    }

    /**
     * Getter numero de telephone.
     * @return numero de telephone
     */
    public String get_telephoneHotel()
    {
        return _telephoneHotel.get();
    }

    /**
     * Getter rue hotel.
     * @return Rue hotel
     */
    public String get_rueHotel()
    {
        return _rueHotel.get();
    }

    /**
     * Getter numero de rue hotel.
     * @return numero de rue hotel
     */
    public int get_numRueHotel()
    {
        return _numRueHotel.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * Constructeur par defaut.
     */
    public Hotel()
    {

    }

    /**
     * Constructeur.
     * @param id index hotel
     * @param name nom de l'hotel
     * @param telephone numero telephone de l'hotel
     * @param rue rue de l'hotel
     * @param numRue numero de rue de l'hotel
     */
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
     * Override toString.
     * @return value
     */
    @Override
    public String toString()
    {
        return new String( "Id : "+this._idHotel+"\n"
                +"Nom : "+this._nameHotel+"\n");
    }

}
