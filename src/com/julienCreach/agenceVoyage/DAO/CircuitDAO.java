/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;


import com.julienCreach.agenceVoyage.Modele.Circuit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO Circuit.
 * @author Julien Creach
 * @version 1.0
 */
public class CircuitDAO extends DAO<Circuit>
{
    //region Constructor

    /**
     * Constructeur par defaut.
     * @param connect Objet connection
     */
    public CircuitDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructor

    //region Public Services

    @Override
    public boolean Add(Circuit obj)
    {
        boolean toReturn = false;
        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Circuits (nom,places,prix,dateDepart,dateFin,open,idAccompagnateur) VALUES ('"
                                                                    +obj.get_nameCircuit()+"',"
                                                                    +obj.get_places()+","
                                                                    +obj.get_prix()+",'"
                                                                    +obj.get_dateDepart()+"','"
                                                                    +obj.get_dateFin()+"',"
                                                                    +(obj.is_open()? 1 : 0)+","
                                                                    +obj.get_idAccompagnateur()+")");

            if(resultSet != null)
            {
                toReturn = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;
    }

    @Override
    public boolean Delete(Circuit obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Visite WHERE idCircuit = " +obj.get_idCircuit());
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Reservations WHERE idCircuit = " +obj.get_idCircuit());
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Circuits WHERE idCircuit = " +obj.get_idCircuit());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Edit(Circuit obj)
    {
        boolean toReturn = false;

        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Circuits SET nom = '"
                                                                    +obj.get_nameCircuit()+"', places="
                                                                    +obj.get_places()+", prix ="
                                                                    +obj.get_prix()+", dateDepart = '"
                                                                    +obj.get_dateDepart()+"', dateFin = '"
                                                                    +obj.get_dateFin()+"', open ="
                                                                    +(obj.is_open()? 1 : 0)+", idAccompagnateur = "
                                                                    +obj.get_idAccompagnateur()
                                                                    +" WHERE idCircuit="+ obj.get_idCircuit());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public Circuit find(int id)
    {
        Circuit circuit = new Circuit();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE idCircuit = "+ id);

            if (resultSet.first())
            {
                circuit = new Circuit(
                        id,
                        resultSet.getString("nom"),
                        resultSet.getInt("places"),
                        resultSet.getInt("prix"),
                        resultSet.getString("dateDepart"),
                        resultSet.getString("dateFin"),
                        resultSet.getBoolean("open"),
                        resultSet.getInt("idAccompagnateur")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return circuit;
    }

    //endregion Public Services
}
