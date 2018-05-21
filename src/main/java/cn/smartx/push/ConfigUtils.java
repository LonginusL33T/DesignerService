package cn.smartx.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 加载配置文件的工具类
 * Created by Jeepeng on 2015/5/8.
 */
public class ConfigUtils {
    private static Logger log = LoggerFactory.getLogger(ConfigUtils.class);

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    /**
     * 加载配置文件
     *
     * @param fileName 配置文件名（含路径）
     * @return
     */
    public static Properties loadPropertyFile(String fileName) {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = classLoader.getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new IllegalArgumentException("配置文件找不到: " + fileName);
            }
            properties.load(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件出错.", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    /**
     * 加载配置文件的键值对（key-value）到Map里
     * @param fileName
     * @return
     */
    public static Map<Object,Object> loadProperties2Map(String fileName){
        Properties properties = loadPropertyFile(fileName);
        return loadProperties2Map(properties);
    }

    /**
     * 加载配置文件的键值对（key-value）到Map里
     * @param properties
     * @return 保存properties键值对（key-value）的Map
     */
    public static Map<Object,Object> loadProperties2Map(Properties properties){
        Map<Object,Object> configMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            configMap.put(key, value);
        }
        return configMap;
    }

    /**
     * 加载系统Properties到一个Map中
     * @return 系统配置键值对（key-value）的Map
     */
    public static Map<Object,Object> loadSystemProperties2Map() {
        Properties properties = System.getProperties();
        return loadProperties2Map(properties);
    }

    /**
     * 获取当前项目资源路径（classes目录路径）
     * @return
     */
    public static String getResourcePath (){
        URL resourceURL = classLoader.getResource("");
        String resourcePath = "";
        if (resourceURL != null){
            resourcePath = resourceURL.toString();
            if (isWindows()) {
                resourcePath = resourcePath.replace("file:/", ""); //windows系统去掉"file:/"
            } else if (isLinux()){
                resourcePath = resourcePath.replace("file:", ""); //linux系统去掉"file:"
            }else {
                resourcePath = resourcePath.replace("file:", ""); //其他系统去掉"file:"
            }
        }
        log.debug(resourcePath);
        return resourcePath;
    }

    /**
     * 获取WEB-INF路径
     * @return
     */
    public static String getWebINFPath() {
        return getResourcePath().replace("classes/", ""); //去掉"class/"
    }

    /**
     * 获取WebRoot（webapp）路径
     * @return
     */
    public static String getWebRootPath() {
        return getResourcePath().replace("WEB-INF/classes/", ""); //去掉"WEB-INF/classes/"
    }

    /**
     * 获取当前系统名称
     *
     * @return 当前系统名称
     */
    public static String getOsName() {
        String osName = System.getProperty("os.name");
        if (osName != null) {
            return osName;
        }
        return "";
    }

    private static String OS_NAME = getOsName().toLowerCase();

    public static boolean isLinux() {
        return OS_NAME.contains("linux");
    }

    public static boolean isWindows() {
        return OS_NAME.contains("windows");
    }
}
