package com.valday.GestionAgenceVoyage.Managers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RequetesManager
{
    private RequetesManager()
    {

    }

    public static ResultSet testRequete()
    {
        ResultSet rs = null;
        try
        {
            Statement st = JdbcConnectionManager.Instance().get_connector().createStatement();
            rs = st.executeQuery("SELECT * FROM CLIENTS");
            while(rs.next()){
                System.out.println(rs.getString(1)+","+rs.getString(2));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return  rs;
    }

    public static void ListAllTable()
    {
       /* try {

            String[] types = {"TABLE"};
            ResultSet resultSet = JdbcConnectionManager.get_connector().getMetaData().getTables("XE",null,"%",types);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("TABLE_NAME"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */

        ArrayList<String> listofTable = new ArrayList<String>();
        try
        {
            ResultSet rs = JdbcConnectionManager.Instance().get_connector().getMetaData().getTables(null, null, "%", null);
            while (rs.next())
            {
                if (rs.getString(4).equalsIgnoreCase("TABLE")) {
                    listofTable.add(rs.getString(3));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
