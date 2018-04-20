/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import java.sql.Connection;
import java.sql.ResultSet;

public abstract class DAO<T>
{
    protected Connection connect;

    public DAO(Connection connect)
    {
        this.connect = connect;
    }

    public abstract boolean Add(T obj);

    public abstract boolean Delete(T obj);

    public abstract boolean Edit(T obj);

    public abstract T find(int id);

    public abstract T find(String userName, String passwd);

    public abstract ResultSet selectAll();

    public abstract int Count();
}
