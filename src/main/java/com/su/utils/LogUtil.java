package com.su.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {

    static {
        try {
            PropertyConfigurator.configure(LogUtil.class.getResource("/config/log4j.properties").getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Log getLogger() {
        return LogFactory.getLog("");
    }

    public static void main(String[] args) {
        getLogger();
    }

}
