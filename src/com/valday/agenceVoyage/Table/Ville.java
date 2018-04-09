package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ville
{
    //region Private Attributs

    private SimpleIntegerProperty _idVille;

    private SimpleStringProperty _nameVille;

    private SimpleIntegerProperty _idHotel;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idVille() {
        return _idVille.get();
    }

    public SimpleIntegerProperty _idVilleProperty() {
        return _idVille;
    }

    public void set_idVille(int _idVille) {
        this._idVille.set(_idVille);
    }

    public String get_nameVille() {
        return _nameVille.get();
    }

    public SimpleStringProperty _nameVilleProperty() {
        return _nameVille;
    }

    public void set_nameVille(String _nameVille) {
        this._nameVille.set(_nameVille);
    }

    public int get_idHotel() {
        return _idHotel.get();
    }

    public SimpleIntegerProperty _idHotelProperty() {
        return _idHotel;
    }

    public void set_idHotel(int _idHotel) {
        this._idHotel.set(_idHotel);
    }

//endregion Public Attributs

    //region Constructors

    public Ville()
    {

    }

    public Ville(int id, String name, int idHotel)
    {
        this._idVille = new SimpleIntegerProperty(id);
        this._nameVille = new SimpleStringProperty(name);
        this._idHotel = new SimpleIntegerProperty(idHotel);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idVille+"\n"
                +"Nom : "+this._nameVille+"\n");
    }

}
