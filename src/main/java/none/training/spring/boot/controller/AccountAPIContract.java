package none.training.spring.boot.controller;

import io.swagger.annotations.*;
import none.training.spring.boot.model.Account;
import none.training.spring.boot.model.response.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.MediaType.*;

@Api(
        tags = {"account-service"}
)
@RequestMapping("/accounts")
public interface AccountAPIContract {

    @ApiOperation(
            value = "Create a new account record",
            notes = "Use this resource to add a new account record.",
            tags = {"account-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Account record created.", response = AccountSuccessResponse.class),
            @ApiResponse(code = 400, message = "Bad or malformed request", response = AccountErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to create this account record.", response =
                    AccountErrorResponse.class),
            @ApiResponse(code = 412, message = "Account record creation failed, due to validations.", response =
                    AccountErrorResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Account record was not created.", response =
                    AccountErrorResponse.class),
    })
    @PostMapping(
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<AccountResponse> Account(
            @ApiParam(required = true, value = "A account record to add")
            @Valid @RequestBody
                    Account account,
            HttpServletRequest request);
//--------------------------------------------------------------------------------------------
@ApiOperation(
        value = "Fetch multiple account records",
        notes = "Use this resource to fetch multiple account records from the repository.",
        tags = {"account-service"}
)
@ApiResponses({
        @ApiResponse(code = 200, message = "Account record(s) fetched.", response = AccountCollectionResponse.class),
        @ApiResponse(code = 400, message = "Account record(s) fetch failed.", response = AccountErrorResponse.class),
        @ApiResponse(code = 403, message = "User is not entitled to fetch account record(s).", response = AccountErrorResponse
                .class),
        @ApiResponse(code = 500, message = "An unexpected error has occurred. Account record(s) was not fetched.", response =
                AccountErrorResponse.class)})
@GetMapping(
        consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE, ALL_VALUE},
        produces = {APPLICATION_JSON_VALUE}
)
ResponseEntity<AccountResponse> getAccounts(
        @ApiParam(name = "includeInactive", value = "Fetch inactive accounts, if true", defaultValue = "false")
                Boolean includeInactive,
        HttpServletRequest request);
//--------------------------------------------------------------------------------------------
    @ApiOperation(
            value = "Fetch account record(s) by last name",
            notes = "Use this resource to fetch account records by last name from the repository.",
            tags = {"account-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Account record fetched.", response = AccountCollectionResponse.class),
            @ApiResponse(code = 400, message = "Account record fetch failed.", response = AccountErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to fetch this account record.", response = AccountErrorResponse
                    .class),
            @ApiResponse(code = 404, message = "Account record was not found.", response = AccountErrorResponse
                    .class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Account record was not fetched.", response =
                    AccountErrorResponse.class)})
    @GetMapping(
            value = "/lastname/{lastname}",
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<AccountResponse> getAccountsByLastName(
            @ApiParam(required = true, value = "Last name associated with the account records")
            @PathVariable(value = "lastname")
                    String lastName,
            HttpServletRequest request);
    //--------------------------------------------------------------------------------------------
    @ApiOperation(
            value = "Fetch a account record by id",
            notes = "Use this resource to fetch a account record from the repository.",
            tags = {"account-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Account record fetched.", response = AccountSuccessResponse.class),
            @ApiResponse(code = 400, message = "Account record fetch failed.", response = AccountErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to fetch this account record.", response = AccountErrorResponse
                    .class),
            @ApiResponse(code = 404, message = "Account record was not found.", response = AccountErrorResponse
                    .class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Account record was not fetched.", response =
                    AccountErrorResponse.class)})
    @GetMapping(
            value = "/{accountId}",
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<AccountResponse> getAccount(
            @ApiParam(required = true, value = "AccountId representing the account record")
            @PathVariable(value = "accountId")
                    String accountId,
            HttpServletRequest request);
    //--------------------------------------------------------------------------------------------
    @ApiOperation(
            value = "Update a account record",
            notes = "Use this resource to update an existing account record in the repository.",
            tags = {"account-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Account record record updated.", response = AccountSuccessResponse.class),
            @ApiResponse(code = 400, message = "Bad or malformed request", response = AccountErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to update this account record.", response =
                    AccountErrorResponse.class),
            @ApiResponse(code = 404, message = "Account record was not found.", response = AccountErrorResponse.class),
            @ApiResponse(code = 412, message = "Account record update failed.", response = AccountErrorResponse
                    .class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Account record was not updated.", response =
                    AccountErrorResponse.class)})
    @PutMapping(
            value = "/{accountId}",
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<AccountResponse> updateAccount(
            @ApiParam(required = true, value = "AccountId representing the account record") @PathVariable(value = "accountId")
                    String accountId,
            @ApiParam(required = true, value = "A account record to update") @Valid @RequestBody Account account,
            HttpServletRequest request);
    //--------------------------------------------------------------------------------------------
    @ApiOperation(
            value = "Delete a account record",
            notes = "Use this resource to delete an existing account record from the repository",
            tags = {"account-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Account record deleted.", response = AccountSuccessResponse.class),
            @ApiResponse(code = 400, message = "Bad or malformed request", response = AccountErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to delete this account record.", response =
                    AccountErrorResponse.class),
            @ApiResponse(code = 404, message = "Account record was not found.", response = AccountErrorResponse.class),
            @ApiResponse(code = 412, message = "Account record was not deleted.", response = AccountErrorResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Account record was not deleted.", response =
                    AccountErrorResponse.class)}
    )
    @DeleteMapping(
            value = "/{accountId}",
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<AccountResponse> deleteAccount(
            @ApiParam(required = true, value = "AccountId representing the account record") @PathVariable("accountId")
                    String accountId,
            HttpServletRequest request);
}
