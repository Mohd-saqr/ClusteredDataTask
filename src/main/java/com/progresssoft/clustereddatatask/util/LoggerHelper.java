package com.progresssoft.clustereddatatask.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {

    private static final Logger logger;

    static {
        logger  = LoggerFactory.getLogger(LoggerHelper.class);
    }


    public static void logInfo(String massage){
        logger.info(massage);
    }


    public static void logError(String massage){
        logger.error(massage);
    }


}
