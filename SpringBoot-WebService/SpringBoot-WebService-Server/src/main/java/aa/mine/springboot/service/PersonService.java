package aa.mine.springboot.service;

import java.util.List;

import aa.mine.springboot.entity.Person;

public interface PersonService {

	Person findPersonById(String personId);

	Person savePerson(Person person);

	List<Person> findAll();

	Person updatePerson(Person person);
}
