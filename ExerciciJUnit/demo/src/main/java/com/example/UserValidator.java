package com.example;

import java.util.regex.Pattern;

public class UserValidator {
    public boolean validaDNI(String dni) {
        return Pattern.matches("\\d{8}[A-Za-z]", dni);
    }

    public boolean validaNIA(String nia) {
        return Pattern.matches("\\d{7}", nia);
    }

    public boolean validaUsuario(String dni, String nia, String password) {
        return validaDNI(dni) && validaNIA(nia) && password.length() >= 8;
    }
}

