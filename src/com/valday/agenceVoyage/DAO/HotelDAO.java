package com.valday.agenceVoyage.DAO;


import com.valday.agenceVoyage.Table.Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDAO extends DAO<Hotel>
{
    public HotelDAO(Connection connect)
    {
        super(connect);
    }

    @Override
    public boolean Add(Hotel obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Hotels (idHotel,nom,telephone,rue,numRue) VALUES ("+obj.get_idHotel()+",'"
                                                                                                                                    +obj.get_nameHotel()+"','"
                                                                                                                                    +obj.get_telephoneHotel()+"','"
                                                                                                                                    +obj.get_rueHotel()+"',"
                                                                                                                                    +obj.get_numRueHotel()+")");
            toReturn = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return toReturn;    }

    @Override
    public boolean Delete(Hotel obj)
    {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Hotels WHERE idHotel = " +obj.get_idHotel());
                toReturn = true;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Edit(Hotel obj) {
        return false;
    }

    @Override
    public Hotel find(int id) {
        Hotel hotel = new Hotel();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Hotels WHERE idHotel = "+ id);

            if (resultSet.first())
            {
                hotel = new Hotel(
                        id,
                        resultSet.getString("nom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("rue"),
                        resultSet.getInt("numRue")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public ResultSet selectAll() {
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Hotels");
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
        ResultSet resultSet = null;
        try
        {
            resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Hotels");

            resultSet.first();
            nb = resultSet.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return nb;
    }
}
