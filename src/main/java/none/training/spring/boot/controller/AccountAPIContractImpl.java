package none.training.spring.boot.controller;

import none.training.spring.boot.model.Account;
import none.training.spring.boot.model.response.AccountResponse;
import none.training.spring.boot.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/accounts")
public class AccountAPIContractImpl implements AccountAPIContract{

    private AccountService accountService;
    private AccountResponseHelper accountResponseHelper;

    @Override
    public ResponseEntity<AccountResponse> Account(Account account, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> getAccounts(Boolean includeInactive, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> getAccountsByLastName(String lastName, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> getAccount(String accountId, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> updateAccount(String accountId, Account account, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<AccountResponse> deleteAccount(String accountId, HttpServletRequest request) {
        return null;
    }
}
