package aa.mine.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import aa.mine.service.userService;

@Service
public class PrimaryUserServiceImpl implements userService {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate PjdbcTemplate;

	@Override
	public void create(int id, String name, Integer age) {
		System.out.println("\n\n     PrimaryUserServiceImpl  \n\n");
		PjdbcTemplate.update("insert into account(id,name, money) values(?,?, ?)", id, name, age);
	}

	@Override
	public void deleteById(int id) {
		System.out.println("\n\n     PrimaryUserServiceImpl  \n\n");
		PjdbcTemplate.update("delete from account where id = ?", id);
	}

	@Override
	public Integer getAllUsers() {
		System.out.println("\n\n     PrimaryUserServiceImpl  \n\n");
		return PjdbcTemplate.queryForObject("select count(1) from account", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		System.out.println("\n\n     PrimaryUserServiceImpl  \n\n");
		PjdbcTemplate.update("delete from account");
	}

}
