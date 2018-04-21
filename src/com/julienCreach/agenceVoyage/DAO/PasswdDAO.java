/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Table.Passwd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswdDAO extends DAO<Passwd>
{

    public PasswdDAO(Connection connect)
    {
        super(connect);
    }

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

    @Override
    public Passwd find(String userName, String passwd)
    {
        Passwd newPasswd = new Passwd();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Passwds WHERE userName = '"+userName+"' AND passwd = '"+passwd+"'");

            if (resultSet.first())
            {
                newPasswd = new Passwd(
                        resultSet.getInt("idPasswd"),
                        resultSet.getString("userName"),
                        resultSet.getString("passwd"),
                        resultSet.getInt("idUser")
                );
            }
            else
            {
                newPasswd = null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return newPasswd;
    }
    @Override
    public ResultSet selectAll()
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Passwds");
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
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Passwds");

            resultSet.first();
            nb = resultSet.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return nb;
    }
}
