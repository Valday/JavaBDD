/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Modele.Passwd;

import java.sql.Connection;

/**
 * Passwd DAO.
 * @author Julien Creach
 * @version 1.0
 */
public class PasswdDAO extends DAO<Passwd>
{
    //region Constructeur

    /**
     * Constructeur.
     * @param connect objet connexion
     */
    public PasswdDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructeur

    //region Public Services

    @Override
    public boolean Add(Passwd obj)
    {
        return false;
    }

    @Override
    public boolean Delete(Passwd obj)
    {
        return false;
    }

    @Override
    public boolean Edit(Passwd obj)
    {
        return false;
    }

    @Override
    public Passwd find(int id)
    {
        return null;
    }
    //endregion Public Services
}
