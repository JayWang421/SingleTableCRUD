package wzj.test.junit;

import org.junit.Test;

import junit.framework.TestCase;
import wzj.service.IDeptService;
import wzj.util.factory.Factory;
import wzj.vo.Dept;

public class IDeptServiceTest {

	@Test
	public void testAdd() throws Exception{
		IDeptService deptService=Factory.getServiceInstance("dept.service") ;
		Dept vo=new Dept() ;
		vo.setDeptno(12);
		vo.setDname("zhao");
		vo.setLoc("beijing");
		TestCase.assertTrue(deptService.add(vo));
	}

}
