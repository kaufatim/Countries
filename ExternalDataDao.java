package com.springboot.springbootcallingexternalapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.springboot.springbootcallingexternalapi.model.CallingExternalModel;

public interface ExternalDataDao {

	public void setDataSource(DataSource ds);
	
	public List<CallingExternalModel> listData();
	
	public int addData(int id);
	
	
}
