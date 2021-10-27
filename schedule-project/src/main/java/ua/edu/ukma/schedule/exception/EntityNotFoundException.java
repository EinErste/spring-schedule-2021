package ua.edu.ukma.schedule.exception;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException() {
        super("Requested entity not found", 404);
    }

}
