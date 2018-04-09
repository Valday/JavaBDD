package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Reservation
{
    //region Private Attributs

    private SimpleIntegerProperty _idResevation;

    private SimpleBooleanProperty _accompte;

    private SimpleBooleanProperty _secondPaiement;

    private SimpleIntegerProperty _accompteValue;

    private SimpleIntegerProperty _secondPaiementValue;

    private SimpleStringProperty _dateLimite;

    private SimpleStringProperty _dateReservation;

    private SimpleBooleanProperty _cancelResevation;

    private SimpleIntegerProperty _idClient;

    private SimpleIntegerProperty _idCircuit;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idResevation() {
        return _idResevation.get();
    }

    public SimpleIntegerProperty _idResevationProperty() {
        return _idResevation;
    }

    public void set_idResevation(int _idResevation) {
        this._idResevation.set(_idResevation);
    }

    public boolean is_accompte() {
        return _accompte.get();
    }

    public SimpleBooleanProperty _accompteProperty() {
        return _accompte;
    }

    public void set_accompte(boolean _accompte) {
        this._accompte.set(_accompte);
    }

    public boolean is_secondPaiement() {
        return _secondPaiement.get();
    }

    public SimpleBooleanProperty _secondPaiementProperty() {
        return _secondPaiement;
    }

    public void set_secondPaiement(boolean _secondPaiement) {
        this._secondPaiement.set(_secondPaiement);
    }

    public int get_accompteValue() {
        return _accompteValue.get();
    }

    public SimpleIntegerProperty _accompteValueProperty() {
        return _accompteValue;
    }

    public void set_accompteValue(int _accompteValue) {
        this._accompteValue.set(_accompteValue);
    }

    public int get_secondPaiementValue() {
        return _secondPaiementValue.get();
    }

    public SimpleIntegerProperty _secondPaiementValueProperty() {
        return _secondPaiementValue;
    }

    public void set_secondPaiementValue(int _secondPaiementValue) {
        this._secondPaiementValue.set(_secondPaiementValue);
    }

    public String get_dateLimite() {
        return _dateLimite.get();
    }

    public SimpleStringProperty _dateLimiteProperty() {
        return _dateLimite;
    }

    public void set_dateLimite(String _dateLimite) {
        this._dateLimite.set(_dateLimite);
    }

    public String get_dateReservation() {
        return _dateReservation.get();
    }

    public SimpleStringProperty _dateReservationProperty() {
        return _dateReservation;
    }

    public void set_dateReservation(String _dateReservation) {
        this._dateReservation.set(_dateReservation);
    }

    public boolean is_cancelResevation() {
        return _cancelResevation.get();
    }

    public SimpleBooleanProperty _cancelResevationProperty() {
        return _cancelResevation;
    }

    public void set_cancelResevation(boolean _cancelResevation) {
        this._cancelResevation.set(_cancelResevation);
    }

    public int get_idClient() {
        return _idClient.get();
    }

    public SimpleIntegerProperty _idClientProperty() {
        return _idClient;
    }

    public void set_idClient(int _idClient) {
        this._idClient.set(_idClient);
    }

    public int get_idCircuit() {
        return _idCircuit.get();
    }

    public SimpleIntegerProperty _idCircuitProperty() {
        return _idCircuit;
    }

    public void set_idCircuit(int _idCircuit) {
        this._idCircuit.set(_idCircuit);
    }


    //endregion Public Attributs


    //region Constructors

    public Reservation()
    {

    }

    public Reservation(int id, boolean accompteOk,boolean secondPaiementOK, String dateLimite, String dateReservation, boolean cancel, int accompte, int secondPaiement, int idClient, int idCircuit)
    {
        this._idResevation = new SimpleIntegerProperty(id);
        this._accompte = new SimpleBooleanProperty(accompteOk);
        this._secondPaiement = new SimpleBooleanProperty(secondPaiementOK);
        this._accompteValue = new SimpleIntegerProperty(accompte);
        this._secondPaiementValue = new SimpleIntegerProperty(secondPaiement);
        this._dateLimite = new SimpleStringProperty(dateLimite);
        this._dateReservation = new SimpleStringProperty(dateReservation);
        this._cancelResevation = new SimpleBooleanProperty(cancel);
        this._idClient = new SimpleIntegerProperty(idClient);
        this._idCircuit = new SimpleIntegerProperty(idCircuit);
    }

    //endregion Constructors
}
