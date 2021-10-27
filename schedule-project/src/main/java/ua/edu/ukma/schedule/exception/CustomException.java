package ua.edu.ukma.schedule.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class CustomException extends Exception {
    private int code;
    private String message;

    public CustomException(String message, int code){
        super(message);
        this.message = message;
        this.code = code;
    }
}
