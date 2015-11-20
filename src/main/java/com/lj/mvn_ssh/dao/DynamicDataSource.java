package com.lj.mvn_ssh.dao;

import java.sql.SQLException;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	// static Logger log = Logger.getLogger("DynamicDataSource");

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO
		return DbContextHolder.getDbType();
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
