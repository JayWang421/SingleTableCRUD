package wzj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import wzj.dao.IDeptDAO;
import wzj.dao.abs.AbstractDAOImpl;
import wzj.util.dbc.DatabaseConnection;
import wzj.vo.Dept;

public class DeptDAOImpl extends AbstractDAOImpl implements IDeptDAO {
	private PreparedStatement ps ;
	private Connection conn ;
	public DeptDAOImpl() {
		// TODO Auto-generated constructor stub
		this.conn=DatabaseConnection.getConnection() ;
	}
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql="insert into dept (deptno,dname,loc) values (?,?,?) " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, vo.getDeptno());
		this.ps.setString(2, vo.getDname()); ;
		this.ps.setString(3,vo.getLoc());
		return this.ps.executeUpdate()>0 ;
	}

	@Override
	public boolean doUpdate(Dept vo) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno= ? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, vo.getDname());
		this.ps.setString(2, vo.getLoc());
		this.ps.setInt(3, vo.getDeptno());
		return this.ps.executeUpdate() > 0 ;
	}

	@Override
	public boolean doRemove(Integer rid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		return super.handleDeleteForInt("dept", "deptno", ids) ;
	}
	@Override
	public Dept findById(Integer rid) throws SQLException {
		Dept vo = null;
		String sql="select deptno,dname,loc from dept where deptno=? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, rid);
		ResultSet rs=this.ps.executeQuery() ;
		if(rs.next()){
			vo=new Dept() ;
			vo.setDeptno(rs.getInt(1)); ;
			vo.setDname(rs.getString(2)); 
			vo.setLoc(rs.getString(3));
		}
		return vo ;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all=new ArrayList<Dept> ();
		Dept vo = null;
		String sql=" select deptno,dname,loc from dept " ;
		this.ps=this.conn.prepareStatement(sql) ;
		ResultSet rs=this.ps.executeQuery() ;
		while(rs.next()){
			vo=new Dept() ;
			vo.setDeptno(rs.getInt(1)); ;
			vo.setDname(rs.getString(2)); 
			vo.setLoc(rs.getString(3));
			all.add(vo) ;
		}
		return all ;
	}

	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String column, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<Integer, Map<String, Object>> findAllStat() throws SQLException {
		Map<Integer,Map<String ,Object>> allStat=new HashMap<Integer,Map<String,Object>>() ;
		String sql=" select deptno dno,count(*) count,avg(sal) avg,max(sal) max,min(sal) min, trunc(avg(months_between(SYSDATE,hiredate)/12),2) avgyear "
				+ " from emp "
				+ " group by deptno " ;
		
		this.ps=this.conn.prepareStatement(sql) ;
		ResultSet rs=this.ps.executeQuery() ;
		while(rs.next()){
			Map<String ,Object> deptStat=new HashMap<String ,Object> () ;
			deptStat.put("count", rs.getInt(2)) ;
			deptStat.put("avg", rs.getDouble(3)) ;
			deptStat.put("max", rs.getDouble(4)) ;
			deptStat.put("min", rs.getDouble(5)) ;
			deptStat.put("avgyear", rs.getDouble(6)) ;
			allStat.put(rs.getInt(1), deptStat) ;
		}
		return allStat ;
	}
}
