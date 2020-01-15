package com.distribuida.liberty.conexion;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;


import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class DataSourceService{

	private static final String DRIVER_CLASS = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/distribuida";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";

    @Produces
    public DataSource data(){
    	BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER_CLASS);
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASS);
		return ds;
     }
}
