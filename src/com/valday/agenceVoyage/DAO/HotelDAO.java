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
    public boolean Add(Hotel obj) {
        return false;
    }

    @Override
    public boolean Delete(Hotel obj) {
        boolean toReturn = false;
        try
        {
            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Hotels WHERE CodeHotel = " +obj.get_idHotel());
                toReturn = true;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean Update(Hotel obj) {
        return false;
    }

    @Override
    public Hotel find(int id) {
        Hotel hotel = new Hotel();

        try
        {
            ResultSet resultSet = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Hotels WHERE CodeHotel = "+ id);

            if (resultSet.first())
            {
                hotel = new Hotel(
                        id,
                        resultSet.getString("Nom")
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
}
