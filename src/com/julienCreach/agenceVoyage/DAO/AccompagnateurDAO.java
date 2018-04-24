/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Modele.Accompagnateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO accompagnateur.
 * @author Julien Creach
 * @version 1.0
 */
public class AccompagnateurDAO extends DAO<Accompagnateur>
{
    //region Constructor

    /**
     * Constructeur par defaut.
     * @param connect objet connection
     */
    public AccompagnateurDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructor

    //region Public Services

    /**
     * Methode d'ajout d'un Accompagnateur en bdd.
     * @param obj Acommpagnateur
     * @return true en cas de succès sinon false
     */
    @Override
    public boolean Add(Accompagnateur obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Accompagnateurs (nom,prenom,telephone,numRue,rue,ville,codePostal) VALUES ('"
                                                                +obj.get_nameAccompagnateur()+"','"
                                                                +obj.get_prenomAccompagnateur()+"','"
                                                                +obj.get_telephoneAccompagnateur()+"',"
                                                                +obj.get_numRueAccompagnateur()+",'"
                                                                +obj.get_rueAccompagnateur()+"','"
                                                                +obj.get_villeAccompagnateur()+"',"
                                                                +obj.get_codePostalAccompagnateur()+")");
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;
    }

    /**
     * Methode de supression d'un Accompagnateur en bdd.
     * @param obj Accompagnateur
     * @return true en cas de succès sinon false
     */
    @Override
    public boolean Delete(Accompagnateur obj)
    {
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

    /**
     * Methode d'édition d'un Accompagnateur en bdd.
     * @param obj Accompagnateur
     * @return true en cas de succès sinon false
     */
    @Override
    public boolean Edit(Accompagnateur obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Accompagnateurs SET nom='"+obj.get_nameAccompagnateur()
                                                                    +"', prenom='"+obj.get_prenomAccompagnateur()
                                                                    +"', telephone='"+obj.get_telephoneAccompagnateur()
                                                                    +"', numRue="+obj.get_numRueAccompagnateur()
                                                                    +",rue='"+obj.get_rueAccompagnateur()
                                                                    +"',ville='"+obj.get_villeAccompagnateur()
                                                                    +"', codePostal='"+obj.get_codePostalAccompagnateur()
                                                                    +"' WHERE idAccompagnateur = " +obj.get_idAccompagnateur());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    /**
     * Methode de recherche par id d'un Accompagnateur.
     * @param id  id de l'Accompagnateur
     * @return un objet Accompagnateur
     */
    @Override
    public Accompagnateur find(int id)
    {
        Accompagnateur accompagnateur = new Accompagnateur();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Accompagnateurs WHERE idAccompagnateur = "+ id);

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

    //endregion Public Services
}
