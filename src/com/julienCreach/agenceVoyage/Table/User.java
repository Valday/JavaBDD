/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;

public class User
{
    //region Private Attributs

    private SimpleIntegerProperty _idUser;

    private SimpleIntegerProperty _rank;

    private SimpleIntegerProperty _idAccompagnateur;

    private SimpleIntegerProperty _idClient;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idUser()
    {
        return _idUser.get();
    }

    public SimpleIntegerProperty _idUserProperty()
    {
        return _idUser;
    }

    public void set_idUser(int _idUser)
    {
        this._idUser.set(_idUser);
    }

    public int get_rank()
    {
        return _rank.get();
    }

    public SimpleIntegerProperty _rankProperty()
    {
        return _rank;
    }

    public void set_rank(int _rank)
    {
        this._rank.set(_rank);
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

    public int get_idClient() {
        return _idClient.get();
    }

    public SimpleIntegerProperty _idClientProperty()
    {
        return _idClient;
    }

    public void set_idClient(int _idClient)
    {
        this._idClient.set(_idClient);
    }

    //endregion Public Attributs

    //region Constructors

    public User()
    {
    }

    public User(int idUser, int rank, int idAccompagnateur, int idClient)
    {
        this._idUser = new SimpleIntegerProperty(idUser);
        this._rank = new SimpleIntegerProperty(rank);
        this._idAccompagnateur = new SimpleIntegerProperty(idAccompagnateur);
        this._idClient = new SimpleIntegerProperty(idClient);
    }


    //endregion Contructors


    @Override
    public String toString()
    {
        return "User{" +
                "_idUser=" + _idUser +
                ", _rank=" + _rank +
                ", _idAccompagnateur=" + _idAccompagnateur +
                ", _idClient=" + _idClient +
                '}';
    }
}
