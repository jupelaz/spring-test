package none.training.spring.boot.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AccountErrorResponse implements AccountResponse{

    @JsonProperty("metadata")
    @ApiModelProperty(notes = "Container for any metadata for this request/response")
    private Metadata metadata = new Metadata();

    @JsonProperty("issues")
    @ApiModelProperty(notes = "Container for any issues or failure messages for the request")
    private List<Issue> issues;

    public AccountErrorResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountErrorResponse that = (AccountErrorResponse) o;

        if (metadata != null ? !metadata.equals(that.metadata) : that.metadata != null) return false;
        return issues != null ? issues.equals(that.issues) : that.issues == null;
    }

    @Override
    public int hashCode() {
        int result = metadata != null ? metadata.hashCode() : 0;
        result = 31 * result + (issues != null ? issues.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountErrorResponse{" +
                "metadata=" + metadata +
                ", issues=" + issues +
                '}';
    }
}
