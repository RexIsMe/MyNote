package com.example.demo.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @author Liaoyifan
 * @date 2016年8月8日
 */
public class PropertiesUtil {

    private PropertiesUtil() {
    }

    private static String getResourcePath() {
        return System.getProperty("os.name").toLowerCase().startsWith("win")
                ? PropertiesUtil.class.getResource(".").getPath().substring(1)
                : PropertiesUtil.class.getResource(".").getPath();
    }

    public static String getProperty(final String property, final String key) {
        String path = getResourcePath();
        try (InputStream input = FileUtils.openInputStream(FileUtils.getFile((path.substring(0, path.indexOf("target"))) + "src/main/resources/" + property))) {
            Properties properties = new Properties();
            properties.load(input);
            return properties.getProperty(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDevProperty(final String key) {
        return getProperty("application-dev.properties", key);
    }

    public static String getCommonProperty(final String key) {
        return getProperty("application.properties", key);
    }

    public static String getFileProperty(final String filePath, final String key) {
        InputStream input = null;
        try {
            input = FileUtils.openInputStream(new File(filePath));
            Properties properties = new Properties();
            properties.load(input);
            return properties.getProperty(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public static Map<String, String> getPropertys(final String filePath) {
        InputStream input = null;
        try {
            input = FileUtils.openInputStream(new File(filePath));
            Properties properties = new Properties();
            properties.load(input);
            Enumeration<?> enumeration = properties.propertyNames();
            Map<String, String> map = new HashMap<String, String>();
            while (enumeration.hasMoreElements()) {
                String key = String.valueOf(enumeration.nextElement());
                String value = properties.getProperty(key);
                map.put(key, value);
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public static void write(final String filePath, final String key, final String value) {
        OutputStream output = null;
        try {
            output = FileUtils.openOutputStream(new File(filePath));
            Properties properties = new Properties();
            properties.setProperty(key, value);
            properties.store(output, "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

    public static void write(final String filePath, final Map<String, String> keyValues) {
        OutputStream output = null;
        try {
            output = FileUtils.openOutputStream(new File(filePath));
            Properties properties = new Properties();
            if (keyValues != null && !keyValues.isEmpty()) {
                for (Entry<String, String> entry : keyValues.entrySet())
                    properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(output, "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

}