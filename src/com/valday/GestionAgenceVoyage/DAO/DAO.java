package com.valday.GestionAgenceVoyage.DAO;

import java.sql.Connection;

public abstract class DAO<T>
{
    protected Connection connect;

    public DAO(Connection connect)
    {
        this.connect = connect;
    }

    public abstract boolean Create(T obj);

    public abstract boolean Delete(T obj);

    public abstract boolean Update(T obj);

    public abstract  T find(int id);
}
