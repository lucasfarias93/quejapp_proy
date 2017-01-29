package com.projectbelatrix.quejapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LUCAS on 29/01/2017.
 */
public class ValidatorClass {
    public static final String PATTERN_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean validarEmail(String email_1) {
        Pattern patron = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = patron.matcher(email_1);
        return matcher.matches();
    }
}
