package aa.mine.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import aa.mine.model.UserRole;

@Mapper
public interface UserRoleMapper {
	
	/**
	 * 利用相应的注解注入SQL语句，不需要在配置文件中添加相应的查询实现
	 */
    int deleteByPrimaryKey(Integer id);
    
    //通过对象参数插入数据
    //数据类可选
    @Insert("insert into user_role (id, uesr_id, role_id) "
    		+ "values (#{id,jdbcType=INTEGER}, #{uesrId,jdbcType=INTEGER}, "
    		+ "#{roleId,jdbcType=INTEGER})")
    int insert(UserRole record);
    
    int insertSelective(UserRole record);

    @Select("select * from user_role where id = #{id,jdbcType=INTEGER}")
    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    @Select("select * from user_role")
    List<UserRole> findall();
}