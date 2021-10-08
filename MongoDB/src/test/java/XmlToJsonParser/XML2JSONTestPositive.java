package XmlToJsonParser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class XML2JSONTestPositive {

    XML2JSON xml2JSON;

    @BeforeEach
    void setUp() throws IOException {
        xml2JSON = new XML2JSON();
    }

    /**
     * Testing if the expected json is equal to actual json file
     * @throws IOException
     */
    @Test
    void testParsedFilePositive() throws IOException {

        String s = String.valueOf(xml2JSON.parse(new File("src/main/java/XMLFiles/node.xml")));

        String expected = "{\"to\": \"Tove\", \"from\": \"Jani\", \"heading\": \"Reminder\", \"body\": \"Don't forget me this weekend!\"}";

        assertEquals(expected,s);

        System.out.println("Parsed file is the same a expected one");
    }


    /**
     * Testing if the expected json is equal to actual json file
     * @throws IOException
     */
    @Test
    void testParsedFileNegative() throws IOException {

        String s = String.valueOf(xml2JSON.parse(new File("src/main/java/XMLFiles/node.xml")));

        String expected = "{\"note\": {\"heading\": \"Reminder\", \"from\": \"Jani\", \"to\": \"Tove\", \"body\": \"Don't forget me this weekend!\"}}";

        assertEquals(expected,s);
        System.out.println("Parsed file does not match expected");

    }


    /**
     * Testing if the file contains something
     * @throws IOException
     */
    @Test
    void notNull() throws IOException {
        String json =  String.valueOf(xml2JSON.parse(new File("src/main/java/XMLFiles/node.xml")));
        assertNotNull(json);
    }
}