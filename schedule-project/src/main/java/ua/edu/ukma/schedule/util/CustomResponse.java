package ua.edu.ukma.schedule.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse<T> {
    private T result;
    private CustomResponseError error;

    public static CustomResponse of(CustomResponseError error) {
        CustomResponse response = new CustomResponse();
        response.setError(error);

        return response;
    }

    public static <T> CustomResponse of(T result) {
        CustomResponse<T> response = new CustomResponse<>();
        response.setResult(result);

        return response;
    }

}