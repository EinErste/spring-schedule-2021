package ua.edu.ukma.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.services.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PasswordServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean compareRawAndEncodedPassword(String raw, String encoded) {
        return bCryptPasswordEncoder.matches(raw, encoded);
    }
}
