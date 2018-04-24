/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Modele accompagnateur.
 * @author Julien Creach
 * @version 2.0
 */
public class Accompagnateur
{
    //region Private Attributs

    /**
     * index de l'accompagnateur.
     */
    private SimpleIntegerProperty _idAccompagnateur;

    /**
     * nom de l'accompagnateur.
     */
    private SimpleStringProperty _nameAccompagnateur;

    /**
     * prenom de l'accompagnateur.
     */
    private SimpleStringProperty _prenomAccompagnateur;

    /**
     * telephone de l'accompagnateur.
     */
    private SimpleStringProperty _telephoneAccompagnateur;

    /**
     * numero de rue de rue de l'accompagnateur.
     */
    private SimpleIntegerProperty _numRueAccompagnateur;

    /**
     * Rue de l'accompagnateur.
     */
    private SimpleStringProperty _rueAccompagnateur;

    /**
     * ville de l'accompagnateur.
     */
    private SimpleStringProperty _villeAccompagnateur;

    /**
     * code postal de l'accompagnateur.
     */
    private SimpleStringProperty _codePostalAccompagnateur;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index accompagnateur.
     * @return index
     */
    public int get_idAccompagnateur()
    {
        return _idAccompagnateur.get();
    }

    /**
     * Setter index accompagnateur.
     * @param _idAccompagnateur index
     */
    public void set_idAccompagnateur(int _idAccompagnateur)
    {
        this._idAccompagnateur.set(_idAccompagnateur);
    }

    /**
     * Getter nom accompagnateur.
     * @return nom
     */
    public String get_nameAccompagnateur()
    {
        return _nameAccompagnateur.get();
    }

    /**
     * Getter prenom accompagnateur.
     * @return prenom
     */
    public String get_prenomAccompagnateur()
    {
        return _prenomAccompagnateur.get();
    }

    /**
     * Getter telephone de l'accompagnateur.
     * @return telephone
     */
    public String get_telephoneAccompagnateur()
    {
        return _telephoneAccompagnateur.get();
    }

    /**
     * Getter numero de rue accompagnateur.
     * @return numero de rue
     */
    public int get_numRueAccompagnateur()
    {
        return _numRueAccompagnateur.get();
    }

    /**
     * Getter rue accompagnateur.
     * @return rue
     */
    public String get_rueAccompagnateur()
    {
        return _rueAccompagnateur.get();
    }

    /**
     * Getter ville accompagnateur.
     * @return ville
     */
    public String get_villeAccompagnateur()
    {
        return _villeAccompagnateur.get();
    }

    /**
     * Getter code postal.
     * @return code postal
     */
    public String get_codePostalAccompagnateur()
    {
        return _codePostalAccompagnateur.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * Constructeur par defaut.
     */
    public Accompagnateur()
    {

    }

    /**
     * Constructeur.
     * @param id index de l'accompagnateur
     * @param name nom de l'accompagnateur
     * @param prenom prenom de l'accompagnateur
     * @param telephone numero de telephone de l'accompagnateur
     * @param numRue numero de rue de l'accompagnateur
     * @param rue rue de l'accompagnateur
     * @param ville ville de l'accompagnateur
     * @param postCode code postal de l'accompagnateur
     */
    public Accompagnateur(int id, String name, String prenom, String telephone,int numRue, String rue, String ville, String postCode)
    {
        this._idAccompagnateur = new SimpleIntegerProperty(id);
        this._nameAccompagnateur = new SimpleStringProperty(name);
        this._prenomAccompagnateur = new SimpleStringProperty(prenom);
        this._telephoneAccompagnateur = new SimpleStringProperty(telephone);
        this._numRueAccompagnateur = new SimpleIntegerProperty(numRue);
        this._rueAccompagnateur = new SimpleStringProperty(rue);
        this._villeAccompagnateur = new SimpleStringProperty(ville);
        this._codePostalAccompagnateur = new SimpleStringProperty(postCode);
    }

    //endregion Constructors

    //region Private Services

    /**
     * Override toString.
     * @return
     */
    @Override
    public String toString()
    {
        return "Accompagnateur{" +
                "\n_idAccompagnateur=" + _idAccompagnateur +
                ",\n _nameAccompagnateur=" + _nameAccompagnateur +
                ",\n _prenomAccompagnateur=" + _prenomAccompagnateur +
                ",\n _telephoneAccompagnateur=" + _telephoneAccompagnateur +
                ",\n _numRueAccompagnateur=" + _numRueAccompagnateur +
                ",\n _rueAccompagnateur=" + _rueAccompagnateur +
                ",\n _villeAccompagnateur=" + _villeAccompagnateur +
                ",\n _codePostalAccompagnateur=" + _codePostalAccompagnateur +
                "\n}";
    }

    //endregion Private Services
}
