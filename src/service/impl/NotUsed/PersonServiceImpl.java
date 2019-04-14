package service.impl.NotUsed;

import model.notUsed.Account;
import model.notUsed.Person;
import repository.NotUsed.AccountRepository;
import repository.NotUsed.PersonRepository;
import service.NotUsed.PersonSercive;

import java.util.List;

public class PersonServiceImpl implements PersonSercive {

    private PersonRepository personRepository;


    private AccountRepository accountRepository;

    public PersonServiceImpl(PersonRepository personRepository, AccountRepository accountRepository) {
        this.personRepository = personRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public Person save(Person person) {

        /*if(person.getName()!=null) {
            person = personRepository.findByCNP(person.getCNP());
        }*/
        if (personRepository.findByCNP(person.getCNP())!=null) {
            System.out.println(person.getCNP() + " " + person.getName() + " " + person.getAddres());

            return personRepository.update(person);
        } else

        return personRepository.create(person);

    }

    @Override
    public void delete(String id) {

        personRepository.deleteByCNP(id);

    }

    @Override
    public List<Account> getAccountList(Person p) {

        List<Account> list;

        return accountRepository.findByIdPerson(p.getId());

    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

}
