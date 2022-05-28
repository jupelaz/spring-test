package none.training.spring.boot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AccountRepositoryTestDataJpaTest {

    final Logger log = LoggerFactory.getLogger(AccountRepositoryTestDataJpaTest.class);

    @Autowired
    AccountRepository repository;

    @BeforeAll
    static void setUp(@Autowired AccountRepository repository){
        repository.deleteAll();
        repository.flush();
        repository.save(new Account("1", 100D,"John","Doe",true));
        repository.save(new Account("2",1100D,"Jane","Doe",true));
        repository.save(new Account("3",100D, "Mary Jane","Watson",false));
    }

    @Test
    void injectedComponentIsNotNull(){
        assertNotNull(repository,"repository should not be null");
    }

    @Test
    public void findOne() {

        repository.findAll().forEach(account -> log.info(account.toString()));
        assertNotNull(
                repository.findById("3").orElse(null),
                "There should be a Account with id: 3.");
        assertNull(
                repository.findById("9").orElse(null),
                "There should be no Account with id: 9.");
    }

    @Test
    public void findAll() {
        for (Account account : repository.findAll()) {
            log.info(account.toString());
        }
        assertEquals(
                3,
                repository.findAll().size(),
                "There should be three accounts.");
    }

    @Test
    public void findActive() {

        assertEquals(
                2,
                repository.findByActiveFlagTrue().size(),
                "There should be two active Accounts");
    }

    @Test
    public void findActiveByAssignee() {

        assertEquals(
                2,
                repository.findByActiveFlagTrueAndOwnerLastName("Doe").size(),
                "There should be two active Accounts for the last name: Doe");
    }

    @Test
    public void findCustomNames() {
        assertEquals(3, repository.findByOwnerFirstNameContaining("J").orElse(new ArrayList<>()).size(), "There should be one Account with a note containing the word: Fix");
    }
}
