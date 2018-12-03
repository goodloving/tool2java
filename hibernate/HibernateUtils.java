package crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static {
		//1.创建，调用空参构造
		Configuration conf = new Configuration().configure();
		//2.根据配置信息创建sessionFactory
		 sf = conf.buildSessionFactory();
	}
	
	/*
	 * 获得一个新的session
	 */
	public static Session openSession() {
		return sf.openSession();
	}
	
	/*
	 * 获得与线程绑定的session
	 */
	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}
	
}
