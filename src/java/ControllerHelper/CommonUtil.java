package ControllerHelper;

import java.io.IOException;
import java.util.Properties;

public class CommonUtil {
    
    public static final Properties properties = new Properties();
    
    // static block
    static{
        try {
            // read the property only once when load the class
            properties.load(QueryUtil.class.getResourceAsStream(CommonConstant.PROPERTY_FILE));
            
        } catch (IOException e) {
            Log.logMessage(CommonUtil.class.getName(),e);
        }
    }
}
