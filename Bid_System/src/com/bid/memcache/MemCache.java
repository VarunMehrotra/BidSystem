package com.bid.memcache;

import net.spy.memcached.MemcachedClient;
import java.net.InetAddress; 
import java.net.InetSocketAddress; 
import java.io.*; 

public class MemCache {

	static MemcachedClient cache = null;

	public static void MemCacheFunction(){
		try {
			cache = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void put(String u,String p) {
		MemCacheFunction();
		cache.set(u,1000,p);
	}
	public static String get(String u) {
		MemCacheFunction();
		Object ob = cache.get(u);

		if(ob == null)
			return "";
		return String.valueOf(ob);
	}

}
