package none.training.spring.boot.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message, String accountId){
        super(String.format(message,accountId));
    }
}
