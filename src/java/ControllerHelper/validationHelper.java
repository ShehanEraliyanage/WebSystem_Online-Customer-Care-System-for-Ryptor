package ControllerHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validationHelper {

    public static boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile(CommonConstant.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validateNIC(String nic) {
        
       Pattern pattern1 = Pattern.compile(CommonConstant.NIC_OLD_PATTERN); 
       Pattern pattern2 = Pattern.compile(CommonConstant.NIC_NEW_PATTERN); 
       Matcher matcher1 = pattern1.matcher(nic);
       Matcher matcher2 = pattern2.matcher(nic);
       return (matcher1.matches())||(matcher2.matches());
    }
    
    
    public static boolean isValidMobileNumber(String mobileNumber) {
       Pattern pattern = Pattern.compile(CommonConstant.MOBILE_NUMBER_PATTERN);
       Matcher matcher = pattern.matcher(mobileNumber);
       return (matcher.matches());
    }

}
