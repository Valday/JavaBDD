/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.DAO;

import com.julienCreach.agenceVoyage.Modele.Reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO reservation.
 * @author Julien Creach
 * @version 1.0
 */
public class ReservationDAO extends DAO<Reservation>
{
    //region Constructeur

    /**
     * Constructeur.
     * @param connect connexion
     */
    public ReservationDAO(Connection connect)
    {
        super(connect);
    }

    //endregion Constructeur

    //region Public Services

    @Override
    public boolean Add(Reservation obj)
    {
        boolean toReturn = false;
        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Reservations (acompteVerse,secondPaiement,dateLimitePaiement,dateReservation,annulation,acompteMontant,secondPaiementMontant,idClient,idCircuit) VALUES ("
                    +(obj.is_acompte()? 1 : 0)+","
                    +(obj.is_secondPaiement()? 1 : 0)+",'"
                    +obj.get_dateLimite()+"','"
                    +obj.get_dateReservation()+"',"
                    +(obj.is_cancelResevation()? 1 : 0)+","
                    +obj.get_acompteValue()+","
                    +obj.get_secondPaiementValue()+","
                    +obj.get_idClient()+","
                    +obj.get_idCircuit()+")");

            if(resultSet != null)
            {
                toReturn = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;
    }

    @Override
    public boolean Delete(Reservation obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Reservations WHERE idReservation = " +obj.get_idResevation());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Edit(Reservation obj)
    {
        boolean toReturn = false;

        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Reservations SET acompteVerse = "+(obj.is_acompte()? 1 : 0)
                    +", secondPaiement = "+(obj.is_secondPaiement()? 1 : 0)
                    +", dateLimitePaiement = '"+obj.get_dateLimite()
                    +"', dateReservation = '"+obj.get_dateReservation()
                    +"', annulation = "+(obj.is_cancelResevation()? 1 : 0)
                    +", acompteMontant ="+obj.get_acompteValue()
                    +", secondPaiementMontant = "+obj.get_secondPaiementValue()
                    +", idClient = "+obj.get_idClient()
                    +", idCircuit = "+obj.get_idCircuit()
                    +" WHERE idCircuit="+ obj.get_idCircuit());
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public Reservation find(int id)
    {
        Reservation reservation = null;

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservations WHERE idReservation = "+ id);

            if (resultSet.first())
            {
                reservation = new Reservation(
                        id,
                        resultSet.getBoolean("Acccompteverse"),
                        resultSet.getBoolean("SeconPaiement"),
                        resultSet.getString("Datelimite"),
                        resultSet.getString("Datereservation"),
                        resultSet.getBoolean("Annulation"),
                        resultSet.getInt("Montantaccompte"),
                        resultSet.getInt("Montantpaiement"),
                        resultSet.getInt("Codeclient"),
                        resultSet.getInt("Codecircuit")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return reservation;
    }

    //endregion Public Services
}
