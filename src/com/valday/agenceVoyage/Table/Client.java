package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client
{
    //region Private Attributs

    private SimpleIntegerProperty _idClient;

    private SimpleStringProperty _nameClient;

    //endregion Private Attributs

    //region Public Attributs

    public int get_idClient() {
        return _idClient.get();
    }

    public SimpleIntegerProperty _idClientProperty() {
        return _idClient;
    }

    public void set_idClient(int _idClient) {
        this._idClient.set(_idClient);
    }

    public String get_nameClient() {
        return _nameClient.get();
    }

    public SimpleStringProperty _nameClientProperty() {
        return _nameClient;
    }

    public void set_nameClient(String _nameClient) {
        this._nameClient.set(_nameClient);
    }


    //endregion Public Attributs

    //region Constructors

    public Client()
    {

    }

    public Client(int id, String name)
    {
        this._idClient = new SimpleIntegerProperty(id);
        this._nameClient = new SimpleStringProperty(name);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idClient+"\n"
                +"Nom : "+this._nameClient+"\n");
    }

}
