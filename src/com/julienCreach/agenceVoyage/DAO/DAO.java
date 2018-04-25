/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Modele.Passwd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO.
 * @param <T> Type objet
 * @author Julien Creach
 * @version 1.0
 */
public abstract class DAO<T>
{
    /**
     * Objet connexion.
     */
    protected Connection connect;

    //region Constructeur

    /**
     * Constructeur par defaut.
     * @param connect objet connexion
     */
    public DAO(Connection connect)
    {
        this.connect = connect;
    }

    //endregion Constructeur

    //region Public Services

    /**
     * Methode d'ajout d'un objet de type T en bdd.
     * @param obj objet à ajouter
     * @return true en cas de succès sinon false
     */
    public abstract boolean Add(T obj);

    /**
     * Methode de supression d'un objet de type T en bdd.
     * @param obj objet à delete
     * @return true en cas de succès sinon false
     */
    public abstract boolean Delete(T obj);

    /**
     * Methode d'édition d'un objet de type T en bdd.
     * @param obj objet à editer
     * @return true en cas de succès sinon false
     */
    public abstract boolean Edit(T obj);

    /**
     * Methode de recherche par id d'un objet de type T en bdd.
     * @param id  id de l'Accompagnateur
     * @return un objet de type T
     */
    public abstract T find(int id);

    /**
     * Methode permetant de compter les élément d'une table.
     * @param tableName nom de la table dans laquelle effectuer le count
     * @return Le resultset de la requete
     */
    public int Count(String tableName)
    {
        int nb = 0;
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM "+tableName);

            resultSet.first();
            nb = resultSet.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return nb;
    }

    /**
     * Recupère toutes les datas d'une table.
     * @param tableName nom de la table a récuperer
     * @return Le resultset de la requete
     */
    public ResultSet selectAll(String tableName)
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM "+tableName);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;

    }

    /**
     * Permet de chercher un user dans la table passwds à la connexion.
     * @param userName nom de l'utilisateur
     * @param passwd mot de passe
     * @return objet passwd
     */
    public Passwd find(String userName, String passwd)
    {
        Passwd newPasswd = null;

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Passwds WHERE userName = '"+userName+"' AND passwd = '"+passwd+"'");

            if (resultSet.first())
            {
                newPasswd = new Passwd(
                        resultSet.getInt("idPasswd"),
                        resultSet.getString("userName"),
                        resultSet.getString("passwd"),
                        resultSet.getInt("idUser")
                );
            }
            else
            {
                newPasswd = null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return newPasswd;
    }

    //endregion Public Services
}
