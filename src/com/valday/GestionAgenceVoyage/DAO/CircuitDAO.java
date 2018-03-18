package com.valday.GestionAgenceVoyage.DAO;

import com.valday.GestionAgenceVoyage.Table.Circuit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CircuitDAO extends DAO<Circuit>
{

    public CircuitDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Create(Circuit obj)
    {
        return false;
    }

    @Override
    public boolean Delete(Circuit obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Circuits WHERE Codecircuit = " +obj.get_id());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Update(Circuit obj)
    {
        return false;
    }

    @Override
    public Circuit find(int id)
    {
        Circuit circuit = new Circuit();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits WHERE Codecircuit = "+ id);

            if (resultSet.first())
            {
                circuit = new Circuit(
                        id,
                        resultSet.getString("Nom"),
                        resultSet.getInt("PlaceDisponibles"),
                        resultSet.getDate("Datedepart"),
                        resultSet.getDate("Datefin"),
                        resultSet.getBoolean("Annulation")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return circuit;
    }
}
