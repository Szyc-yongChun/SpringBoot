package aa.mine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import aa.mine.Entity.UserEntity;

/**
 * 1. Repository 是一个空接口. 即是一个标记接口
 * 2. 若我们定义的接口继承了 Repository, 则该接口会被 IOC 容器识别为一个 Repository Bean.
 *    纳入到 IOC 容器中. 进而可以在该接口中定义满足一定规范的方法. 
 * 3. 实际上, 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
 */

/**
 * 在 Repository 子接口中声明方法
 * 1. 不是随便声明的. 而需要符合一定的规范
 * 2. 查询方法以 find | read | get 开头
 * 3. 涉及条件查询时，条件的属性用条件关键字连接
 * 4. 要注意的是：条件属性以首字母大写。
 * 5. 支持属性的级联查询. 若当前类有符合条件的属性, 则优先使用, 而不使用级联属性. 
 *    若需要使用级联属性, 则属性之间使用 _进行连接. 
 */


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	/**
	 * 继承CrudRepository 或者 PagingAndSortingRepository，JpaRepository会抽出一些常用的方法，
	 * 如果你spring data jpa帮你自定义那么多方法，你可以继承于JpaRepository，
	 * 然后复制一些方法到你的接口中，可以选择性的要一些方法
	 * 
	 * spring-data 通过解析方法名创建查询
	 * 
	 * 按照规范创建查询方法，一般按照java驼峰式书写规范加一些特定关键字
	 * 
	 * 利用属性获取任务列表
	 * 利用and 和 or来获取任务列表
	 * 利用Pageable ，Sort，Slice获取分页的任务列表和排序
	 * 利用Distinct去重
	 * 利用OrderBy进行排序
	 * 利用 Top 和 First来获取限制数据
	 * 
	 * Spring Data JPA框架在进行方法名解析时，会先把方法名多余的前缀截取掉，
	 * 比如 find、findBy、read、readBy、get、getBy，然后对剩下部分进行解析。
	 */

	UserEntity findByName(String name);

	UserEntity findByNameAndAge(String name, Integer age);

	@Query("from UserEntity u where u.name=:name")
	UserEntity findUser(String name);

}
