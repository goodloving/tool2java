package RedisConnection;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
	private static JedisPool pool = null;
	private static int maxIdle;
	private static int minIdle;
	private static int maxTotal;
	private static String url;
	private static int port;
	
	
	static {
		//1.��ȡ�����ļ�
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		maxIdle = Integer.parseInt(bundle.getString("maxIdle")) ;
		minIdle = Integer.parseInt(bundle.getString("minIdle")) ;
		maxTotal = Integer.parseInt(bundle.getString("maxTotal")) ;
		url = bundle.getString("url");
		port = Integer.parseInt(bundle.getString("port")) ;
		//2.�������ӵ�����
		JedisPoolConfig config  = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);		//������ø���
		config.setMinIdle(minIdle);		//��С���ø���
		config.setMaxTotal(maxTotal);		//������Ӹ���
		
		//3.�������ӳض���
		pool = new JedisPool(config,url, port);
	}
	
	//ʵ��jedis����
	public static Jedis getJedis() {
		return pool.getResource();
	}
}
