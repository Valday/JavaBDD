/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;


import com.julienCreach.agenceVoyage.Modele.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO client.
 * @author Julien Creach
 * @version 1.0
 */
public class ClientDAO extends DAO<Client>
{
    //region Constructeur

    /**
     * Constructeur par defaut.
     * @param connect Objet connexion
     */
    public ClientDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructeur

    //region Public Services

    @Override
    public boolean Add(Client obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Clients (nom,prenom,telephone,ville,rue,numRue,codePostal,dateNaissance) VALUES ('"
                                                                    +obj.get_nameClient()+"','"
                                                                    +obj.get_prenomClient()+"','"
                                                                    +obj.get_telephoneClient()+"','"
                                                                    +obj.get_villeClient()+"','"
                                                                    +obj.get_rueClient()+"',"
                                                                    +obj.get_numRueClient()+","
                                                                    +obj.get_codePostalClient()+",'"
                                                                    +obj.get_dateNaissanceClient()+"')");
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Reservations WHERE idClient = " +obj.get_idClient());
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
    public boolean Edit(Client obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Clients SET nom='"+obj.get_nameClient()
                        +"', prenom='"+obj.get_prenomClient()
                        +"', telephone='"+obj.get_telephoneClient()
                        +"',ville='"+obj.get_villeClient()
                        +"',rue='"+obj.get_rueClient()
                        +"', numRue="+obj.get_numRueClient()
                        +", codePostal="+obj.get_codePostalClient()
                        +", dateNaissance='"+obj.get_dateNaissanceClient()
                        +"' WHERE idClient = " +obj.get_idClient());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public Client find(int id)
    {
        Client client = new Client();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Clients WHERE idClient = "+ id);

            if (resultSet.first())
            {
                client = new Client(
                        id,
                        resultSet.getString("nom"),
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

    //endregion Public Services
}
