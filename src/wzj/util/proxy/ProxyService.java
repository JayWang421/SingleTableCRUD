package wzj.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import wzj.util.dbc.DatabaseConnection;

public class ProxyService implements InvocationHandler{
	private Object obj ;
	public Object bind(Object obj) {
		this.obj=obj ;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this) ;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret=null ;
		String methodName=method.getName() ;
		boolean flag=methodName.startsWith("add") || methodName.startsWith("edit") || methodName.startsWith("delete") ;
		try{
			if(flag){
				DatabaseConnection.getConnection().setAutoCommit(false);
			}
			ret=method.invoke(this.obj, args) ;
			if(flag){
				DatabaseConnection.getConnection().commit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			if(flag){
				DatabaseConnection.getConnection().rollback();
			}
			throw e;
		}finally {
			DatabaseConnection.close();
		}
		return ret ;
	}
}
