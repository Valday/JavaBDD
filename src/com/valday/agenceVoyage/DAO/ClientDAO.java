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
    public boolean Add(Client obj) {
        return false;
    }

    @Override
    public boolean Delete(Client obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Clients WHERE Codeclient = " +obj.get_idClient());
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
    public Client find(int id) {
        Client client = new Client();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Clients WHERE Codecircuit = "+ id);

            if (resultSet.first())
            {
                client = new Client(
                        id,
                        resultSet.getString("Nom")
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
    public ResultSet selectAll() {
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
        return resultSet;    }
}
