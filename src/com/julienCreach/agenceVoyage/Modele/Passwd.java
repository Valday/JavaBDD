/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Passwd
{
    //region Private Attributs

    private SimpleIntegerProperty _idPasswd;

    private SimpleStringProperty _userName;

    private SimpleStringProperty _passwd;

    private SimpleIntegerProperty _idUser;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idPasswd()
    {
        return _idPasswd.get();
    }

    public SimpleIntegerProperty _idPasswdProperty()
    {
        return _idPasswd;
    }

    public void set_idPasswd(int _idPasswd)
    {
        this._idPasswd.set(_idPasswd);
    }

    public String get_userName()
    {
        return _userName.get();
    }

    public SimpleStringProperty _userNameProperty()
    {
        return _userName;
    }

    public void set_userName(String _userName)
    {
        this._userName.set(_userName);
    }

    public String get_passwd()
    {
        return _passwd.get();
    }

    public SimpleStringProperty _passwdProperty()
    {
        return _passwd;
    }

    public void set_passwd(String _passwd)
    {
        this._passwd.set(_passwd);
    }

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


    //endregion Public Attributs

    //region Constructors


    public Passwd()
    {
    }

    public Passwd(int idPasswd, String userName, String passwd, int idUser)
    {
        this._idPasswd = new SimpleIntegerProperty(idPasswd);
        this._userName = new SimpleStringProperty(userName);
        this._passwd = new SimpleStringProperty(passwd);
        this._idUser = new SimpleIntegerProperty(idUser);
    }


    //endregion Contructors


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
