package com.valday.GestionAgenceVoyage.Table;

import java.util.Date;

public class Circuit
{

    //region Private Attributs

    private int _id;

    private String _name;

    private int _placesDispo;

    private Date _dateDepart;

    private  Date _dateFin;

    private boolean _cancel;

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

    public String get_name()
    {
        return _name;
    }

    public void set_name(String _name)
    {
        this._name = _name;
    }

    public int get_placesDispo()
    {
        return _placesDispo;
    }

    public void set_placesDispo(int _placesDispo)
    {
        this._placesDispo = _placesDispo;
    }

    public Date get_dateDepart()
    {
        return _dateDepart;
    }

    public void set_dateDepart(Date _dateDepart)
    {
        this._dateDepart = _dateDepart;
    }

    public Date get_dateFin()
    {
        return _dateFin;
    }

    public void set_dateFin(Date _dateFin)
    {
        this._dateFin = _dateFin;
    }

    public boolean is_cancel()
    {
        return _cancel;
    }

    public void set_cancel(boolean _cancel)
    {
        this._cancel = _cancel;
    }

    //endregion Public Attributs

    //region Constructors

    public Circuit()
    {

    }

    public Circuit(int id, String name, int nbPlaces, Date dateDepart, Date dateFin, boolean cancel)
    {
        this._id = id;
        this._name = name;
        this._placesDispo = nbPlaces;
        this._dateDepart = dateDepart;
        this._dateFin = dateFin;
        this._cancel = cancel;
    }
    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._id+"\n"
                +"Nom : "+this._name+"\n"
                +"Places disponnibles : "+this._placesDispo+"\n"
                +"Date de départ : "+this._dateDepart+"\n"
                +"Date d'arrive : "+this._dateFin+"\n"
                +"Resevation annulée : "+this._cancel+"\n");
    }
}
