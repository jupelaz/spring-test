package none.training.spring.boot.service;

import none.training.spring.boot.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account saveAccount(Account account);

    Account getAccount(String accountId);

    Account updateAccount(String AccountId, Account Account);

    Account deleteAccount(String AccountId);

    List<Account> getAllAccounts(Boolean activeFlag);

    List<Account> getAccountsByLastName(String lastName);

    List<Account> getAccountsByLastName(String lastName,Boolean activeFlag);

    Optional<List<Account>> getAccountsContainsFirstName(String firstName);

}
