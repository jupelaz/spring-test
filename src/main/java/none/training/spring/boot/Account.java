package none.training.spring.boot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "balance",
        "firstName",
        "lastName",
        "activeFlag"
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique identifier, generated on addition", position = 1)
    @JsonPropertyDescription("The unique identifier, generated on addition")
    @Column(name = "id", nullable = false)
    private String accountId;
    @ApiModelProperty(notes = "The balance of the Account", position = 2, required = true)
    @JsonProperty(required = true)
    @JsonPropertyDescription("The balance of the Account")
    @Column(name = "balance", nullable = false)
    private Double balance;
    @ApiModelProperty(notes = "The Account's owner first name", position = 3, required = true)
    @JsonProperty(required = true)
    @JsonPropertyDescription("The Account's owner first name")
    @Column(name = "firstname", nullable = false)
    private String ownerFirstName;
    @ApiModelProperty(notes = "The Account's owner last name", position = 4, required = true)
    @JsonProperty(required = true)
    @JsonPropertyDescription("The Account's owner last name")
    @Column(name = "lastname", nullable = false)
    private String ownerLastName;
    @ApiModelProperty(notes = "An active flag for the Account", position = 5, required = true)
    @JsonProperty(required = true)
    @JsonPropertyDescription("An active flag for the Account")
    @Column(name = "active", nullable = false)
    private boolean activeFlag;

    public Account() {
    }

    public Account(String accountId, Double balance, String ownerFirstName, String ownerLastName, boolean activeFlag) {
        this.accountId = accountId;
        this.balance = balance;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.activeFlag = activeFlag;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (activeFlag != account.activeFlag) return false;
        if (!Objects.equals(accountId, account.accountId)) return false;
        if (!Objects.equals(balance, account.balance)) return false;
        if (!Objects.equals(ownerFirstName, account.ownerFirstName))
            return false;
        return Objects.equals(ownerLastName, account.ownerLastName);
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (ownerFirstName != null ? ownerFirstName.hashCode() : 0);
        result = 31 * result + (ownerLastName != null ? ownerLastName.hashCode() : 0);
        result = 31 * result + (activeFlag ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", ownerFirstName='" + ownerFirstName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", activeFlag=" + activeFlag +
                '}';
    }
}

