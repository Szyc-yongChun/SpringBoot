package aa.mine.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(key = "#p0", condition = "#p0.length() < 10")
    User findByName(String name);
    
    @Cacheable
    User getByName(String name);
    
    @SuppressWarnings("unchecked")
	@CachePut
    User save(User user);
    
    //Repository接口中为实现对update的方法解析
//    @CachePut
//    @Query("update user set name =:name set age=:age where id=:id")
//    @Modifying
//    int updateUser(User user);
    
    @CacheEvict
    void delete(User user);
}
