/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Modele Circuit.
 * @author Julien Creach
 * @version 2.0
 */
public class Circuit
{

    //region Private Attributs

    /**
     * index du circuit.
     */
    private SimpleIntegerProperty _idCircuit;

    /**
     * nom du circuit.
     */
    private SimpleStringProperty _nameCircuit;

    /**
     * Nombre de places.
     */
    private SimpleIntegerProperty _places;

    /**
     * Prix du circuit.
     */
    private SimpleIntegerProperty _prix;

    /**
     * date debut circuit.
     */
    private SimpleStringProperty _dateDepart;

    /**
     * date de fin circuit.
     */
    private  SimpleStringProperty _dateFin;

    /**
     * Etat du circuit ouvert ou non.
     */
    private SimpleBooleanProperty _open;

    /**
     * index de l'accompagnateur du circuit (peut etre null).
     */
    private SimpleIntegerProperty _idAccompagnateur;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index circuit.
     * @return index circuit
     */
    public int get_idCircuit()
    {
        return _idCircuit.get();
    }

    /**
     * Setter index circuit.
     * @param _idCircuit index du circuit
     */
    public void set_idCircuit(int _idCircuit)
    {
        this._idCircuit.set(_idCircuit);
    }

    /**
     * Getter nom du circuit.
     * @return nom du circuit
     */
    public String get_nameCircuit()
    {
        return _nameCircuit.get();
    }

    /**
     * Getter nombre de places.
     * @return nombre de place
     */
    public int get_places()
    {
        return _places.get();
    }

    /**
     * Getter prix circuit.
     * @return prix du circuit
     */
    public int get_prix()
    {
        return _prix.get();
    }

    /**
     * Getter date de debut du circuit.
     * @return date de depart du circuit
     */
    public String get_dateDepart()
    {
        return _dateDepart.get();
    }

    /**
     * Getter date fin du circuit.
     * @return date de fin du circuit
     */
    public String get_dateFin()
    {
        return _dateFin.get();
    }

    /**
     * Getter sur l'etat du circuit.
     * @return etat du circuit ouvert ou non
     */
    public boolean is_open()
    {
        return _open.get();
    }

    /**
     * Getter index accompagnateur.
     * @return index accompagnateur
     */
    public int get_idAccompagnateur()
    {
        return _idAccompagnateur.get();
    }

    //endregion Public Attributs

    //region Constructors

    /**
     * Constructeur par defaut.
     */
    public Circuit()
    {

    }

    /**
     * Constructeur.
     * @param id index du circuit
     * @param name nom du ircuit
     * @param nbPlaces nombre de place dans le circuit
     * @param prix prix du circuit
     * @param dateDepart date de debut du circuit
     * @param dateFin date de fin du circuit
     * @param open etat du circuit
     * @param idAccompagnateur index de l'accompagnant
     */
    public Circuit(int id, String name, int nbPlaces, int prix, String dateDepart, String dateFin, boolean open, int idAccompagnateur)
    {
        this._idCircuit = new SimpleIntegerProperty(id);
        this._nameCircuit = new SimpleStringProperty(name);
        this._places = new SimpleIntegerProperty(nbPlaces);
        this._prix = new SimpleIntegerProperty(prix);
        this._dateDepart = new SimpleStringProperty(dateDepart);
        this._dateFin = new SimpleStringProperty(dateFin);
        this._open = new SimpleBooleanProperty(open);
        this._idAccompagnateur = new SimpleIntegerProperty(idAccompagnateur);
    }
    //endregion Constructors

    /**
     * Override toString.
     * @return Value
     */
    @Override
    public String toString()
    {
        return new String( "Id : "+this._idCircuit+"\n"
                +"Nom : "+this._nameCircuit+"\n"
                +"Places disponnibles : "+this._places+"\n"
                +"Prix : "+this._prix+"\n"
                +"Date de départ : "+this._dateDepart+"\n"
                +"Date d'arrive : "+this._dateFin+"\n"
                +"Resevation annulée : "+this._open+"\n"
                +"Id accompagnateur : "+this._idAccompagnateur+"\n");
    }
}
