package wzj.util.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver" ;
	private static final String URl="jdbc:oracle:thin:@localhost:1521:jayw" ;
	private static final String USER="scott" ;
	private static final String PASSWORD="tiger" ;
	private static ThreadLocal<Connection> threadlocal=new ThreadLocal<>() ;
	public static Connection rebulid(){
		try {
			Class.forName(DRIVER) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(URl, USER, PASSWORD) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	public static Connection getConnection() {
		Connection conn=threadlocal.get() ;
		if(conn==null) {
			conn=rebulid() ;
			threadlocal.set(conn);
		}
		return conn ;
	}
	public static void close() {
		Connection conn=threadlocal.get() ;
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadlocal.remove();
		}
	}
}
