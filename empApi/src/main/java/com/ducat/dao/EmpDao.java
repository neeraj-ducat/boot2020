package com.ducat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate template;
	
	private static final String SAVE_QUERY="insert into Emp (name,job,salary) values(?,?,?)";
	private static final String UPDATE_QUERY="update Emp set name=?, job=?, salary=? where id=?";
	private static final String DELETE_QUERY="delete from Emp where id=?";
	private static final String FETCH_ALL_QUERY="select * from Emp";
	private static final String FETCH_BY_ID_QUERY="select * from Emp where id=?";
	

	
	public void save(Emp emp)
	{
		template.update(SAVE_QUERY, emp.getName(), emp.getJob(), emp.getSalary());
	}
	
	public void update(Emp emp)
	{
		template.update(UPDATE_QUERY, emp.getName(), emp.getJob(), emp.getSalary(), emp.getId());
	}
	
	public void remove(int id)
	{
		template.update(DELETE_QUERY, id);
	}
	
	private RowMapper<Emp> rowMapper = new RowMapper<Emp>() {

		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp e= new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setJob(rs.getString(3));
			e.setSalary(rs.getInt(4));
			return e;
		}
		
		
	};
	
	public List<Emp> allEmp() throws Exception
	{
		return template.query(FETCH_ALL_QUERY,rowMapper);
	}
	
	public Emp empById(int id) throws Exception
	{
		return template.queryForObject(FETCH_BY_ID_QUERY, new Object[] {id}, rowMapper);
	}
}
