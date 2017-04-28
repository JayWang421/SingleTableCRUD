package wzj.util.factory;

import wzj.util.message.MessageUtils;
import wzj.util.proxy.ProxyService;
@SuppressWarnings("unchecked")
public class Factory {
	private static final String DAO="wzj.util.config.dao" ;
	private static final String SERVICE="wzj.util.config.service" ;
	private static MessageUtils daoMU ;
	private static MessageUtils serviceMU ;
	static {
		daoMU=new MessageUtils(DAO) ;
		serviceMU=new MessageUtils(SERVICE) ;
	}
	public static <T>T getDAOInstance(String className){
		try {
			return (T) Class.forName(daoMU.getValues(className)).newInstance() ;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	public static <T>T getServiceInstance(String className){
		try {
			return (T) new ProxyService().bind(Class.forName(serviceMU.getValues(className)).newInstance()) ;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
}
