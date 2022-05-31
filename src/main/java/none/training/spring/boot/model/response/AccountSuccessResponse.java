package none.training.spring.boot.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import none.training.spring.boot.model.Account;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "metadata",
            "account"
    })
public class AccountSuccessResponse implements AccountResponse {

    @JsonProperty("metadata")
    @ApiModelProperty(notes = "Container for any metadata for this request/response")
    private Metadata metadata = new Metadata();

    @JsonProperty("account")
    @ApiModelProperty(notes = "A single account returned as a payload")
    private Account account;

    public AccountSuccessResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountSuccessResponse that = (AccountSuccessResponse) o;

        if (!Objects.equals(metadata, that.metadata)) return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result = metadata != null ? metadata.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountSuccessResponse{" +
                "metadata=" + metadata +
                ", account=" + account +
                '}';
    }
}