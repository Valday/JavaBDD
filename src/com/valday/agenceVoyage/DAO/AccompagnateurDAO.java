package com.valday.agenceVoyage.DAO;

import com.valday.agenceVoyage.GUI.adminWindowController;
import com.valday.agenceVoyage.Table.Accompagnateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccompagnateurDAO extends DAO<Accompagnateur>
{
    public AccompagnateurDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Add(Accompagnateur obj)
    {
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Accompagnateur (CodeAccompagnateur,Nom) VALUES ("+obj.get_idAccompagnateur()+",'"+obj.get_nameAccompagnateur()+"');");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean Delete(Accompagnateur obj) {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Accompagnateur WHERE CodeAccompagnateur = " +obj.get_idAccompagnateur());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Update(Accompagnateur obj) {
        return false;
    }

    @Override
    public Accompagnateur find(int id) {
        Accompagnateur accompagnateur = new Accompagnateur();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Accompagnateur WHERE Codecircuit = "+ id);

            if (resultSet.first())
            {
                accompagnateur = new Accompagnateur(
                        id,
                        resultSet.getString("Nom")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return accompagnateur;
    }

    @Override
    public ResultSet selectAll() {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Accompagnateur");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
}
