package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Accompagnateur
{
    //region Private Attributs

    private SimpleIntegerProperty _idAccompagnateur;

    private SimpleStringProperty _nameAccompagnateur;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idAccompagnateur() {
        return _idAccompagnateur.get();
    }

    public SimpleIntegerProperty _idAccompagnateurProperty() {
        return _idAccompagnateur;
    }

    public void set_idAccompagnateur(int _idAccompagnateur) {
        this._idAccompagnateur.set(_idAccompagnateur);
    }

    public String get_nameAccompagnateur() {
        return _nameAccompagnateur.get();
    }

    public SimpleStringProperty _nameAccompagnateurProperty() {
        return _nameAccompagnateur;
    }

    public void set_nameAccompagnateur(String _nameAccompagnateur) {
        this._nameAccompagnateur.set(_nameAccompagnateur);
    }


    //endregion Public Attributs

    //region Constructors

    public Accompagnateur()
    {

    }

    public Accompagnateur(int id, String name)
    {
        this._idAccompagnateur = new SimpleIntegerProperty(id);
        this._nameAccompagnateur = new SimpleStringProperty(name);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idAccompagnateur+"\n"
                +"Nom : "+this._nameAccompagnateur+"\n");
    }
}
