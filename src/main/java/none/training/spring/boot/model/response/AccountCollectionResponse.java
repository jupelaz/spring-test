package none.training.spring.boot.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import none.training.spring.boot.model.Account;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "metadata",
            "accounts"
    })
public class AccountCollectionResponse implements AccountResponse {

    @JsonProperty("metadata")
    @ApiModelProperty(notes = "Container for any metadata for this request/response")
    private Metadata metadata = new Metadata();

    @JsonProperty("accounts")
    @ApiModelProperty(notes = "A list of accounts returned as a payload")
    private List<Account> accounts;

    public AccountCollectionResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountCollectionResponse that = (AccountCollectionResponse) o;

        if (metadata != null ? !metadata.equals(that.metadata) : that.metadata != null) return false;
        return accounts != null ? accounts.equals(that.accounts) : that.accounts == null;
    }

    @Override
    public int hashCode() {
        int result = metadata != null ? metadata.hashCode() : 0;
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountCollectionResponse{" +
                "metadata=" + metadata +
                ", accounts=" + accounts +
                '}';
    }
}