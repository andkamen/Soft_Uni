package bg.softuni.exceptions;

public abstract class LambdaCoreBaseException extends Exception {

    protected LambdaCoreBaseException() {
        super();
    }

    protected LambdaCoreBaseException(String message) {
        super(message);
    }
}
