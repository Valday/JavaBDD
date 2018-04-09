package com.valday.agenceVoyage.Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Client
{
    //region Private Attributs

    private SimpleIntegerProperty _idClient;

    private SimpleStringProperty _nameClient;

    private SimpleStringProperty _userName;

    private SimpleStringProperty _mdp;

    private SimpleStringProperty _prenomClient;

    private SimpleStringProperty _telephoneClient;

    private SimpleStringProperty _villeClient;

    private SimpleStringProperty _rueClient;

    private SimpleIntegerProperty _numRueClient;

    private SimpleStringProperty _codePostalClient;

    private SimpleStringProperty _dateNaissanceClient;

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

    public String get_userName() {
        return _userName.get();
    }

    public SimpleStringProperty _userNameProperty() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName.set(_userName);
    }

    public String get_mdp() {
        return _mdp.get();
    }

    public SimpleStringProperty _mdpProperty() {
        return _mdp;
    }

    public void set_mdp(String _mdp) {
        this._mdp.set(_mdp);
    }

    public String get_prenomClient() {
        return _prenomClient.get();
    }

    public SimpleStringProperty _prenomClientProperty() {
        return _prenomClient;
    }

    public void set_prenomClient(String _prenomClient) {
        this._prenomClient.set(_prenomClient);
    }

    public String get_telephoneClient() {
        return _telephoneClient.get();
    }

    public SimpleStringProperty _telephoneClientProperty() {
        return _telephoneClient;
    }

    public void set_telephoneClient(String _telephoneClient) {
        this._telephoneClient.set(_telephoneClient);
    }

    public String get_villeClient() {
        return _villeClient.get();
    }

    public SimpleStringProperty _villeClientProperty() {
        return _villeClient;
    }

    public void set_villeClient(String _villeClient) {
        this._villeClient.set(_villeClient);
    }

    public String get_rueClient() {
        return _rueClient.get();
    }

    public SimpleStringProperty _rueClientProperty() {
        return _rueClient;
    }

    public void set_rueClient(String _rueClient) {
        this._rueClient.set(_rueClient);
    }

    public int get_numRueClient() {
        return _numRueClient.get();
    }

    public SimpleIntegerProperty _numRueClientProperty() {
        return _numRueClient;
    }

    public void set_numRueClient(int _numRueClient) {
        this._numRueClient.set(_numRueClient);
    }

    public String get_codePostalClient() {
        return _codePostalClient.get();
    }

    public SimpleStringProperty _codePostalClientProperty() {
        return _codePostalClient;
    }

    public void set_codePostalClient(String _codePostalClient) {
        this._codePostalClient.set(_codePostalClient);
    }

    public String get_dateNaissanceClient() {
        return _dateNaissanceClient.get();
    }

    public SimpleStringProperty _dateNaissanceClientProperty() {
        return _dateNaissanceClient;
    }

    public void set_dateNaissanceClient(String _dateNaissanceClient) {
        this._dateNaissanceClient.set(_dateNaissanceClient);
    }


//endregion Public Attributs

    //region Constructors

    public Client()
    {

    }

    public Client(int id, String name, String userName, String password, String prenom, String telephone, String ville, String rue, int numRue, String codePostal, String dateNaissance)
    {
        this._idClient = new SimpleIntegerProperty(id);
        this._nameClient = new SimpleStringProperty(name);
        this._userName = new SimpleStringProperty(userName);
        this._mdp = new SimpleStringProperty(password);
        this._prenomClient = new SimpleStringProperty(prenom);
        this._telephoneClient = new SimpleStringProperty(telephone);
        this._villeClient = new SimpleStringProperty(ville);
        this._rueClient = new SimpleStringProperty(rue);
        this._numRueClient = new SimpleIntegerProperty(numRue);
        this._codePostalClient = new SimpleStringProperty(codePostal);
        this._dateNaissanceClient = new SimpleStringProperty(dateNaissance);
    }

    //endregion Constructors

    @Override
    public String toString()
    {
        return new String( "Id : "+this._idClient+"\n"
                +"Nom : "+this._nameClient+"\n");
    }

}
