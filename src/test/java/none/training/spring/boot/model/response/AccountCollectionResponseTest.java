package none.training.spring.boot.model.response;

import java.util.Collections;

import none.training.spring.boot.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AccountCollectionResponseTest {

    private AccountCollectionResponse accountCollectionResponse1;
    private AccountCollectionResponse accountCollectionResponse2;
    private AccountCollectionResponse accountCollectionResponse3;
    private AccountCollectionResponse accountCollectionResponse4;

    @BeforeEach
    public void setUp() {

        Account account1 = new Account();
        account1.setAccountId("3");
        account1.setOwnerFirstName("Manolo");
        account1.setOwnerLastName("Lama");
        account1.setActiveFlag(true);
        account1.setBalance(10000D);
        

        Metadata metadata1 = new Metadata();
        metadata1.setDescription("Description");
        metadata1.setRequestId("requestId");
        metadata1.setRequestTimestamp("requestTimestamp");
        metadata1.setResponseId("responseId");
        metadata1.setResponseTimestamp("responseTimestamp");
        metadata1.setServiceName("serviceName");
        metadata1.setServiceVersion("serviceVersion");
        metadata1.setStatus(null);

        accountCollectionResponse1 = new AccountCollectionResponse();
        accountCollectionResponse1.setAccounts(Collections.singletonList(account1));

        accountCollectionResponse2 = new AccountCollectionResponse();
        accountCollectionResponse2.setAccounts(Collections.singletonList(account1));
        
        accountCollectionResponse3 = new AccountCollectionResponse();
        accountCollectionResponse3.setMetadata(metadata1);

        accountCollectionResponse4 = new AccountCollectionResponse();
    }

    @Test
    public void testEquals() {

        assertEquals(
                accountCollectionResponse1,
                accountCollectionResponse2,
                "accountCollectionResponse1 and accountCollectionResponse2 " +
                        "should be equal");

        assertNotEquals(
                accountCollectionResponse1,
                accountCollectionResponse3,
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not be equal");

        assertNotEquals(
                accountCollectionResponse1,
                accountCollectionResponse4,
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not be equal");
    }

    @Test
    public void testHashCode() {

        assertEquals(
                accountCollectionResponse1.hashCode(),
                accountCollectionResponse2.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse2 should " +
                        "have the same hashCode");

        assertNotEquals(
                accountCollectionResponse1.hashCode(),
                accountCollectionResponse3.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not have the same hashCode");

        assertNotEquals(
                accountCollectionResponse1.hashCode(),
                accountCollectionResponse4.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not have the same hashCode");
    }

    @Test
    public void testToString() {

        assertEquals(
                accountCollectionResponse1.toString(),
                accountCollectionResponse2.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse2 " +
                        "should have the same toString");

        assertNotEquals(
                accountCollectionResponse1.toString(),
                accountCollectionResponse3.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not have the same toString");

        assertNotEquals(
                accountCollectionResponse1.toString(),
                accountCollectionResponse4.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not have the same toString");
    }

}
