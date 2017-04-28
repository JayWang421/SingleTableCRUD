package wzj.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import wzj.dao.IDeptDAO;
import wzj.dao.IEmpDAO;
import wzj.service.IDeptService;
import wzj.util.factory.Factory;
import wzj.vo.Dept;
import wzj.vo.Emp;



public class DeptServiceImpl implements IDeptService {

	@Override
	public boolean add(Dept vo) throws Exception {
		IDeptDAO deptDao=Factory.getDAOInstance("dept.dao") ;
		if(vo==null){
			return false ;
		}
		if(deptDao.findById(vo.getDeptno())==null) {
			return deptDao.doCreate(vo) ;
		}
		return false ;
	}
	@Override
	public boolean edit(Dept vo) throws Exception {
		IDeptDAO deptDao=Factory.getDAOInstance("dept.dao") ;
		return deptDao.doUpdate(vo) ;
	}
	@Override
	public Dept getEditPre(int rid) throws Exception {
		IDeptDAO deptDao=Factory.getDAOInstance("dept.dao") ;
		return deptDao.findById(rid) ;
	}
	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		if(ids==null | ids.size()==0){
			return false ;
		}
		IEmpDAO empDao=Factory.getDAOInstance("emp.dao") ;
		Iterator<Integer> iter=ids.iterator() ;	
		while(iter.hasNext()) {
			empDao.doRemoveByDeptno(iter.next()) ;
		}
		IDeptDAO deptDao=Factory.getDAOInstance("dept.dao") ;
		return deptDao.doRemoveBatch(ids) ;
	}
	@Override
	public List<Dept> list() throws Exception {
		IDeptDAO deptDao=Factory.getDAOInstance("dept.dao") ;
		return deptDao.findAll() ;
	}
	@Override
	public Map<String, Object> listDetails() throws Exception {
		IDeptDAO deptDao=Factory.getDAOInstance("dept.dao") ;
		Map<String ,Object> map=new HashMap<String ,Object> () ;
		map.put("alldepts",deptDao.findAll()) ;
		map.put("deptstats", deptDao.findAllStat()) ;
		return map ;
	}
}
