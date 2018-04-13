package com.valday.agenceVoyage.DAO;


import com.valday.agenceVoyage.Table.Ville;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VilleDAO extends DAO<Ville>
{
    public VilleDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Add(Ville obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Villes (idVille,nom,idHotel) VALUES ("+obj.get_idVille()+",'"+obj.get_nameVille()+"',"+obj.get_idHotel()+")");
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
    public boolean Edit(Ville obj) {
        return false;
    }

    @Override
    public Ville find(int id) {
        Ville ville = new Ville();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Villes WHERE Codeville = "+ id);

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

    @Override
    public ResultSet selectAll() {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Villes");
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Villes");

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
