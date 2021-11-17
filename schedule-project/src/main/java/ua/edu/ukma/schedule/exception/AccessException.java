package ua.edu.ukma.schedule.exception;

public class AccessException extends CustomException {

    public AccessException() {
        super("Don't have access to this page", 403);
    }

}
