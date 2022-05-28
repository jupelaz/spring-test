package none.training.spring.boot;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LabApplication.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup(AccountRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {AccountRepositoryTest.DATASET})
@DirtiesContext
public class AccountRepositoryTest {

    final Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

    protected static final String DATASET = "classpath:datasets/account.xml";
    @Autowired
    private AccountRepository repository;

    @Test
    public void findOne() {

        assertNotNull(
                repository.findById("3").orElse(null),
                "There should be a Account with id: 3.");
        assertNull(
                repository.findById("9").orElse(null),
                "There should be no Account with id: 9.");
    }

    @Test
    public void findAll() {
        repository.findAll().forEach(account -> log.info(account.toString()));
        assertEquals(
                3,
                repository.findAll().size(),
                "There should be three total Accounts.");
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

        assertEquals(
                3,
                repository.findByOwnerFirstNameContaining("J").orElse(new ArrayList<>()).size(),
                "There should be one Account with a note containing the word: Fix");
    }
}

