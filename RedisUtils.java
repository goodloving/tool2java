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
		//1.获取配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		maxIdle = Integer.parseInt(bundle.getString("maxIdle")) ;
		minIdle = Integer.parseInt(bundle.getString("minIdle")) ;
		maxTotal = Integer.parseInt(bundle.getString("maxTotal")) ;
		url = bundle.getString("url");
		port = Integer.parseInt(bundle.getString("port")) ;
		//2.创建池子的配置
		JedisPoolConfig config  = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);		//最大闲置个数
		config.setMinIdle(minIdle);		//最小闲置个数
		config.setMaxTotal(maxTotal);		//最大连接个数
		
		//3.创建连接池对象
		pool = new JedisPool(config,url, port);
	}
	
	//实现jedis方法
	public static Jedis getJedis() {
		return pool.getResource();
	}
}
