package com.valday.agenceVoyage.DAO;


import com.valday.agenceVoyage.Table.Circuit;

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
    public boolean Add(Circuit obj)
    {
        boolean toReturn = false;
        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Circuits (idCircuit,nom,places,prix,dateDepart,dateFin,open,idAccompagnateur) VALUES ("
                                                                    +obj.get_idCircuit()+",'"
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

    @Override
    public ResultSet selectAll()
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Circuits");
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Circuits");

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
