package aa.mine.service;

public interface userService {

	/**
	 * 新增一个用户
	 * 
	 * @param name
	 * @param age
	 */
	void create(int id, String name, Integer age);

	/**
	 * 根据name删除一个用户高
	 * 
	 * @param name
	 */
	void deleteById(int id);

	/**
	 * 获取用户总量
	 */
	Integer getAllUsers();

	/**
	 * 删除所有用户
	 */
	void deleteAllUsers();
}
