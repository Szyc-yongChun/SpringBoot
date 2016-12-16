package aa.mine.springboot.entity;

import java.util.Date;

public class Person {

	private Long personId;
	
	private String personame;
	
	private String email;
	
	private Date personBirthday;
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getPersoname() {
		return personame;
	}
	public void setPersoname(String personame) {
		this.personame = personame;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getPersonBirthday() {
		return personBirthday;
	}
	public void setPersonBirthday(Date personBirthday) {
		this.personBirthday = personBirthday;
	}
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personame=" + personame + ", email=" + email + ", personBirthday=" + personBirthday + "]";
	}
}
