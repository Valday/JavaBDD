/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Modele.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO<User>
{
    //region Constructeur

    public UserDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructeur

    //region Public Services

    @Override
    public boolean Add(User obj)
    {
        return false;
    }

    @Override
    public boolean Delete(User obj)
    {
        return false;
    }

    @Override
    public boolean Edit(User obj)
    {
        return false;
    }

    @Override
    public User find(int id)
    {
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
        return user;
    }

    //endregion Public Services
}
