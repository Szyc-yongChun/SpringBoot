package aa.mine.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import aa.mine.service.userService;

@Service
public class SecondaryUserServiceImpl implements userService {

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate SjdbcTemplate;

	@Override
	public void create(int id, String name, Integer age) {
		System.out.println("\n\n     SecondaryUserServiceImpl  \n\n");
		SjdbcTemplate.update("insert into account(id,name, money) values(?,?, ?)", id, name, age);
	}

	@Override
	public void deleteById(int id) {
		System.out.println("\n\n     SecondaryUserServiceImpl  \n\n");
		SjdbcTemplate.update("delete from account where id = ?", id);
	}

	@Override
	public Integer getAllUsers() {
		System.out.println("\n\n     SecondaryUserServiceImpl  \n\n");
		return SjdbcTemplate.queryForObject("select count(1) from account", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		System.out.println("\n\n     SecondaryUserServiceImpl  \n\n");
		SjdbcTemplate.update("delete from account");
	}

}
