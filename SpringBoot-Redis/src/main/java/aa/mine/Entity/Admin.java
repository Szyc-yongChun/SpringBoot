package aa.mine.Entity;

import java.io.Serializable;

/**
 * 实现序列化接口，让类可以序列化 Serializable空接口，实现后可让类参与序列化和反序列化
 * 
 * @author Administrator
 *
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = -1L;

	private String username;
	private Integer age;
	private Integer total;
	private String firstname;

	public Admin(String username, Integer age, Integer total, String firstname) {
		super();
		this.username = username;
		this.age = age;
		this.total = total;
		this.firstname = firstname;
	}

	public Admin(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", age=" + age + ", total=" + total + ", firstname=" + firstname + "]";
	}
}
