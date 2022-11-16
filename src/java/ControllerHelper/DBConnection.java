package ControllerHelper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends CommonUtil {

    private static Connection connection;
    
    // This work according to singleton pattern
    private DBConnection(){  
    }

    public static Connection estamblishConnnection() {
        try {
            
            /*
             * This create new connection object when connection is closed or it is null
             */

                Class.forName(properties.getProperty(CommonConstant.DRIVER_NAME));
                connection = DriverManager.getConnection(properties.getProperty(CommonConstant.URL),
                                                         properties.getProperty(CommonConstant.USER_NAME),
                                                         properties.getProperty(CommonConstant.PASSWORD));

        } catch (ClassNotFoundException | SQLException e) {
            Log.logMessage(DBConnection.class.getName(),e);   
        }

        return connection;
    }

}
