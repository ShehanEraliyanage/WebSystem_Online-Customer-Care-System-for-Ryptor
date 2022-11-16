package ControllerHelper;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.Part;

public class FuntionHelper {
    
    public static String randomUserName() {

        final java.util.Random rand = new java.util.Random();

        final Set<String> identifiers = new HashSet<String>();
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(CommonConstant.ENGLISH_CHARACTERS.charAt(rand.nextInt(CommonConstant.ENGLISH_CHARACTERS.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public static String randomPassword() {

        final java.util.Random rand = new java.util.Random();

        final Set<String> identifiers = new HashSet<String>();
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(CommonConstant.ENGLISH_CHARACTERS_AND_DECIMAL.charAt(rand.nextInt(CommonConstant.ENGLISH_CHARACTERS_AND_DECIMAL.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
    
     public static String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }
     
      public static void printSQLException(String className,SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("Class name  : " + className);
                System.err.println("SQLState    : " + ((SQLException) e).getSQLState());
                System.err.println("Error Code  : " + ((SQLException) e).getErrorCode());
                System.err.println("Message     : " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
      
     
}
