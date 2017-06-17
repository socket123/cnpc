package com.su.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Chris 2010-4-16
 * 
 *         Properties文件管理
 * 
 */
public class PropertiesUtil {

    private static Properties property = null;

    private static String propertyFile = "/config.properties";

    static {
        if (property == null) {
            loadFile(true);
        }
    }

    /**
     * load property file(default property file is "/util.properties")
     * 
     * @param flag
     * 
     */
    public static void loadFile(boolean flag) {
        LogUtil.getLogger().info("load property file is ---" + propertyFile);
        InputStream inStream = null;
        property = new Properties();
        try {
            if (flag) {
                inStream = PropertiesUtil.class.getResourceAsStream(propertyFile);
            } else {
                inStream = new FileInputStream(propertyFile);
            }
            property.load(inStream);
        } catch (Exception e) {
            if (flag) {
                loadFile(false);
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * get value from property file
     * 
     * @param key
     * @return String
     */
    public static String getProperty(String key) {
        return StringUtil.encodeStr(StringUtil.trimStr(property.getProperty(key)), System.getProperty("file.encoding"));
    }

    /**
     * set property to sort to property file
     * 
     * @param key
     * @param value
     */
    public static void setProperty(String key, String value) {
        FileOutputStream fos = null;
        property.setProperty(key, value);
        try {
            fos = new FileOutputStream(propertyFile);
            property.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return Returns the property.
     */
    public static Properties getProperty() {
        return property;
    }

    /**
     * @param property
     *            The property to set.
     */
    public static void setProperty(Properties property) {
        PropertiesUtil.property = property;
    }

    /**
     * @return Returns the propertyFile.
     */
    public static String getPropertyFile() {
        return propertyFile;
    }

    /**
     * @param propertyFile
     *            The propertyFile to set.
     */
    public static void setPropertyFile(String propertyFile) {
        if (!PropertiesUtil.propertyFile.equals(propertyFile)) {
            PropertiesUtil.propertyFile = propertyFile;
            PropertiesUtil.loadFile(true);
        }
    }

}
