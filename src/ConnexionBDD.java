import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnexionBDD {
	
	final static String URL = "jdbc;oracle:thin:";
	
	public static void main(String[] args)
	{
		
		try 
		{
			Connection conn = DriverManager.getConnection(URL,"system","network");
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(("SELECT * FROM COFFEES"));
			
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
