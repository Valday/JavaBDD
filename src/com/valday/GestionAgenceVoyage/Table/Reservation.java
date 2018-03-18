package com.valday.GestionAgenceVoyage.Table;

import java.util.Date;

public class Reservation
{
    //region Private Attributs

    private int _id;

    private Boolean _accompte;

    private Boolean _secondPaiement;

    private int _accompteValue;

    private int _secondPaiementValue;

    private Date _dateLimite;

    private Date _dateReservation;

    private Boolean _cancel;

    private int _idClient;

    private int _idCircuit;

    //endregion Private Attributs

    //region Public Attributs

    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public Boolean get_accompte()
    {
        return _accompte;
    }

    public void set_accompte(Boolean _accompte)
    {
        this._accompte = _accompte;
    }

    public Boolean get_secondPaiement()
    {
        return _secondPaiement;
    }

    public void set_secondPaiement(Boolean _secondPaiement)
    {
        this._secondPaiement = _secondPaiement;
    }

    public int get_accompteValue()
    {
        return _accompteValue;
    }

    public void set_accompteValue(int _accompteValue)
    {
        this._accompteValue = _accompteValue;
    }

    public int get_secondPaiementValue()
    {
        return _secondPaiementValue;
    }

    public void set_secondPaiementValue(int _secondPaiementValue)
    {
        this._secondPaiementValue = _secondPaiementValue;
    }

    public Date get_dateLimite() {
        return _dateLimite;
    }

    public void set_dateLimite(Date _dateLimite)
    {
        this._dateLimite = _dateLimite;
    }

    public Date get_dateReservation()
    {
        return _dateReservation;
    }

    public void set_dateReservation(Date _dateReservation)
    {
        this._dateReservation = _dateReservation;
    }

    public Boolean get_cancel() {
        return _cancel;
    }

    public void set_cancel(Boolean _cancel)
    {
        this._cancel = _cancel;
    }

    public int get_idClient()
    {
        return _idClient;
    }

    public void set_idClient(int _idClient)
    {
        this._idClient = _idClient;
    }

    public int get_idCircuit()
    {
        return _idCircuit;
    }

    public void set_idCircuit(int _idCircuit)
    {
        this._idCircuit = _idCircuit;
    }

    //endregion Public Attributs


    //region Constructors

    public Reservation()
    {

    }

    public Reservation(int id, boolean accompteOk,boolean secondPaiementOK, int accompte, int secondPaiement, Date dateLimite, Date dateReservation, boolean cancel, int idClient, int idCircuit)
    {
        this._id = id;
        this._accompte = accompteOk;
        this._secondPaiement = secondPaiementOK;
        this._dateLimite = dateLimite;
        this._dateReservation = dateReservation;
        this._cancel = cancel;
    }

    //endregion Constructors
}
