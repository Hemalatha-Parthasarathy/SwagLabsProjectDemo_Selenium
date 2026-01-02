package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //To load the Properties data into the test when called

    private Properties prop;

    public Properties init_prop()  {
        prop = new Properties();
        try {
        FileInputStream inputFile = new FileInputStream("./src/test/resources/config/Config.properties");
        prop.load(inputFile);
        }
        catch (FileNotFoundException e) {
         e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
