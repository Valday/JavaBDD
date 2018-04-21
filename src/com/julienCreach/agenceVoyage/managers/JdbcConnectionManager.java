/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcConnectionManager
{
    private volatile static JdbcConnectionManager _instance;

    /**
     * URL de connexion
     */
    private static String _url;

    /**
     * Nom du user
     */
    private static String _userName;

    /**
     * Mot de passe du user
     */
    private static String _passwd;

    /**
     * Objet Connexion
     */
    private static Connection _connector;

    private static int _timeOut;

    private JdbcConnectionManager()
    {
        _userName = "tutor";
        _passwd = "oracletutor";
        _timeOut = 5;
    }

    /**
     * Méthode qui va retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */
    public static JdbcConnectionManager Instance()
    {
        if (_instance == null)
        {
            synchronized(JdbcConnectionManager.class){
                if(_instance == null)
                {
                    _instance = new JdbcConnectionManager();
                }
            }
        }
        return _instance;
    }

    public void Open(String url)
    {
        _url = url;
        try
        {
            System.out.println(" => Connection to database ("+_url+") in progress ...");
            _connector = DriverManager.getConnection(_url,"tutor","oracletutor");
            if (_connector.isValid(_timeOut))
            {
                System.out.println(" => connection established ...");
            }
        }
        catch (SQLException e)
        {
            System.out.println(" => Connection Failed ...");
            e.printStackTrace();
        }
    }

    public void Close()
    {
        try
        {
            if (!_connector.isClosed())
            {
                _connector.close();
                System.out.println(" => connection closed ...");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println(" => disconnection Failed ...");

        }
    }

    public Connection get_connector()
    {
        return _connector;
    }
}
