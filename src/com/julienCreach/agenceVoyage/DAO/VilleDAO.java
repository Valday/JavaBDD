/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;


import com.julienCreach.agenceVoyage.Modele.Ville;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VilleDAO extends DAO<Ville>
{
    //region Constructeur

    public VilleDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructeur

    //region Public Services

    @Override
    public boolean Add(Ville obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Villes (nom,idHotel) VALUES ('"+obj.get_nameVille()+"',"+obj.get_idHotel()+")");
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;
    }

    @Override
    public boolean Delete(Ville obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Visite WHERE idVille = " +obj.get_idVille());
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Villes WHERE idVille = " +obj.get_idVille());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Edit(Ville obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Villes SET nom = '"+obj.get_nameVille()
                                                                    +"', idHotel = "+obj.get_idHotel()
                                                                    +" WHERE idVille = " +obj.get_idVille());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public Ville find(int id)
    {
        Ville ville = new Ville();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Villes WHERE idVille = "+ id);

            if (resultSet.first())
            {
                ville = new Ville(
                        id,
                        resultSet.getString("nom"),
                        resultSet.getInt("idHotel")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ville;

    }

    //endregion Public Services
}
