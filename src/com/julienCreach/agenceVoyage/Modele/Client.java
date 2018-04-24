/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Modele Client.
 * @author Julien Creach
 * @version 2.0
 */
public class Client
{
    //region Private Attributs

    /**
     * index du client.
     */
    private SimpleIntegerProperty _idClient;

    /**
     * nom du client.
     */
    private SimpleStringProperty _nameClient;

    /**
     * prenom du client.
     */
    private SimpleStringProperty _prenomClient;

    /**
     * telephone client.
     */
    private SimpleStringProperty _telephoneClient;

    /**
     * ville du client.
     */
    private SimpleStringProperty _villeClient;

    /**
     * rue client.
     */
    private SimpleStringProperty _rueClient;

    /**
     * numero de rue client.
     */
    private SimpleIntegerProperty _numRueClient;

    /**
     * code postal client.
     */
    private SimpleStringProperty _codePostalClient;

    /**
     * date de naissance du client.
     */
    private SimpleStringProperty _dateNaissanceClient;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index client.
     * @return index
     */
    public int get_idClient()
    {
        return _idClient.get();
    }

    /**
     * Setter index client.
     * @param _idClient index
     */
    public void set_idClient(int _idClient)
    {
        this._idClient.set(_idClient);
    }

    /**
     * Getter nom client.
     * @return nom
     */
    public String get_nameClient()
    {
        return _nameClient.get();
    }

    /**
     * Getter prenom client.
     * @return prenom client
     */
    public String get_prenomClient()
    {
        return _prenomClient.get();
    }

    /**
     * Getter telephone client.
     * @return telephone client
     */
    public String get_telephoneClient()
    {
        return _telephoneClient.get();
    }

    /**
     * Getter ville client.
     * @return ville client
     */
    public String get_villeClient()
    {
        return _villeClient.get();
    }

    /**
     * Getter rue client.
     * @return rue
     */
    public String get_rueClient()
    {
        return _rueClient.get();
    }

    /**
     * Getter numero de rue client.
     * @return numero de rue
     */
    public int get_numRueClient()
    {
        return _numRueClient.get();
    }

    /**
     * Getter code postal client.
     * @return code postal
     */
    public String get_codePostalClient()
    {
        return _codePostalClient.get();
    }

    /**
     * Getter date de naissance client.
     * @return date de naissance
     */
    public String get_dateNaissanceClient()
    {
        return _dateNaissanceClient.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * Constructeur par defaut.
     */
    public Client()
    {

    }

    /**
     * Constructeur.
     * @param id index client
     * @param name nom client
     * @param prenom prenom client
     * @param telephone numero de telephone client
     * @param ville ville du client
     * @param rue rue du client
     * @param numRue numero de rue du client
     * @param codePostal code postal client
     * @param dateNaissance date de naissance du client
     */
    public Client(int id, String name, String prenom, String telephone, String ville, String rue, int numRue, String codePostal, String dateNaissance)
    {
        this._idClient = new SimpleIntegerProperty(id);
        this._nameClient = new SimpleStringProperty(name);
        this._prenomClient = new SimpleStringProperty(prenom);
        this._telephoneClient = new SimpleStringProperty(telephone);
        this._villeClient = new SimpleStringProperty(ville);
        this._rueClient = new SimpleStringProperty(rue);
        this._numRueClient = new SimpleIntegerProperty(numRue);
        this._codePostalClient = new SimpleStringProperty(codePostal);
        this._dateNaissanceClient = new SimpleStringProperty(dateNaissance);
    }

    //endregion Constructors

    /**
     * Override toString.
     * @return value
     */
    @Override
    public String toString()
    {
        return "Client{" +
                "\n_idClient=" + _idClient +
                ",\n _nameClient=" + _nameClient +
                ",\n _prenomClient=" + _prenomClient +
                ",\n _telephoneClient=" + _telephoneClient +
                ",\n _villeClient=" + _villeClient +
                ",\n _rueClient=" + _rueClient +
                ",\n _numRueClient=" + _numRueClient +
                ",\n _codePostalClient=" + _codePostalClient +
                ",\n _dateNaissanceClient=" + _dateNaissanceClient +
                "}";
    }
}
