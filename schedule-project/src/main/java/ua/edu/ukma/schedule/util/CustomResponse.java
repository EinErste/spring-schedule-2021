package ua.edu.ukma.schedule.util;

import lombok.Data;

@Data
public class CustomResponse<T> {

    private T result;
    private CustomResponseError error;

    public static CustomResponse<CustomResponseError> of(CustomResponseError error) {
        CustomResponse<CustomResponseError> response = new CustomResponse<>();
        response.setError(error);
        return response;
    }

    public static <T> CustomResponse<T> of(T result) {
        CustomResponse<T> response = new CustomResponse<>();
        response.setResult(result);
        return response;
    }

}