package ua.edu.ukma.schedule.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public abstract class CustomException extends Exception {

    private final int code;

    public CustomException(String message, int code){
        super(message);
        this.code = code;
    }
}
