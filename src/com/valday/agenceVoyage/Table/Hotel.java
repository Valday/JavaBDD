package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Hotel
{
    //region Private Attributs

    private SimpleIntegerProperty _idHotel;

    private SimpleStringProperty _nameHotel;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idHotel()
    {
        return _idHotel.get();
    }

    public SimpleIntegerProperty _idHotelProperty()
    {
        return _idHotel;
    }

    public void set_idHotel(int _idHotel)
    {
        this._idHotel.set(_idHotel);
    }

    public String get_nameHotel()
    {
        return _nameHotel.get();
    }

    public SimpleStringProperty _nameHotelProperty()
    {
        return _nameHotel;
    }

    public void set_nameHotel(String _nameHotel)
    {
        this._nameHotel.set(_nameHotel);
    }


    //endregion Public Attributs

    //region Constructors

    public Hotel()
    {

    }

    public Hotel(int id, String name)
    {
        this._idHotel = new SimpleIntegerProperty(id);
        this._nameHotel = new SimpleStringProperty(name);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idHotel+"\n"
                +"Nom : "+this._nameHotel+"\n");
    }

}
