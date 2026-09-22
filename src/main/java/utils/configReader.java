package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties properties;
    public static void loadProperties() throws IOException {
        properties= new Properties();
        try{
            FileInputStream file= new FileInputStream("D://Notes-For-Interview//projects//POM_testNG//src//main//resources//config.properties");
            properties.load(file);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
