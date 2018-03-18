package com.valday.GestionAgenceVoyage.DAO;

import com.valday.GestionAgenceVoyage.Table.Ville;

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
    public boolean Create(Ville obj) {
        return false;
    }

    @Override
    public boolean Delete(Ville obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Villes WHERE Codeville = " +obj.get_id());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Update(Ville obj) {
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
                        resultSet.getString("Nom")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ville;

    }
}
