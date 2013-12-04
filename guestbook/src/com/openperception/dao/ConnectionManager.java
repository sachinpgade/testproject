// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 25-06-2013 PM 05:12:11
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ConnectionManager.java

package com.openperception.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	public ConnectionManager() {
	}

	public Connection getConnection() throws SQLException {
		if (ds != null)
			return ds.getConnection();
		try {
//			Properties props = new Properties();
//			props.put("INITIAL_CONTEXT_FACTORY",
//					"com.sun.enterprise.naming.SerialInitContextFactory");
//			props.put("PROVIDER_URL", "iiop://127.0.0.1:3700");
//				InitialContext ctx = new InitialContext(props);
//				ds = (DataSource) ctx.lookup("MySqlGBDS");
	        Context ctx = new InitialContext();
			    ds = (javax.sql.DataSource) ctx.lookup("java:jboss/datasources/MySqlGBDS");
			return ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static synchronized ConnectionManager getInstance() {
		if (instance == null)
			instance = new ConnectionManager();
		return instance;
	}

	private static ConnectionManager instance = null;
	private static final String JNDI_DATA_SOURCE = "java:/MySqlGBDS";
	private DataSource ds;

}