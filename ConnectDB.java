package EndofTerm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	Connection con ;
	Statement stmt ;
	
	public Connection getConnect() {
		try {
			Class.forName(
			        "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con= DriverManager.getConnection("jdbc:sqlserver://DESKTOP-104PREN\\SQLEXPRESS;databaseName=Account;user=sa;password=quocdung");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}