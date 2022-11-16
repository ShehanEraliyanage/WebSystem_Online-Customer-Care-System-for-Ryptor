package ControllerHelper;

public final class CommonConstant {
    
    // Constant for catalina path
    // public static final String CATALINA = System.getProperty("catalina.base");
    
    // Constant for file path of Query.xml
    public static final String QUERY_XML_FILE_PATH = "C:\\Users\\Hirusha\\Documents\\NetBeansProjects\\OOPproject\\web\\WEB-INF\\Query.xml";
    
    // Constant for loggre.log folder path with logger file
    public static final String LOGGER_DRI = "C:\\Users\\Hirusha\\Desktop\\logger\\loggre.log";
    
    // Constant for admin image uploard folder
    public static final String ADMIN_IMAGE_UPLOAD_DIR = "C:\\Users\\Hirusha\\Documents\\NetBeansProjects\\OOPproject\\web\\img\\admin\\";
    
    // Constant for agent image uploard folder
    public static final String AGENT_IMAGE_UPLOAD_DIR = "C:\\Users\\Hirusha\\Documents\\NetBeansProjects\\OOPproject\\web\\img\\agent\\";
    
    
    
    
    
    // Constant for admin image folder path
    public static final String ADMIN_DRI = "img/admin/";
    
    // Constant for agent image folder path
    public static final String AGENT_DRI = "img/agent/";;
    
    // Constant for file path of Config.properties
    public static final String PROPERTY_FILE = "Config.properties";
    
    // Constant for query tag in Query.xml
    public static final String TAG_NAME = "query";
    
    // Constant for query id in Query.xml
    public static final String ATTRIBUTE_ID = "id";
    
    // Constant for driver name key MySQL database in Config.properties
    public static final String DRIVER_NAME = "driverName";
    
    // Constant for url key MySQL database in Config.properties
    public static final String URL = "url";
    
    // Constant for user name key MySQL database in Config.properties
    public static final String USER_NAME = "userName";
    
    // Constant for password key MySQL database in Config.properties
    public static final String PASSWORD = "password";
    
    // Constant for validate email pattern in ValidateHelper
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    
    // Constant for validate old NIC pattern in ValidateHelper
    public static final String NIC_OLD_PATTERN = "^\\d{9}[vVxX]$";
    
    // Constant for validate new NIC pattern in ValidateHelper
    public static final String NIC_NEW_PATTERN = "^\\d{12}$";
    
    // Constant for validate mobile numberpattern in ValidateHelper
    public static final String MOBILE_NUMBER_PATTERN = "^\\d{10}$";
    
    // Constant for enslish characters in use FuntionHelper
    public static final String ENGLISH_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    
    // Constant for decimal
    public static final String DECIMAL = "01234567489"; 
    
    // Constant for enslish characters and decimal in use FuntionHelper
    public static final String ENGLISH_CHARACTERS_AND_DECIMAL = ENGLISH_CHARACTERS+DECIMAL; 
}
