package com.lj.mvn_ssh.dao;

public class DbContextHolder {
	private static final ThreadLocal contextHolder = new ThreadLocal();
	public static final String DATA_SOURCE_DEFAULT = "default";
	public static final String DATA_SOURCE_1 = "1";  
    
    
	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDbType() {
	return (String) contextHolder.get();
	}

	public static void clearDbType() {
	contextHolder.remove();
	}

}
