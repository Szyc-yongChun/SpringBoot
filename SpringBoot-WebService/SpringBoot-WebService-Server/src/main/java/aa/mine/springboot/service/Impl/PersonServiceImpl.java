package aa.mine.springboot.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import aa.mine.springboot.entity.Person;
import aa.mine.springboot.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private static Person Person;
	
	static{
		Person = new Person();
		Person.setEmail("email");
		Person.setPersoname("personame");
		Person.setPersonBirthday(new Date());
		Person.setPersonId(1L);
	}

	@Override
	public Person findPersonById(String personId) {
		Person p = null;
		try {
			if(1L == Long.parseLong(personId)){
				p = Person;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Person savePerson(Person person) {
		Person = person;
		return Person;
	}

	@Override
	public List<Person> findAll() {
		List<Person> listPerson = new ArrayList<Person>();
		listPerson.add(Person);
		return listPerson;
	}

	@Override
	public Person updatePerson(Person person) {
		Person = person;
		return Person;
	}

}
