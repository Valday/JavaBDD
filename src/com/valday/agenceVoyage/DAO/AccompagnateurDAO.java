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
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Accompagnateurs (idAccompagnateur,nom,prenom,telephone,numRue,rue,ville,codePostal) VALUES ("+obj.get_idAccompagnateur()+",'"+obj.get_nameAccompagnateur()+"','"+obj.get_prenomAccompagnateur()+"','"+obj.get_telephoneAccompagnateur()+"',"+obj.get_numRueAccompagnateur()+",'"+obj.get_rueAccompagnateur()+"','"+obj.get_villeAccompagnateur()+"',"+obj.get_codePostalAccompagnateur()+")");
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;
    }

    @Override
    public boolean Delete(Accompagnateur obj) {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Circuits SET idAccompagnateur = null WHERE idAccompagnateur = "+obj.get_idAccompagnateur());
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Accompagnateurs WHERE idAccompagnateur = " +obj.get_idAccompagnateur());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Edit(Accompagnateur obj) {
        return false;
    }

    @Override
    public Accompagnateur find(int id) {
        Accompagnateur accompagnateur = new Accompagnateur();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Accompagnateus WHERE idAccompagnateur = "+ id);

            if (resultSet.first())
            {
                accompagnateur = new Accompagnateur(
                        id,
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("telephone"),
                        resultSet.getInt("numRue"),
                        resultSet.getString("rue"),
                        resultSet.getString("ville"),
                        resultSet.getString("codePostal")
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Accompagnateurs");
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Accompagnateurs");

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
