package service.NotUsed;

import model.notUsed.Account;
import model.notUsed.Person;
import repository.NotUsed.PersonRepository;

import java.util.List;

public interface PersonSercive {

    Person save(Person person);

    void delete(String id);

    List<Account> getAccountList(Person p);

    public PersonRepository getPersonRepository();



}
