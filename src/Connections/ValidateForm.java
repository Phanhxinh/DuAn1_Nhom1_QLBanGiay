/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BachTN
 */
public class ValidateForm {
    public static final String POPUP_HEADER = "Thông báo";

    public static final String EMAIL_PATTERN = "^[a-zA-Z][a-zA-Z0-9]+@[fpt]+(\\.[a-zA-Z]+){1,3}$";
    
    public static final String PASS_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,10}$";

    public static final String PHONENUMBER_PATTERN = "\\d{10}";

    // Hàm validate email
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean validatePass(String MatKhau) {
        Pattern pattern = Pattern.compile(PASS_REGEX);
        Matcher matcher = pattern.matcher(MatKhau);
        return matcher.matches();
    }
    
    // Hàm validate số điện thoại
    public static boolean validatePhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile(PHONENUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
