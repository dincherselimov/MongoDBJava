import Config.Config;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class MongoClientConnectionDBNameTest {

    String expectedDBNameP = "ServerDB";
    String expectedDBNameN = "DBServer";

    @Test
    @DisplayName("Testing DataBase name (positive)")
    public void itShouldTestDBNameP() throws IOException {
        Config config = new Config();

        String dbname = config.getDbName();

        assertEquals(expectedDBNameP,dbname);
    }


    @Test
    @DisplayName("Testing DataBase name (negative)")
    public void itShouldTestDBNameN() throws IOException {
        Config config = new Config();

        String dbname = config.getDbName();

        assertEquals(expectedDBNameN,dbname);
    }


}
