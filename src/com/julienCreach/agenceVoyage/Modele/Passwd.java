/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Passwd modele.
 * @author Julien Creach
 * @version 1.0
 */
public class Passwd
{
    //region Private Attributs

    /**
     * index du password.
     */
    private SimpleIntegerProperty _idPasswd;

    /**
     * username associe.
     */
    private SimpleStringProperty _userName;

    /**
     * password associe.
     */
    private SimpleStringProperty _passwd;

    /**
     * index du user associe.
     */
    private SimpleIntegerProperty _idUser;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index user.
     * @return index user
     */
    public int get_idUser()
    {
        return _idUser.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * Constructeur par defaut.
     */
    private Passwd()
    {
    }

    /**
     * Constructeur.
     * @param idPasswd index password
     * @param userName username
     * @param passwd password
     * @param idUser index user
     */
    public Passwd(int idPasswd, String userName, String passwd, int idUser)
    {
        this._idPasswd = new SimpleIntegerProperty(idPasswd);
        this._userName = new SimpleStringProperty(userName);
        this._passwd = new SimpleStringProperty(passwd);
        this._idUser = new SimpleIntegerProperty(idUser);
    }


    //endregion Contructors

    /**
     * Override toString.
     * @return value
     */
    @Override
    public String toString()
    {
        return "Passwd{" +
                "_idPasswd=" + _idPasswd +
                ", _userName=" + _userName +
                ", _passwd=" + _passwd +
                ", _idUser=" + _idUser +
                '}';
    }
}
