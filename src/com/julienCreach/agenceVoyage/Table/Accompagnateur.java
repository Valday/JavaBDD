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

    public int get_idAccompagnateur() {
        return _idAccompagnateur.get();
    }

    public SimpleIntegerProperty _idAccompagnateurProperty() {
        return _idAccompagnateur;
    }

    public void set_idAccompagnateur(int _idAccompagnateur) {
        this._idAccompagnateur.set(_idAccompagnateur);
    }

    public String get_nameAccompagnateur() {
        return _nameAccompagnateur.get();
    }

    public SimpleStringProperty _nameAccompagnateurProperty() {
        return _nameAccompagnateur;
    }

    public void set_nameAccompagnateur(String _nameAccompagnateur) {
        this._nameAccompagnateur.set(_nameAccompagnateur);
    }

    public String get_prenomAccompagnateur() {
        return _prenomAccompagnateur.get();
    }

    public SimpleStringProperty _prenomAccompagnateurProperty() {
        return _prenomAccompagnateur;
    }

    public void set_prenomAccompagnateur(String _prenomAccompagnateur) {
        this._prenomAccompagnateur.set(_prenomAccompagnateur);
    }

    public String get_telephoneAccompagnateur() {
        return _telephoneAccompagnateur.get();
    }

    public SimpleStringProperty _telephoneAccompagnateurProperty() {
        return _telephoneAccompagnateur;
    }

    public void set_telephoneAccompagnateur(String _telephoneAccompagnateur) {
        this._telephoneAccompagnateur.set(_telephoneAccompagnateur);
    }

    public int get_numRueAccompagnateur() {
        return _numRueAccompagnateur.get();
    }

    public SimpleIntegerProperty _numRueAccompagnateurProperty() {
        return _numRueAccompagnateur;
    }

    public void set_numRueAccompagnateur(int _numRueAccompagnateur) {
        this._numRueAccompagnateur.set(_numRueAccompagnateur);
    }

    public String get_rueAccompagnateur() {
        return _rueAccompagnateur.get();
    }

    public SimpleStringProperty _rueAccompagnateurProperty() {
        return _rueAccompagnateur;
    }

    public void set_rueAccompagnateur(String _rueAccompagnateur) {
        this._rueAccompagnateur.set(_rueAccompagnateur);
    }

    public String get_villeAccompagnateur() {
        return _villeAccompagnateur.get();
    }

    public SimpleStringProperty _villeAccompagnateurProperty() {
        return _villeAccompagnateur;
    }

    public void set_villeAccompagnateur(String _villeAccompagnateur) {
        this._villeAccompagnateur.set(_villeAccompagnateur);
    }

    public String get_codePostalAccompagnateur() {
        return _codePostalAccompagnateur.get();
    }

    public SimpleStringProperty _codePostalAccompagnateurProperty() {
        return _codePostalAccompagnateur;
    }

    public void set_codePostalAccompagnateur(String _codePostalAccompagnateur) {
        this._codePostalAccompagnateur.set(_codePostalAccompagnateur);
    }


//endregion Public Attributs

    //region Constructors

    public Accompagnateur()
    {

    }

    public Accompagnateur(int id, String name, String prenom, String telephone,int numRue, String rue, String ville, String codePostal)
    {
        this._idAccompagnateur = new SimpleIntegerProperty(id);
        this._nameAccompagnateur = new SimpleStringProperty(name);
        this._prenomAccompagnateur = new SimpleStringProperty(prenom);
        this._telephoneAccompagnateur = new SimpleStringProperty(telephone);
        this._numRueAccompagnateur = new SimpleIntegerProperty(numRue);
        this._rueAccompagnateur = new SimpleStringProperty(rue);
        this._villeAccompagnateur = new SimpleStringProperty(ville);
        this._codePostalAccompagnateur = new SimpleStringProperty(codePostal);
    }

    //endregion Constructors


    @Override
    public String toString() {
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
}
