package crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static {
		//1.���������ÿղι���
		Configuration conf = new Configuration().configure();
		//2.����������Ϣ����sessionFactory
		 sf = conf.buildSessionFactory();
	}
	
	/*
	 * ���һ���µ�session
	 */
	public static Session openSession() {
		return sf.openSession();
	}
	
	/*
	 * ������̰߳󶨵�session
	 */
	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}
	
}
