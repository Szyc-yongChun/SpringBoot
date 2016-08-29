package aa.mine.dao;

import org.apache.ibatis.annotations.Mapper;
import aa.mine.model.Trole;

@Mapper
public interface TroleMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Trole record);

    int insertSelective(Trole record);

    Trole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trole record);

    int updateByPrimaryKey(Trole record);
}