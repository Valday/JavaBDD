package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class Visite
{
    //region Private Attributs

    private SimpleIntegerProperty _idVisite;

    private SimpleIntegerProperty _nbNuits;

    private SimpleObjectProperty<Date> _dateArrivee;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idVisite() {
        return _idVisite.get();
    }

    public SimpleIntegerProperty _idVisiteProperty() {
        return _idVisite;
    }

    public void set_idVisite(int _idVisite) {
        this._idVisite.set(_idVisite);
    }

    public int get_nbNuits() {
        return _nbNuits.get();
    }

    public SimpleIntegerProperty _nbNuitsProperty() {
        return _nbNuits;
    }

    public void set_nbNuits(int _nbNuits) {
        this._nbNuits.set(_nbNuits);
    }

    public Date get_dateArrivee() {
        return _dateArrivee.get();
    }

    public SimpleObjectProperty<Date> _dateArriveeProperty() {
        return _dateArrivee;
    }

    public void set_dateArrivee(Date _dateArrivee) {
        this._dateArrivee.set(_dateArrivee);
    }


    //endregion Public Attributs

    //region Constructors

    public Visite()
    {

    }

    public Visite(int id, int nbNuits, Date dateArrivee)
    {
        this._idVisite = new SimpleIntegerProperty(id);
        this._nbNuits = new SimpleIntegerProperty(nbNuits);
        this._dateArrivee = new SimpleObjectProperty<>(dateArrivee);
        this._dateArrivee = new SimpleObjectProperty<>(dateArrivee);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Nombre de nuit : "+this._nbNuits+"\n"
                +"Date d'arrivée : "+this._dateArrivee+"\n");
    }
}
