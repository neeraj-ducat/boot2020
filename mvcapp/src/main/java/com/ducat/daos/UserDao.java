package com.ducat.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.entities.User;

@Repository
public class UserDao {

	//dependency of the DAO
	
	@Autowired
	private JdbcTemplate template;
	
	//Query to save user objects.
	private static final String SAVE_QUERY="insert into UsersMaster (name, mailId, password) values(?,?,?)";
	//Query to fetch a user using mailId
	private static final String FIND_QUERY = "select * from UsersMaster where mailId=?";
	
	//Method to save a user
	public void save(User user) {
		template.update(SAVE_QUERY, user.getName(), user.getMailId(), user.getPassword());
	}
	
	public List<User> findByMailId(String mailId) throws Exception
	{
		return template.query(FIND_QUERY, new String[] {mailId}, rm);
	}
	
	private RowMapper<User> rm =new RowMapper<User>() {
			
		public User mapRow(ResultSet rset, int index) throws SQLException {
			User user=new User();
			user.setId(rset.getInt(1));
			user.setName(rset.getString(2));
			user.setMailId(rset.getString(3));
			user.setPassword(rset.getString(4));
			return user;
		}
	};
	
}
