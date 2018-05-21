package cn.smartx.jelly.builder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * .java -> sourcePath\source\package\*.xml
 * Created by Baxter on 2015/9/17.
 */
public class PageBuilder {
    private final static String BUILDER_CONF = "page_builder";

    private String sourcePath;
    private String outputPath;
    private List<String> fileList;
    private final long thisBuildTime = System.currentTimeMillis();
    private long lastBuildTime;


    public PageBuilder(String sourcePath, String outputPath) {
        /**
         * 获取上一次的编译时间
         */
        String fullFileName = System.getProperty("user.home") + File.separator + BUILDER_CONF;
        File builderConfig = new File(fullFileName);
        if (!builderConfig.exists()) {
            this.lastBuildTime = 0;
        } else {
            try {
                this.lastBuildTime = Long.parseLong(readFile(fullFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.sourcePath = sourcePath;
        this.outputPath = outputPath;
        fileList = new ArrayList<>();
        listDir(new File(this.sourcePath));
    }

    public void build() throws Exception {
        for (String sourceFile : this.fileList) {
            Properties properties = loadClass(sourceFile);
            if (properties == null){
                continue;
            }
            System.out.println("Start to build <" + properties.getProperty("class") + ">");
            String xml = invoke(properties.getProperty("class"));
            String path = (properties.getProperty("package") == null ? outputPath : (outputPath + File.separator + properties.getProperty("package").replace(".", File.separator))) + File.separator;
            writeStringToFile(xml, path, properties.getProperty("class.name") + ".xml", "UTF-8");

            /**
             * 记录编译时间
             */
            writeStringToFile(String.valueOf(thisBuildTime), System.getProperty("user.home") + File.separator, BUILDER_CONF, "UTF-8");
        }
    }

    /**
     * 获取类的包名和类名
     * @param file .java文件
     * @return package:包名，class:包名+类名，class.name:类名
     * @throws IOException
     */
    public Properties loadClass(String file) throws IOException {
        Properties classProperties = new Properties();

        String java = readFile(file);
        if (!java.contains("public class")) {
            return null;
        }
        for (String line : java.split("\n")) {
            if (line.startsWith("package")) {
                classProperties.put("package", line.substring(line.indexOf(" ") + 1, line.indexOf(";")));
            }else if (line.startsWith("public class")) {
                if (!line.contains("extends JellyInjectBase") && !line.contains("extends JellyInjectAkka")){
                    return null;
                }
                String[] args = line.split(" ");
                String mPackage = classProperties.getProperty("package");
                classProperties.put("class", mPackage == null ? args[2] : (mPackage + "." + args[2]));
                classProperties.put("class.name", args[2]);
            }
        }
        return classProperties;
    }

    public static String invoke(String java) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(java);
        Method method = clazz.getMethod("createTemplate", null);
        return (String) method.invoke(clazz.newInstance(), null);
    }


    /**
     * 遍历目录，找出所有.java文件的全路径
     * @param dir 遍历的根目录
     */
    public void listDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.getName().endsWith(".java")) {
                    if (f.lastModified() > lastBuildTime) {
                        this.fileList.add(f.getPath());
                    }else {
                        System.out.println("Skip <" + f.getPath() + "> cause not modified");
                    }
                }
                listDir(f);
            }
        }
    }


    public static void checkDir(String dir) throws Exception {
        File savePath = new File(dir);
        if (!savePath.exists() && !savePath.isDirectory()) {
            if (!savePath.mkdirs()) {
                throw new Exception("Fail to make directory <" + dir + ">");
            }
        }
    }

    /**
     * 把字符串写入文件
     * @param text 被写入的字符串
     * @param path 文件的路径
     * @param fileName 文件名
     * @param charset 编码
     * @throws Exception
     */
    public static void writeStringToFile(String text, String path, String fileName, String charset) throws Exception {
        checkDir(path);

        File newFile = new File(path + fileName);

        if (newFile.exists()) {
            System.out.println("File {} is exists! Delete it." + path + fileName);
            if (!newFile.delete()){
                System.out.println("Fail to remove file: {}" + path + fileName);
            }
        }
        FileUtils.writeStringToFile(newFile, text, charset);
//        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), charset)));
//        out.write(text);
//        out.flush();
//        out.close();

        System.out.println("Write file("+fileName+") to " + path);


    }

    /**
     * 读取文本文件中的字符串
     * @param filePath 文件全路径
     * @return 文本中的字符串
     * @throws IOException
     */
    public static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        String text = "";
        int len = -1;
        byte[] buf = new byte[1024];
        while ((len = fileInputStream.read(buf)) != -1) {
            text += new String(buf, 0, len);
        }
        fileInputStream.close();

        return text;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public static void main(String[] args) {
        //PageBuilder builder = new PageBuilder("/Users/baxter/codes/smartx-services/tweestar/src/main/java","/Users/baxter/codes/smartx-services/tweestar/src/main/resources/templates");
        PageBuilder builder = new PageBuilder("/Users/Longinus/Documents/Source/designer/src-gen","/Users/Longinus/Documents/Source/designer/src/main/resources/templates/designer/page");
        try {
            builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
