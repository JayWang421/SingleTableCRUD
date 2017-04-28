package wzj.dao.abs;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import wzj.util.dbc.DatabaseConnection;


public abstract class AbstractDAOImpl {
	protected PreparedStatement ps=null; 
	public boolean handleDeleteForInt(String tableName,String pkColumnName,Set<Integer> ids)throws SQLException {
		StringBuffer buf=new StringBuffer() ;
		buf.append("delete from ").append(tableName).append(" where ").append(pkColumnName).append(" in (") ;
		Iterator<Integer> iter=ids.iterator() ;
		while(iter.hasNext()){
			buf.append(iter.next()).append(",") ;
		}
		buf.delete(buf.length()-1, buf.length()).append(")") ;
		PreparedStatement ps=DatabaseConnection.getConnection().prepareStatement(buf.toString()) ;
		return ps.executeUpdate() > 0 ;
	}
	

}
