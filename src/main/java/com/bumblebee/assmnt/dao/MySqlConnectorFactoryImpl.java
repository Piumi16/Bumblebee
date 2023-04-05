package com.bumblebee.assmnt.dao;



public class MySqlConnectorFactoryImpl implements DbConnectorFactory{
	
	public DbConnector getDbConnector() {
		
		return new MySqlConnectorImpl();
	}
	
}
