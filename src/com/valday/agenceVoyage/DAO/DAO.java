package com.valday.agenceVoyage.DAO;

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

    public abstract boolean Update(T obj);

    public abstract  T find(int id);

    public  abstract ResultSet selectAll();
}
