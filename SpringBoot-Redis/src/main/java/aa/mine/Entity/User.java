package aa.mine.Entity;

import java.io.Serializable;

/**
 * 实现序列化接口，让类可以序列化
 * Serializable空接口，实现后可让类参与序列化和反序列化
 * @author Administrator
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
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

    @Override
   	public String toString() {
   		return "User [username=" + username + ", age=" + age + "]";
   	}

}
