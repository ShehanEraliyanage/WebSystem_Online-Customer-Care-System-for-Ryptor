package ControllerHelper;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    public static void logMessage(String className,Exception message) {
        LogManager lMgr = LogManager.getLogManager();
        Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        lMgr.addLogger(log);

        try {
            File f = new File(CommonConstant.LOGGER_DRI);
            if (!f.exists()) {
                f.createNewFile();
            }

            FileHandler fh = new FileHandler(CommonConstant.LOGGER_DRI, true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
            log.setUseParentHandlers(false);
            log.log(Level.SEVERE, className ,message);
            fh.close();
        } catch (Exception e) {
        }
    }
    
 

}
