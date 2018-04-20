/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Table.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO<User>
{

    public UserDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Add(User obj) {
        return false;
    }

    @Override
    public boolean Delete(User obj) {
        return false;
    }

    @Override
    public boolean Edit(User obj) {
        return false;
    }

    @Override
    public User find(int id) {
        User user = new User();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Users WHERE idUser = "+ id);

            if (resultSet.first())
            {
                user = new User(
                        id,
                        resultSet.getInt("rank"),
                        resultSet.getInt("idAccompagnateur"),
                        resultSet.getInt("idClient")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;    }

    @Override
    public User find(String userName, String passwd)
    {
        return null;
    }

    @Override
    public ResultSet selectAll()
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Users");
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Users");

            resultSet.first();
            nb = resultSet.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return nb;    }
}
