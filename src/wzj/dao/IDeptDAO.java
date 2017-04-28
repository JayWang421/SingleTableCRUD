package wzj.dao;

import java.sql.SQLException;
import java.util.Map;

import wzj.uti.dao.IBaseDAO;
import wzj.vo.Dept;

public interface IDeptDAO extends IBaseDAO<Integer, Dept> {
	public Map<Integer,Map<String ,Object>> findAllStat()throws SQLException ;
}
