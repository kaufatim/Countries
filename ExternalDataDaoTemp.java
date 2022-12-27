package com.springboot.springbootcallingexternalapi.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springboot.springbootcallingexternalapi.model.CallingExternalModel;

public class ExternalDataDaoTemp implements ExternalDataDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	
/*	public List<CallingExternalModel> listData() {
		String sqlQuery = "Select * from countries";
		List<CallingExternalModel> callingExternalModel = jdbcTemplateObject.query(sqlQuery, new CountryMapper());
		return callingExternalModel;
	}*/


	
	public int addData(int id) {
		
		return jdbcTemplateObject.update("insert into countries values(?,?,?,?,?,?,?,?,?)");
	}


	@Override
	public List<CallingExternalModel> listData() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
