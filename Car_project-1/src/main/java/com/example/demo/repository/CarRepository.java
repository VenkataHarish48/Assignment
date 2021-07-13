package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CarDetails;

@Repository
public class CarRepository {

	@Autowired
	private JdbcTemplate template;

	public int addCars(CarDetails entity) {
		SimpleJdbcInsert inserter = new SimpleJdbcInsert(template);
		inserter.withTableName("Car").usingColumns("model", "current_date", "kilometer", "brand", "status");
		BeanPropertySqlParameterSource sql = new BeanPropertySqlParameterSource(entity);
		return inserter.execute(sql);
	}

	public List<CarDetails> getAllCars() {
		String sql = "select * from Car ";
		List<CarDetails> custList = template.query(sql, BeanPropertyRowMapper.newInstance(CarDetails.class));
		return custList;

	}
	public List<CarDetails> getCarStatus(){
		
		String sql="select * from car where status='Unsold'";
		
		List<CarDetails> carsStatus=
				template.query(sql, BeanPropertyRowMapper.newInstance(CarDetails.class));
		
		return carsStatus;
		
		
	}

	public List<CarDetails> getsCarsByBrand(String brand)
	{

		
	String sql="select * from car where brand=?";	
		List<CarDetails> cars=
				template.query(sql,new Object[]{brand},new BeanPropertyRowMapper<>(CarDetails.class));
		
		return cars;
		
		
	}

	public String[] getBrand()
	{
	String sql="select distinct(brand) from car";
	List<String> list = template.queryForList(sql,String.class);
	String[] brands=list.toArray(new String[list.size()]);

	return brands;

	}

	
}
