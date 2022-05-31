package none.training.spring.boot.model;

import none.training.spring.boot.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {
    Account empty;
    Account empty2;
    private Account withData;
    private Account withData2;

    @BeforeEach
    public void setup(){
        empty = new Account();
        empty2 = new Account();
        withData = new Account();
        withData2 = new Account();
        withData.setAccountId("1");
        withData.setActiveFlag(true);
        withData.setBalance(1D);
        withData.setOwnerFirstName("John");
        withData.setOwnerLastName("Doe");

        withData2.setAccountId("1");
        withData2.setActiveFlag(true);
        withData2.setBalance(1D);
        withData2.setOwnerFirstName("John");
        withData2.setOwnerLastName("Doe");
    }

    @Test
    public void testEmptyEquals(){
        assertTrue(
                empty.equals(empty2),
                "Empty accounts should be equal"
        );
    }
    @Test
    public void testFulfilledEquals(){
        assertTrue(
                withData.equals(withData2),
                "Fulfilled accounts should be equal"
        );
    }
    @Test
    public void emptyAndFulfilledAccountsNotEquals(){
        assertFalse(
                withData.equals(empty),
                "Fulfilled and empty account should not be equal"
        );
    }

    @Test
    public void testEmptyHashCodes(){
        assertEquals(
                empty.hashCode(),
                empty2.hashCode(),
                "Empty hashcode should be equal"
        );
    }
    @Test
    public void testFulfilledHashCodes(){
        assertEquals(
                withData.hashCode(),
                withData2.hashCode(),
                "Fulfilled hashcode should be equal"
        );
    }
    @Test
    public void emptyAndFulfilledHashcodeNotEqual(){
        assertNotEquals(
                withData.hashCode(),
                empty.hashCode(),
                "Fulfilled and empty hashcode should not be equal"
        );
    }

    @Test
    public void testEmptyToString(){
        assertEquals(
                empty.toString(),
                empty2.toString(),
                "Empty toString should be equal"
        );
    }
    @Test
    public void testFulfilledToString(){
        assertEquals(
                withData.toString(),
                withData2.toString(),
                "Fulfilled toString should be equal"
        );
    }
    @Test
    public void emptyAndFulfilledToStringNotEqual(){
        assertNotEquals(
                withData.toString(),
                empty.toString(),
                "Fulfilled and empty toString should not be equal"
        );
    }


}
