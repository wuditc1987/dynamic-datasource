package com.dynamic.datasource;

public class DataSourceHolder {

	private static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	private static final String DATAOURCE_MASTER = "master";
	
	private static final String DATAOURCE_SLAVE = "slave";

	public static void setDataSource(String dataSource) {
		holder.set(dataSource);
	}

	public static void setMaster() {
		clearDataSource();
	}

	public static void setSlave() {
		setDataSource(DATAOURCE_SLAVE);
	}

	public static String getDataSource() {
		return holder.get();
	}

	public static void clearDataSource() {
		holder.remove();
	}
}
