package XmlToJsonParser;

import Config.Config;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.*;

/**
 * Parsing XML files into JSONObject
 */
public class XML2JSON {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public DBObject parse(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        int ptr = 0;
        StringBuilder builder = new StringBuilder();
        while ((ptr = br.read()) != -1) {
            builder.append((char) ptr);
        }
        String xml = builder.toString();

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xml.getBytes());
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(node);
        out.println(json);
        return (DBObject) JSON.parse(String.valueOf(json));
    }


    /**
     * Read the content of xml file
     * Parse xml to json
     * Parse json to JSONObject
     * @return
     */
    public DBObject parse1() {

        try {
            //Read the content of xml file(path to xml file)
            File file = new File("src/main/java/XMLFiles/node.xml");
            BufferedReader br = new BufferedReader(new FileReader(file));
            int ptr = 0;
            StringBuilder builder = new StringBuilder();
            while ((ptr = br.read()) != -1) {
                builder.append((char) ptr);
            }
            String xml = builder.toString();

            //parse the xml to JSONObject
            JSONObject xmlJSONObj = XML.toJSONObject(xml);

            //Print the parsed xml in the console
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);

            return (DBObject) JSON.parse(String.valueOf(xmlJSONObj));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.parse1();
    }
}
