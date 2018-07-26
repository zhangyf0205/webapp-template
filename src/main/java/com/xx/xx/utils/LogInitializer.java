package com.xx.xx.utils;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zhangyf on 17/8/2.
 */
public abstract class LogInitializer {
    static {
        InputStream is = null;
        try {
            is = new FileInputStream(ConfUtils.LOG4J_XML);
            ConfigurationSource source = new ConfigurationSource(is);
            Configurator.initialize(LogInitializer.class.getClassLoader(), source);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
