package com.yilin.app.utils;


import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cc on 2017/6/26.
 */

public class LoggerUtil {

    static {
        PropertyConfigurator.configure(LoggerUtil.class.getResourceAsStream("/log4j.properties"));
    }

    public Logger logger;

    @SuppressWarnings("rawtypes")
    public LoggerUtil(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    @SuppressWarnings("rawtypes")
    public static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public void d(String message) {
        logger.debug(message);
    }

    public void i(String message) {
        logger.info(message);
    }

    public void e(String message) {
        logger.error(message);
    }


}
