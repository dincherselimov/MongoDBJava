import Config.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.IOException;

/**
 * Testing each method for mongodb connection, and crud operations
 */
public class MongoClientConnectionDBCollectionTest {

    @ParameterizedTest
    @CsvSource({
            "ServerDBCollection,TRUE",
            "CollectionServerDB, FALSE",
            "serverdbcollection, BORDER"
    })

    void ittestcollection(String CollectionDB, String expected) throws IOException {

        Config underTest = new Config();

        String isValid = underTest.getDbName();

        Assertions.assertEquals(isValid,CollectionDB);
    }

    //====================================================================================================================

    String expectedDBCollectionP = "ServerDBCollection";
    String expectedDBCollectionN = "CollectionDBServer";

    @Test
    @DisplayName("Testing DataBase collection (positive)")
    public void itShouldTestDBCollectionP() throws IOException {
        Config config = new Config();

        String dbname = config.getCollectionName();

        Assertions.assertEquals(expectedDBCollectionP,dbname);

    }

    @Test
    @DisplayName("Testing DataBase collection (negative)")
    public void itShouldTestDBCollectionN() throws IOException {
        Config config = new Config();

        String dbname = config.getDbName();

        Assertions.assertEquals(expectedDBCollectionN,dbname);
    }
}
