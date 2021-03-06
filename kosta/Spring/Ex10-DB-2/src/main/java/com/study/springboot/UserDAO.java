package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO implements IUserDAO{
	@Autowired//의존성 
    private JdbcTemplate jdbcTemplate;
 
	public List<UserDTO> list() {
        String query = "select * from user";
        List<UserDTO> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
 
        return list;  
	}
}
