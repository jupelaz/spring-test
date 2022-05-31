package none.training.spring.boot.model.response;

import none.training.spring.boot.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AccountSuccessResponseTest {

    private AccountSuccessResponse accountSuccessResponse1;
    private AccountSuccessResponse accountSuccessResponse2;
    private AccountSuccessResponse accountSuccessResponse3;
    private AccountSuccessResponse accountSuccessResponse4;

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

        accountSuccessResponse1 = new AccountSuccessResponse();
        accountSuccessResponse1.setAccount(account1);

        accountSuccessResponse2 = new AccountSuccessResponse();
        accountSuccessResponse2.setAccount(account1);
        
        accountSuccessResponse3 = new AccountSuccessResponse();
        accountSuccessResponse3.setMetadata(metadata1);

        accountSuccessResponse4 = new AccountSuccessResponse();
    }

    @Test
    public void testEquals() {

        assertEquals(
                accountSuccessResponse1,
                accountSuccessResponse2,
                "accountSuccessResponse1 and accountSuccessResponse2 " +
                        "should be equal");

        assertNotEquals(
                accountSuccessResponse1,
                accountSuccessResponse3,
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not be equal");

        assertNotEquals(
                accountSuccessResponse1,
                accountSuccessResponse4,
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not be equal");
    }

    @Test
    public void testHashCode() {

        assertEquals(
                accountSuccessResponse1.hashCode(),
                accountSuccessResponse2.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse2 should " +
                        "have the same hashCode");

        assertNotEquals(
                accountSuccessResponse1.hashCode(),
                accountSuccessResponse3.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not have the same hashCode");

        assertNotEquals(
                accountSuccessResponse1.hashCode(),
                accountSuccessResponse4.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not have the same hashCode");
    }

    @Test
    public void testToString() {

        assertEquals(
                accountSuccessResponse1.toString(),
                accountSuccessResponse2.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse2 " +
                        "should have the same toString");

        assertNotEquals(
                accountSuccessResponse1.toString(),
                accountSuccessResponse3.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not have the same toString");

        assertNotEquals(
                accountSuccessResponse1.toString(),
                accountSuccessResponse4.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not have the same toString");
    }

}
