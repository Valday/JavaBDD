package com.valday.agenceVoyage.DAO;


import com.valday.agenceVoyage.Table.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends DAO<Client>
{
    public ClientDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Add(Client obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Clients (idClient,nom,userName,mdp,prenom,telephone,ville,rue,numRue,codePostal,dateNaissance) VALUES ("+obj.get_idClient()+",'"+obj.get_nameClient()+"','"+obj.get_userName()+"','"+obj.get_mdp()+"','"+obj.get_prenomClient()+"','"+obj.get_telephoneClient()+"','"+obj.get_villeClient()+"','"+obj.get_rueClient()+"',"+obj.get_numRueClient()+","+obj.get_codePostalClient()+",'"+obj.get_dateNaissanceClient()+"')");
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;
    }

    @Override
    public boolean Delete(Client obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Clients WHERE idClient = " +obj.get_idClient());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Update(Client obj) {
        return false;
    }

    @Override
    public Client find(int id)
    {
        Client client = new Client();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Clients WHERE idCircuit = "+ id);

            if (resultSet.first())
            {
                client = new Client(
                        id,
                        resultSet.getString("nom"),
                        resultSet.getString("userName"),
                        resultSet.getString("mdp"),
                        resultSet.getString("prenom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("ville"),
                        resultSet.getString("rue"),
                        resultSet.getInt("numRue"),
                        resultSet.getString("codePostal"),
                        resultSet.getString("dateNaissance")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public ResultSet selectAll()
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Clients");
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Clients");

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
