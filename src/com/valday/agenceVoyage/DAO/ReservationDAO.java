package com.valday.agenceVoyage.DAO;

import com.valday.agenceVoyage.Table.Reservation;

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
    public boolean Add(Reservation obj) {
        boolean toReturn = false;
        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Reservations (idReservation,acompteVerse,secondPaiement,dateLimitePaiement,dateReservation,annulation,acompteMontant,secondPaiementMontant,idClient,idCircuit) VALUES ("
                    +obj.get_idResevation()+","
                    +(obj.is_accompte()? 1 : 0)+","
                    +(obj.is_secondPaiement()? 1 : 0)+",'"
                    +obj.get_dateLimite()+"','"
                    +obj.get_dateReservation()+"',"
                    +(obj.is_cancelResevation()? 1 : 0)+","
                    +obj.get_accompteValue()+","
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

    @Override
    public ResultSet selectAll() {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservations");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int Count()
    {
        int nb = 0;

// TODO
        return nb;
    }
}
