package none.training.spring.boot;

import none.training.spring.boot.exception.AccountInvalidException;
import none.training.spring.boot.exception.AccountNotFoundException;
import none.training.spring.boot.exception.InvalidOwnerLastNameException;
import none.training.spring.boot.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceTest {

    protected Account account1;
    protected Account account2;
    private AccountServiceImpl accountService;

    @BeforeEach
    void setup() {
        account1 = new Account();
        account1.setAccountId("1");
        account1.setOwnerFirstName("John");
        account1.setOwnerLastName("Doe");
        account1.setBalance(1000D);
        account1.setActiveFlag(true);

        //Mocking the DAO
        account2 = new Account();
        account2.setAccountId("2");
        account2.setOwnerFirstName("Jane");
        account2.setOwnerLastName("Doe");
        account2.setBalance(2000D);
        account2.setActiveFlag(true);

        AccountRepository repository = mock(AccountRepository.class);

        //Return the same account as the one saved
        when(repository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArguments()[0]);

        //Return the same account as the one saved
        when(repository.saveAndFlush(any(Account.class))).thenAnswer(invocation -> invocation.getArguments()[0]);

        // Find by id: return a new account of id 1 when fetched
        when(repository.findById("1")).thenReturn(Optional.of(account1));

        // Find by id: return a new account of id 2 when fetched
        when(repository.findById("2")).thenReturn(Optional.of(account2));

        // Find by id: return null when account of 7 is fetched
        when(repository.findById("7")).thenReturn(Optional.empty());

        // Find all: return a list of 2 accounts
        when(repository.findAll()).thenReturn(List.of(account1, account2));

        //Find by owner last name should return a list of 2 accounts
        when(repository.findByOwnerLastName("Doe")).thenReturn(List.of(account1, account2));

        //Find by active flag should return a list of 1 account
        when(repository.findByActiveFlagTrue()).thenReturn(List.of(account1, account2));

        //Find by owner last name and active flag should return a list of 1 account
        when(repository.findByActiveFlagTrueAndOwnerLastName("Doe")).thenReturn(List.of(account1, account2));

        //Find by owner first name should return a list of 1 account
        when(repository.findByOwnerFirstNameContaining("John")).thenReturn(Optional.of(List.of(account1)));

        accountService = new AccountServiceImpl(repository);
    }

    @Test
    void saveAccount() {
        Account account1 = new Account();
        account1.setAccountId("3");
        account1.setOwnerFirstName("John");
        account1.setOwnerLastName("Doe");
        account1.setActiveFlag(true);
        account1.setBalance(1000D);
        Account account = accountService.saveAccount(account1);
        assertEquals(
                account,
                account1,
                "Saved account should match account1");
    }

    @Test
    void getAccount() {
        assertEquals(
                account2,
                accountService.getAccount("2"),
                "account2 should be fetched"
        );
    }

    @Test
    void getNonExistingAccountById(){
        assertThrows(
                AccountInvalidException.class,
                () -> accountService.getAccount(null),
                "Should throw a AccountInvalidException"
        );
    }

    @Test
    void getAllTodos() {
        assertEquals(
                2,
                accountService.getAllAccounts(false).size(),
                "There should be a total of 2 accounts"
        );
    }

    @Test
    void getAllActiveAccounts() {
        assertEquals(
                2,
                accountService.getAllAccounts(true).size(),
                "There should be a total of 2 active accounts"
        );
    }

    @Test
    void getAccountsByLastName() {
        List<Account> fetchedAccounts = accountService.getAccountsByLastName("Doe");

        assertEquals(
                2,
                fetchedAccounts.size(),
                "There should be 2 accounts with last name Doe"
        );

        Account firstAccount = fetchedAccounts.get(0);

        assertEquals("John",
                firstAccount.getOwnerFirstName(),
                "The account fetched should have a first name as John");
    }

    @Test
    void getNonExistingLastName() {
        assertThrows(
                InvalidOwnerLastNameException.class,
                () -> accountService.getAccountsByLastName(null),
                "Should throw a Invalid owner last name exception"
        );
    }

    @Test
    void updateAccount() {
        account1.setOwnerFirstName("Test");
        account1.setOwnerLastName("Tested");
        account1.setBalance(20000D);

        Account savedAccount = accountService.updateAccount("1", account1);
        assertEquals(20000D,
                savedAccount.getBalance(),
                "The saved account should have the same balance as account1");
    }

    @Test
    void updateNonExistentTodo() {
        Account account7 = new Account();
        account7.setOwnerFirstName("Non");
        account7.setOwnerLastName("Existent");
        account7.setBalance(0D);
        account7.setActiveFlag(true);

        assertThrows(AccountNotFoundException.class,
                () -> accountService.updateAccount("7", account7),
                "Should throw a account not found exception");
    }

    @Test
    void deleteTodo() {
        Account savedAccount = accountService.deleteAccount("1");

        assertFalse(
                savedAccount.isActiveFlag(),
                "The deletion should set the active flag to false"
        );
    }

    @Test
    void deleteNonExistentAccount() {
        assertThrows(
                AccountNotFoundException.class,
                () -> accountService.deleteAccount("7"),
                "Should throw a AccountNotFoundException"
        );
    }
}
