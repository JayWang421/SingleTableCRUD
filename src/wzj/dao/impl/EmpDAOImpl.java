package wzj.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import wzj.dao.IEmpDAO;
import wzj.dao.abs.AbstractDAOImpl;
import wzj.util.dbc.DatabaseConnection;
import wzj.vo.Emp;

public class EmpDAOImpl extends AbstractDAOImpl implements IEmpDAO {

	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer rid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp findById(Integer rid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyword)
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
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveByDeptno(Integer deptno) throws SQLException {
		String sql="delete from emp where deptno=? " ;
		super.ps=DatabaseConnection.getConnection().prepareStatement(sql) ;
		super.ps.setInt(1, deptno);
		return super.ps.executeUpdate() > 0 ;
	}

}
