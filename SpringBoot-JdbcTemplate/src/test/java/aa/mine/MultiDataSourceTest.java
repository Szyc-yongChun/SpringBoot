package aa.mine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aa.mine.service.userService;
import aa.mine.service.Impl.userServiceImpl;

/**
 * 没有使用
 * @author Administrator
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MultiDataSourceTest {
	/**
	 * 当你创建多个具有相同类型的 bean 时，并且想要用一个属性只为它们其中的一个进行装配，在这种情况下，
	 * 你可以使用 @Qualifier 注释和 @Autowired 注释通过指定哪一个真正的 bean 将会被装配来消除混乱。
	 * 
	 * @Qualifier 按类型自动装配可能多个Bean的实例情况，使用@Qualifier注解可以缩小范围或者指定唯一的Bean。---主要用于集合类型变量
	 * @Autowired 可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作。
	 * 
	 * @Autowired 和 @Qualifier 结合使用时，自动注入的策略就从 byType 转变成 byName
	 * 
	 * @Autowired可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
	 *  通过 @Autowired的使用来消除 setter ，getter方法
	 *  
	 *  userService us = new userServiceImpl();
	 */
	
	
	@Autowired
	//通过 @Qualifier 注释指定注入 Bean 的名称
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp() {
		jdbcTemplate1.update("DELETE  FROM  USER ");
		jdbcTemplate2.update("DELETE  FROM  USER ");
	}

	@Test
	public void test() throws Exception {

		// 往第一个数据源中插入两条数据
		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);

		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
		jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));

	}


}
