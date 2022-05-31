package none.training.spring.boot.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "statusCode",
        "statusDescription"
})
public class Status implements Serializable {

    @JsonProperty("statusCode")
    @ApiModelProperty(notes = "The status code associated with this status message.")
    private String statusCode;

    @JsonProperty("success")
    @ApiModelProperty(notes = "A boolean flag to indicate the success of the operation.", example = "true")
    private boolean success;

    @JsonProperty("statusDescription")
    @ApiModelProperty(notes = "The status message associated with this status code.")
    private String statusDescription;

    public Status() {
    }

    public Status(String statusCode, boolean success, String statusDescription) {
        this.statusCode = statusCode;
        this.success = success;
        this.statusDescription = statusDescription;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (success != status.success) return false;
        if (statusCode != null ? !statusCode.equals(status.statusCode) : status.statusCode != null) return false;
        return statusDescription != null ? statusDescription.equals(status.statusDescription) : status.statusDescription == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (success ? 1 : 0);
        result = 31 * result + (statusDescription != null ? statusDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusCode='" + statusCode + '\'' +
                ", success=" + success +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }
}
