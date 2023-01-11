package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    Properties properties;
    public final  String  path  ="/Users/vanchinathanac/Desktop/SeleniumBBC/src/test/java/Common/Config.properties";
    public ConfigFile() throws IOException {
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        properties=new Properties();
        properties.load(inputStream);

    }
    public String url()
    {
        return properties.getProperty("url");
    }
}
