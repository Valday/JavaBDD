package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Circuit
{

    //region Private Attributs

    private SimpleIntegerProperty _idCircuit;

    private SimpleStringProperty _nameCircuit;

    private SimpleIntegerProperty _placesDispo;

    private SimpleObjectProperty<Date> _dateDepart;

    private  SimpleObjectProperty<Date> _dateFin;

    private SimpleBooleanProperty _cancelCircuit;

    //endregion Private Attributs

    //region Public Attributs


    public int get_idCircuit() {
        return _idCircuit.get();
    }

    public SimpleIntegerProperty _idCircuitProperty() {
        return _idCircuit;
    }

    public void set_idCircuit(int _idCircuit) {
        this._idCircuit.set(_idCircuit);
    }

    public String get_nameCircuit() {
        return _nameCircuit.get();
    }

    public SimpleStringProperty _nameCircuitProperty() {
        return _nameCircuit;
    }

    public void set_nameCircuit(String _nameCircuit) {
        this._nameCircuit.set(_nameCircuit);
    }

    public boolean is_cancelCircuit() {
        return _cancelCircuit.get();
    }

    public SimpleBooleanProperty _cancelCircuitProperty() {
        return _cancelCircuit;
    }

    public void set_cancelCircuit(boolean _cancelCircuit) {
        this._cancelCircuit.set(_cancelCircuit);
    }

    public int get_placesDispo() {
        return _placesDispo.get();
    }

    public SimpleIntegerProperty _placesDispoProperty() {
        return _placesDispo;
    }

    public void set_placesDispo(int _placesDispo) {
        this._placesDispo.set(_placesDispo);
    }

    public Date get_dateDepart() {
        return _dateDepart.get();
    }

    public SimpleObjectProperty<Date> _dateDepartProperty() {
        return _dateDepart;
    }

    public void set_dateDepart(Date _dateDepart) {
        this._dateDepart.set(_dateDepart);
    }

    public Date get_dateFin() {
        return _dateFin.get();
    }

    public SimpleObjectProperty<Date> _dateFinProperty() {
        return _dateFin;
    }

    public void set_dateFin(Date _dateFin) {
        this._dateFin.set(_dateFin);
    }

    //endregion Public Attributs

    //region Constructors

    public Circuit()
    {

    }

    public Circuit(int id, String name, int nbPlaces, Date dateDepart, Date dateFin, boolean cancel)
    {
        this._idCircuit = new SimpleIntegerProperty(id);
        this._nameCircuit = new SimpleStringProperty(name);
        this._placesDispo = new SimpleIntegerProperty(nbPlaces);
        this._dateDepart = new SimpleObjectProperty<>(dateDepart);
        this._dateFin = new SimpleObjectProperty<>(dateFin);
        this._cancelCircuit = new SimpleBooleanProperty(cancel);
    }
    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idCircuit+"\n"
                +"Nom : "+this._nameCircuit+"\n"
                +"Places disponnibles : "+this._placesDispo+"\n"
                +"Date de départ : "+this._dateDepart+"\n"
                +"Date d'arrive : "+this._dateFin+"\n"
                +"Resevation annulée : "+this._cancelCircuit+"\n");
    }
}
