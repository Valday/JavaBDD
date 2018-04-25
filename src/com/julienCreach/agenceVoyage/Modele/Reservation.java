/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.Modele;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Modele Reservation.
 * @author Julien Creach
 * @version 2.0
 */
public class Reservation
{
    //region Private Attributs

    /**
     * index resservation.
     */
    private SimpleIntegerProperty _idResevation;

    /**
     * Etat versement acompte.
     */
    private SimpleBooleanProperty _acompte;

    /**
     * Etat second versement.
     */
    private SimpleBooleanProperty _secondPaiement;

    /**
     * Montant acompte.
     */
    private SimpleIntegerProperty _acompteValue;

    /**
     * Montant second versement.
     */
    private SimpleIntegerProperty _secondPaiementValue;

    /**
     * date limite de paiement.
     */
    private SimpleStringProperty _dateLimite;

    /**
     * Date de réservation.
     */
    private SimpleStringProperty _dateReservation;

    /**
     * Etat de la reservation.
     */
    private SimpleBooleanProperty _cancelResevation;

    /**
     * index du client.
     */
    private SimpleIntegerProperty _idClient;

    /**
     * index du circuit.
     */
    private SimpleIntegerProperty _idCircuit;

    //endregion Private Attributs

    //region Public Attributs

    /**
     * Getter index reservation.
     * @return index reservation
     */
    public int get_idResevation()
    {
        return _idResevation.get();
    }

    /**
     * Setter index reservation.
     * @param _idResevation index reservation
     */
    public void set_idResevation(int _idResevation)
    {
        this._idResevation.set(_idResevation);
    }

    /**
     * Getter etat acompte.
     * @return etat acompte
     */
    public boolean is_acompte()
    {
        return _acompte.get();
    }

    /**
     * Getter etat second paiement.
     * @return etat second paiement.
     */
    public boolean is_secondPaiement()
    {
        return _secondPaiement.get();
    }

    /**
     * Getter montant acompte.
     * @return montant acompte
     */
    public int get_acompteValue()
    {
        return _acompteValue.get();
    }

    /**
     * Getter montant second paiement.
     * @return montant second paiement
     */
    public int get_secondPaiementValue()
    {
        return _secondPaiementValue.get();
    }

    /**
     * Getter date limite.
     * @return date limite
     */
    public String get_dateLimite()
    {
        return _dateLimite.get();
    }

    /**
     * Getter date de réservation.
     * @return date de reservation
     */
    public String get_dateReservation()
    {
        return _dateReservation.get();
    }

    /**
     * Getter etat reservation.
     * @return etat reservation
     */
    public boolean is_cancelResevation()
    {
        return _cancelResevation.get();
    }

    /**
     * Getter index client.
     * @return index client
     */
    public int get_idClient()
    {
        return _idClient.get();
    }

    /**
     * Getter index circuit.
     * @return index circuit
     */
    public int get_idCircuit()
    {
        return _idCircuit.get();
    }

    //endregion Public Attributs


    //region Constructors

    /**
     * Constructeur par defaut.
     */
    private Reservation()
    {

    }

    /**
     * Constructeur.
     * @param id index reservation
     * @param accompteOk accompte versé?
     * @param secondPaiementOK second paiement versé?
     * @param dateLimite date limite de paiement
     * @param dateReservation date de réservation
     * @param cancel Reservation effective ou non
     * @param accompte montant de l'accompte
     * @param secondPaiement montant du second paiement
     * @param idClient index du client qui reserve
     * @param idCircuit index du circuit
     */
    public Reservation(int id, boolean accompteOk,boolean secondPaiementOK, String dateLimite, String dateReservation, boolean cancel, int accompte, int secondPaiement, int idClient, int idCircuit)
    {
        this._idResevation = new SimpleIntegerProperty(id);
        this._acompte = new SimpleBooleanProperty(accompteOk);
        this._secondPaiement = new SimpleBooleanProperty(secondPaiementOK);
        this._acompteValue = new SimpleIntegerProperty(accompte);
        this._secondPaiementValue = new SimpleIntegerProperty(secondPaiement);
        this._dateLimite = new SimpleStringProperty(dateLimite);
        this._dateReservation = new SimpleStringProperty(dateReservation);
        this._cancelResevation = new SimpleBooleanProperty(cancel);
        this._idClient = new SimpleIntegerProperty(idClient);
        this._idCircuit = new SimpleIntegerProperty(idCircuit);
    }

    //endregion Constructors
}
