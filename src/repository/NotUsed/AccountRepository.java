package repository.NotUsed;

import model.notUsed.Account;

import java.util.List;

public interface AccountRepository {

    Account findByIBAN(String iban);

    Account findById(Long id);

    List<Account> findByIdPerson(Long id);

    List<Account> findAll();

    boolean deleteById(Long id);

    Account update(Account account);

    Account create(Account account);
}
