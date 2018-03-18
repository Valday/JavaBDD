package com.valday.GestionAgenceVoyage.Table;

public class Accompagnateur
{
    //region Private Attributs

    private int _id;

    private String _name;

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


    //endregion Public Attributs

    //region Constructors

    public Accompagnateur()
    {

    }

    public Accompagnateur(int id, String name)
    {
        this._id = id;
        this._name = name;
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._id+"\n"
                +"Nom : "+this._name+"\n");
    }
}
