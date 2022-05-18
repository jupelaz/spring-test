package none.training.spring.boot.exception;

public class AccountInvalidException extends RuntimeException{
    public AccountInvalidException(String message){
        super(message);
    }
}
