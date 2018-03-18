package com.valday.GestionAgenceVoyage.Table;

import java.util.Date;

public class Visite
{
    //region Private Attributs

    private int _id;

    private int _nbNuits;

    private Date _dateArrivee;

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

    public int get_nbNuits()
    {
        return _nbNuits;
    }

    public void set_nbNuits(int _nbNuits)
    {
        this._nbNuits = _nbNuits;
    }

    public Date get_dateArrivee()
    {
        return _dateArrivee;
    }

    public void set_dateArrivee(Date _dateArrivee)
    {
        this._dateArrivee = _dateArrivee;
    }

    //endregion Public Attributs

    //region Constructors

    public Visite()
    {

    }

    public Visite(int id, int nbNuits, Date dateArrivee)
    {
        this._id = id;
        this._nbNuits = nbNuits;
        this._dateArrivee = dateArrivee;
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Nombre de nuit : "+this._nbNuits+"\n"
                +"Date d'arrivée : "+this._dateArrivee+"\n");
    }
}
