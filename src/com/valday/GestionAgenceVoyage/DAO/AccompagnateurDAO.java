package com.valday.GestionAgenceVoyage.DAO;

import com.valday.GestionAgenceVoyage.Table.Accompagnateur;

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
    public boolean Create(Accompagnateur obj) {
        return false;
    }

    @Override
    public boolean Delete(Accompagnateur obj) {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Accompagnateur WHERE CodeAccompagnateur = " +obj.get_id());
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE Codecircuit = "+ id);

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
}
