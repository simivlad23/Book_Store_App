package repository.NotUsed;

import model.notUsed.Person;

import java.util.List;

public interface PersonRepository {

    Person findByName(String name);

    Person findByCNP(String CNP);

    Person findById(Long id);

    List<Person> findAll();

    boolean deleteById(Long id);

    boolean deleteByCNP(String CNP);

    Person update(Person person);

    Person create(Person person);

}
