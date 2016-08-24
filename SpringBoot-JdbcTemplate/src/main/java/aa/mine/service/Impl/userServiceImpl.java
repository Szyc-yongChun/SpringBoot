package aa.mine.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import aa.mine.service.userService;

//@Service
public class userServiceImpl implements userService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(int id, String name, Integer age) {
		System.out.println("\n\n     userServiceImpl  \n\n");
		jdbcTemplate.update("insert into account(id,name, money) values(?,?, ?)", id, name, age);
	}

	@Override
	public void deleteById(int id) {
		System.out.println("\n\n     userServiceImpl  \n\n");
		jdbcTemplate.update("delete from account where id = ?", id);
	}

	@Override
	public Integer getAllUsers() {
		System.out.println("\n\n     userServiceImpl  \n\n");
		return jdbcTemplate.queryForObject("select count(1) from account", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		System.out.println("\n\n     userServiceImpl  \n\n");
		jdbcTemplate.update("delete from account");
	}

}
