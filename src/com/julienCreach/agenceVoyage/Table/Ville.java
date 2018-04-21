/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ville
{
    //region Private Attributs

    /**
     * index de la ville
     */
    private SimpleIntegerProperty _idVille;

    /**
     * nom de la ville
     */
    private SimpleStringProperty _nameVille;

    /**
     * index de l'hotel
     */
    private SimpleIntegerProperty _idHotel;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index ville
     * @return l'index
     */
    public int get_idVille()
    {
        return _idVille.get();
    }

    /**
     * Setter index ville
     * @param _idVille
     */
    public void set_idVille(int _idVille)
    {
        this._idVille.set(_idVille);
    }

    /**
     * Getter sur le nom de la ville
     * @return le nom de la ville
     */
    public String get_nameVille()
    {
        return _nameVille.get();
    }

    /**
     * Getter index de l'hotel
     * @return l'index
     */
    public int get_idHotel()
    {
        return _idHotel.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * COnstructeur par defaut
     */
    public Ville()
    {

    }

    /**
     * Constructeur
     * @param id index de la ville
     * @param name nom de la ville
     * @param idHotel index de l'hotel
     */
    public Ville(int id, String name, int idHotel)
    {
        this._idVille = new SimpleIntegerProperty(id);
        this._nameVille = new SimpleStringProperty(name);
        this._idHotel = new SimpleIntegerProperty(idHotel);
    }

    //endregion Constructors

    /**
     * Override toString
     * @return String contenant les datas de la ville
     */
    @Override
    public String toString()
    {
        return "Ville{" +
                "_idVille=" + _idVille +
                ", _nameVille=" + _nameVille +
                ", _idHotel=" + _idHotel +
                '}';
    }
}
