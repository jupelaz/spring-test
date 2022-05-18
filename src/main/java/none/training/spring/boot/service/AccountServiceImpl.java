package none.training.spring.boot.service;

import none.training.spring.boot.Account;
import none.training.spring.boot.AccountConstants;
import none.training.spring.boot.AccountRepository;
import none.training.spring.boot.exception.AccountInvalidException;
import none.training.spring.boot.exception.AccountNotFoundException;
import none.training.spring.boot.exception.InvalidOwnerLastNameException;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(final AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account getAccount(String accountId) {
        return repository
                .findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                AccountConstants.INVALID_ACCOUNT,
                                accountId));
    }



    @Override
    public Account updateAccount(String accountId, Account account) {
        validateAccount(account);
        validateIdExists(accountId);
        account.setAccountId(accountId);
        return repository.saveAndFlush(account);

    }

    @Override
    public Account deleteAccount(String accountId) {
        validateIdExists(accountId);
        Account account = repository.findById(accountId).orElse(null);
        if(account == null) return null;
        account.setActiveFlag(false);
        return repository.save(account);
    }

    @Override
    public List<Account> getAllAccounts(Boolean activeFlag) {
        boolean flag = BooleanUtils.toBooleanDefaultIfNull(activeFlag,false);
        return flag?repository.findByActiveFlagTrue():repository.findAll();
    }

    @Override
    public List<Account> getAccountsByLastName(String lastName) {
        List<Account> list = repository.findByOwnerLastName(lastName);
        if (list.isEmpty()) throw new InvalidOwnerLastNameException(AccountConstants.INVALID_LAST_NAME,lastName);
        return list;
    }

    @Override
    public List<Account> getAccountsByLastName(String lastName, Boolean activeFlag) {
        boolean flag = BooleanUtils.toBooleanDefaultIfNull(activeFlag,false);
        return flag?
                repository.findByActiveFlagTrueAndOwnerLastName(lastName):
                repository.findByOwnerLastName(lastName);
    }

    @Override
    public Optional<List<Account>> getAccountsContainsFirstName(String firstName) {
        return repository.findByOwnerFirstNameContaining(firstName);
    }

    private void validateAccount(final Account account){
        if (account == null){
            throw new AccountInvalidException(AccountConstants.INVALID_ACCOUNT);
        }
    }
    private void validateIdExists(final String id) {
        repository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                AccountConstants.ACCOUNT_NOT_FOUND,
                                id));
    }
}
