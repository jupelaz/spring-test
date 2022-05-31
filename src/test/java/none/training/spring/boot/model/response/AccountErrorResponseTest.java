package none.training.spring.boot.model.response;

import none.training.spring.boot.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AccountErrorResponseTest {

    private AccountErrorResponse accountErrorResponse1;
    private AccountErrorResponse accountErrorResponse2;
    private AccountErrorResponse accountErrorResponse3;
    private AccountErrorResponse accountErrorResponse4;

    @BeforeEach
    public void setUp() {

        Issue issue1 = new Issue();
        issue1.setIssueCode("issueCode");
        issue1.setIssueMessage("issueMessage");
        

        Metadata metadata1 = new Metadata();
        metadata1.setDescription("Description");
        metadata1.setRequestId("requestId");
        metadata1.setRequestTimestamp("requestTimestamp");
        metadata1.setResponseId("responseId");
        metadata1.setResponseTimestamp("responseTimestamp");
        metadata1.setServiceName("serviceName");
        metadata1.setServiceVersion("serviceVersion");
        metadata1.setStatus(null);

        accountErrorResponse1 = new AccountErrorResponse();
        accountErrorResponse1.setIssues(Collections.singletonList(issue1));

        accountErrorResponse2 = new AccountErrorResponse();
        accountErrorResponse2.setIssues(Collections.singletonList(issue1));
        
        accountErrorResponse3 = new AccountErrorResponse();
        accountErrorResponse3.setMetadata(metadata1);

        accountErrorResponse4 = new AccountErrorResponse();
    }

    @Test
    public void testEquals() {

        assertEquals(
                accountErrorResponse1,
                accountErrorResponse2,
                "accountErrorResponse1 and accountErrorResponse2 " +
                        "should be equal");

        assertNotEquals(
                accountErrorResponse1,
                accountErrorResponse3,
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not be equal");

        assertNotEquals(
                accountErrorResponse1,
                accountErrorResponse4,
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not be equal");
    }

    @Test
    public void testHashCode() {

        assertEquals(
                accountErrorResponse1.hashCode(),
                accountErrorResponse2.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse2 should " +
                        "have the same hashCode");

        assertNotEquals(
                accountErrorResponse1.hashCode(),
                accountErrorResponse3.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not have the same hashCode");

        assertNotEquals(
                accountErrorResponse1.hashCode(),
                accountErrorResponse4.hashCode(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not have the same hashCode");
    }

    @Test
    public void testToString() {

        assertEquals(
                accountErrorResponse1.toString(),
                accountErrorResponse2.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse2 " +
                        "should have the same toString");

        assertNotEquals(
                accountErrorResponse1.toString(),
                accountErrorResponse3.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse3 " +
                        "should not have the same toString");

        assertNotEquals(
                accountErrorResponse1.toString(),
                accountErrorResponse4.toString(),
                "AccountCollectionServiceResponse1 and AccountCollectionServiceResponse4 " +
                        "should not have the same toString");
    }

}
