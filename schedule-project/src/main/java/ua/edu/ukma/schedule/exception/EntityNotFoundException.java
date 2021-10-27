package ua.edu.ukma.schedule.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class EntityNotFoundException extends CustomException{
    public EntityNotFoundException() {
        super(404, "Requested entity not found");
    }
}
