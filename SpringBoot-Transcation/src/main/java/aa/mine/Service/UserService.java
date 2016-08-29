package aa.mine.Service;

import aa.mine.Entity.UserEntity;

public interface UserService {
	/**
	 * 事物的隔离级别      isolation  
	 * 	 MySQL 默认采用   ● REPEATABLE_READ
	 *     ● 该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。
	 *       即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。
	 *       该级别可以防止脏读和不可重复读。
	 *   Oracle 默认采用   ● READ_COMMITTED
	 *     ● 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。
	 *     该级别可以防止脏读，这也是大多数情况下的推荐值。
	 *
	 *事物的传播行为     propagation
	 *    ● REQUIRED 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
	 *    ● SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
	 *    
	 *                               
	 */	
	UserEntity saveUser(UserEntity user) throws Exception;
	
	int saveUserO(UserEntity user) throws Exception;
}
