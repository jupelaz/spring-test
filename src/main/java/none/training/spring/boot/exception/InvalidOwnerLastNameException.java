package none.training.spring.boot.exception;

public class InvalidOwnerLastNameException extends RuntimeException{
    public InvalidOwnerLastNameException(final String message, final String lastName ){
        super(String.format(message,lastName));
    }
}
