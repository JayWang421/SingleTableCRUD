package wzj.dao;

import java.sql.SQLException;

import wzj.uti.dao.IBaseDAO;
import wzj.vo.Emp;

public interface IEmpDAO extends IBaseDAO<Integer, Emp> {
	public boolean doRemoveByDeptno(Integer deptno)throws SQLException ; 
}
