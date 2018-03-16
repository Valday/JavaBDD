package com.valday;

import java.sql.*;

public class JdbcConnectionManager
{
    private Connection _connector;
    public JdbcConnectionManager()
    {
            this._connector = null;
    }

    public void Open(String url)
    {
        try
        {
            System.out.println(" => Connection to database ("+url+") in progress ...");
            this._connector = DriverManager.getConnection(url,"tutor","oracletutor");
            if (_connector.isValid(5))
            {
                System.out.println(" => connection established ...");
            }
        }catch (Exception e)
        {
            System.out.println(" => Connection Failled ...");
            e.printStackTrace();
        }
    }

    public void Close()
    {
        try {
            if (!this._connector.isClosed())
            {
                this._connector.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
