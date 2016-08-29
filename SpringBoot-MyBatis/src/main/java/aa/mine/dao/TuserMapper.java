package aa.mine.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import aa.mine.model.Tuser;

@Mapper
public interface TuserMapper {
	

	/**
	 * 利用相应的注解注入SQL语句，不需要在配置文件中添加相应的查询实现
	 */
	
	//通过对象参数插入数据
	//类型可选
    @Insert(" insert into t_user (id, name, nick, password, createDate, updateDate) "
    		+ "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{nick,jdbcType=VARCHAR}, "
    		+ "#{password,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP}, "
    		+ "#{updatedate,jdbcType=TIMESTAMP})")
    int insertByObject(Tuser record);
    
    //通过Map参数集合插入数据
    @Insert(" insert into t_user (id, name, nick, password, createDate, updateDate) "
    		+ "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{nick,jdbcType=VARCHAR}, "
    		+ "#{password,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, "
    		+ "#{updateDate,jdbcType=TIMESTAMP})")
    int insertByMap(Map<String, Object> map);

    //通过@Param绑定参数插入数据
    @Insert(" insert into t_user (id, name, nick, password, createDate, updateDate) "
    		+ "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{nick,jdbcType=VARCHAR}, "
    		+ "#{password,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, "
    		+ "#{updateDate,jdbcType=TIMESTAMP})")
    int insertByParam(@Param("id") Integer id, @Param("name") String name, @Param("nick") String nick
    		  , @Param("password") String password, @Param("createDate") Date createDate,
    		    @Param("updateDate") Date updateDate);
	
    //条件查询
    @Select("select * from t_user where id = #{id,jdbcType=INTEGER}")
    Tuser selectByPrimaryKey(Integer id);
    
    //查询全部
    @Select("select * from t_user")
    List<Tuser> findall();
    
    
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Tuser record);
       
    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
    
    
}