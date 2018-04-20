/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Table.Visite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisiteDAO extends DAO<Visite>
{
    public VisiteDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Add(Visite obj) {
        return false;
    }

    @Override
    public boolean Delete(Visite obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Visite WHERE Codevisite = " +obj.get_idVisite());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Edit(Visite obj) {
        return false;
    }

    @Override
    public Visite find(int id) {
        Visite visite = new Visite();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Visite WHERE CodeVisite = "+ id);

            if (resultSet.first())
            {
                visite = new Visite(
                        id,
                        resultSet.getInt("Nombrenuits"),
                        resultSet.getDate("Datearrivee")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return visite;
    }

    @Override
    public Visite find(String userName, String passwd)
    {
        return null;
    }

    @Override
    public ResultSet selectAll() {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Visite");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int Count()
    {
        int nb = 0;


        return nb;
    }
}
