package bg.softuni.exceptions;

public class UnexistentCoreException extends LambdaCoreBaseException {

    public UnexistentCoreException() {
        super();
    }

    public UnexistentCoreException(String message) {
        super(message);
    }
}
