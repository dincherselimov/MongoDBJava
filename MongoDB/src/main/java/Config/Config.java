package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Getting values from config.properties
 */
public class Config {

    private static Config instance = null;
    private final String dbName;
    private final String collectionName;
    private final String xmlFilePath;


    //Define the config.properties file path
    FileInputStream FIS;
    {
        try {
            FIS = new FileInputStream("src/main/java/ConfigFiles/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Properties prop;

    //Loading the config.properties file
    public Config() throws IOException {
        prop = new Properties();
        prop.load(FIS);
        FIS.close();
        //reading the element's content from config.properties
        dbName = new String(prop.getProperty("dbName"));
        collectionName = new String(prop.getProperty("collectionName"));
        xmlFilePath = new String(prop.getProperty("xmlFilePath"));

    }

    //Using Singleton method
    public static Config getInstance() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }


    public String getDbName(){return this.dbName;}
    public String getCollectionName(){return this.collectionName;}
    public String getXmlFilePath(){return this.xmlFilePath;}
}
