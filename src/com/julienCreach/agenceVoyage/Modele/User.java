/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleIntegerProperty;

public class User
{
    //region Private Attributs

    /**
     * index du user
     */
    private SimpleIntegerProperty _idUser;

    /**
     * privilège du user
     */
    private SimpleIntegerProperty _rank;

    /**
     * Correspondance dans la table accompangateur
     */
    private SimpleIntegerProperty _idAccompagnateur;

    /**
     * Correspondance dans la table client
     */
    private SimpleIntegerProperty _idClient;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter niveau de privilège
     * @return retourne une valeur qui est soit 1, 2 ou 3
     */
    public int get_rank()
    {
        return _rank.get();
    }

    /**
     * Getter index de correspondance accompagnateur
     * @return l'indice
     */
    public int get_idAccompagnateur()
    {
        return _idAccompagnateur.get();
    }

    /**
     * Getter index de correspondance client
     * @return l'indice
     */
    public int get_idClient()
    {
        return _idClient.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * Constructeur par defaut.
     */
    public User()
    {
    }

    /**
     *  Constructeur
     * @param idUser index du nouveau user
     * @param rank privilèges du user
     * @param idAccompagnateur Correspondance dans la table accompangateur
     * @param idClient ou Correspondance dans la table client
     */
    public User(int idUser, int rank, int idAccompagnateur, int idClient)
    {
        this._idUser = new SimpleIntegerProperty(idUser);
        this._rank = new SimpleIntegerProperty(rank);
        this._idAccompagnateur = new SimpleIntegerProperty(idAccompagnateur);
        this._idClient = new SimpleIntegerProperty(idClient);
    }


    //endregion Contructors

    //region Public Services

    /**
     * Override toString
     * @return user values in a string
     */
    @Override
    public String toString()
    {
        return "User{" +
                "_idUser=" + _idUser +
                ", _rank=" + _rank +
                ", _idAccompagnateur=" + _idAccompagnateur +
                ", _idClient=" + _idClient +
                '}';
    }

    //endregion Public Services
}
