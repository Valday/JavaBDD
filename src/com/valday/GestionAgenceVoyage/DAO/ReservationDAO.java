package com.valday.GestionAgenceVoyage.DAO;

import com.valday.GestionAgenceVoyage.Table.Reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO extends DAO<Reservation>
{
    public ReservationDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Create(Reservation obj) {
        return false;
    }

    @Override
    public boolean Delete(Reservation obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Reservation WHERE Codereservation = " +obj.get_id());
                toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Update(Reservation obj) {
        return false;
    }

    @Override
    public Reservation find(int id) {
        Reservation reservation = new Reservation();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE Codereservation = "+ id);

            if (resultSet.first())
            {
                reservation = new Reservation(
                        id,
                        resultSet.getBoolean("Acccompteverse"),
                        resultSet.getBoolean("SeconPaiement"),
                        resultSet.getInt("Montantaccompte"),
                        resultSet.getInt("Montantpaiement"),
                        resultSet.getDate("Datelimite"),
                        resultSet.getDate("Datereservation"),
                        resultSet.getBoolean("Annulation"),
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
}
