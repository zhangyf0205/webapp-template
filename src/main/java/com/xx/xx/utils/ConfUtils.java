package com.xx.xx.utils;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhangyf on 17/7/27.
 */
public class ConfUtils {
    public static final String CONF_DIR = SystemUtils.USER_DIR + File.separator + "conf";

    public static final String LOG4J_XML = CONF_DIR + File.separator + "log4j2.xml";

    public static Properties appConf = load("application.properties");

    public static Properties load(String properties) {
        InputStream is = null;
        Properties prop = null;
        try {
            File file = new File(SystemUtils.USER_DIR + File.separator + "conf" + File.separator + properties);
            is = new FileInputStream(file);
            prop = new Properties();
            prop.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return prop;
    }
}
