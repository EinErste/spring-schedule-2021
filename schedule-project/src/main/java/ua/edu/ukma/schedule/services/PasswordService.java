package ua.edu.ukma.schedule.services;

public interface PasswordService {

    String encodePassword(String password);

    boolean compareRawAndEncodedPassword(String raw, String encoded);
}
