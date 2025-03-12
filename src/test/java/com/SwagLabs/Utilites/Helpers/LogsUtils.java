package com.SwagLabs.Utilites.Helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtils {

    public static final String logPath = "test-outputs/Logs";
    public static Logger logger(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void trace(String... Message){
        logger().trace(String.join(" ",Message));
    }

    public static void debug(String... Message){
        logger().debug(String.join(" ",Message));
    }

    public static void info(String... Message){
        logger().info(String.join(" ",Message));
    }

    public static void warn(String... Message){
        logger().warn(String.join(" ",Message));
    }

    public static void error(String... Message){
        logger().error(String.join(" ",Message));
    }

    public static void fetal(String... Message){
        logger().fatal(String.join(" ",Message));
    }






}
