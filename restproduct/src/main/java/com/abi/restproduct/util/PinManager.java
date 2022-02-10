package com.abi.restproduct.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Base64;

public class PinManager {

    private static final Logger logger = LoggerFactory.getLogger(PinManager.class);

    private PinManager() {
    }

    public static String generateSafePin()  {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[42];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        logger.info("PIN generado: {}", token);
        return token;
    }

    public static String encodePin(String pin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pinBD = passwordEncoder.encode(pin);
        logger.info("PIN encriptado: {}", pinBD);
        return pinBD;
    }
}
