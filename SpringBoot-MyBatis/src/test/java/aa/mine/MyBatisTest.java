package aa.mine;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import aa.mine.dao.TuserMapper;
import aa.mine.dao.UserRoleMapper;
import aa.mine.model.Tuser;
import aa.mine.model.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MyBatisTest {
	
	private final static Logger logger = Logger.getLogger(MyBatisTest.class);
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private TuserMapper tusermapper;

	@Test
	public void test1() throws Exception {
		UserRole ur = new UserRole();
		ur.setId(((int)Math.random()*1000));
		ur.setRoleId(1);
		ur.setUesrId(1);
		userRoleMapper.insert(ur);
		logger.info(JSON.toJSONString(ur));
		
		List<UserRole> lur = new ArrayList<UserRole>();
		lur = userRoleMapper.findall();
		logger.info(lur.size());
		logger.info(JSON.toJSONString(lur));
		
		ur = userRoleMapper.selectByPrimaryKey(1);
		logger.info(JSON.toJSONString(ur));
		
		Tuser tu = tusermapper.selectByPrimaryKey(1);
		logger.info(JSON.toJSONString(tu));
		
		List<Tuser> ltu = tusermapper.findall();
		logger.info(JSON.toJSONString(ltu));
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInster() throws Exception {
		Date date = new Date();
		Tuser tu = new Tuser();
		tu.setId(((int)Math.random()*1000));
		tu.setName(date.getTime()+"E");
		tu.setNick(date.getTime()+"K");
		tu.setPassword(date.toGMTString());
		tu.setCreatedate(date);
		tu.setUpdatedate(date);
		
		//测试通过@Param绑定参数插入数据
		tusermapper.insertByParam(((int)Math.random()*1000), date.getTime()+"E", 
				date.getTime()+"K", date.toGMTString(), date, date);
		
		//通过对象参数插入数据
		tusermapper.insertByObject(tu);
		
		//通过Map集合插入数据
		Map<String, Object> map = new HashMap<>();
		map.put("id", ((int)Math.random()*1000));
		map.put("name", date.getTime()+"E");
		map.put("nick", date.getTime()+"K");
		map.put("password",  date.toLocaleString());
		map.put("createDate", date);
		map.put("updateDate", date);
		tusermapper.insertByMap(map);		
	}
	
	@Test
	public void testFind() throws Exception {
		
		List<Tuser> ltus = tusermapper.findall();
		logger.info(JSON.toJSONString(ltus));
		
		Tuser tu = tusermapper.selectByPrimaryKey(1);
		logger.info(JSON.toJSONString(tu));
	}
}
