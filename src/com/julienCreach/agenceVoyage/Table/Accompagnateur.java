/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Accompagnateur
{
    //region Private Attributs

    private SimpleIntegerProperty _idAccompagnateur;

    private SimpleStringProperty _nameAccompagnateur;

    private SimpleStringProperty _prenomAccompagnateur;

    private SimpleStringProperty _telephoneAccompagnateur;

    private SimpleIntegerProperty _numRueAccompagnateur;

    private SimpleStringProperty _rueAccompagnateur;

    private SimpleStringProperty _villeAccompagnateur;

    private SimpleStringProperty _codePostalAccompagnateur;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idAccompagnateur()
    {
        return _idAccompagnateur.get();
    }

    public void set_idAccompagnateur(int _idAccompagnateur)
    {
        this._idAccompagnateur.set(_idAccompagnateur);
    }

    public String get_nameAccompagnateur()
    {
        return _nameAccompagnateur.get();
    }

    public String get_prenomAccompagnateur()
    {
        return _prenomAccompagnateur.get();
    }

    public String get_telephoneAccompagnateur()
    {
        return _telephoneAccompagnateur.get();
    }

    public int get_numRueAccompagnateur()
    {
        return _numRueAccompagnateur.get();
    }

    public String get_rueAccompagnateur()
    {
        return _rueAccompagnateur.get();
    }

    public String get_villeAccompagnateur()
    {
        return _villeAccompagnateur.get();
    }

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
