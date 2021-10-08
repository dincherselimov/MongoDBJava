package RetrieveSpecificDocuments;

import Config.Config;
import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RetrieveInfoTest {
        ConnectToMongo info;

        @BeforeEach
        void setUp() {
            info = new ConnectToMongo();
        }

    /**
     * Testing the database name
     * @throws IOException
     */
    @Test
    void testDBNamePositive() throws IOException {

        MongoCollection<Document> mn = info.getColl(Config.getInstance().getDbName(),Config.getInstance().getCollectionName());
        MongoNamespace ns = mn.getNamespace();
        assertEquals("ServerDB",ns.getDatabaseName());

        System.out.println("Test passed successfully");

    }
    @Test
    void testDBNameNegative() throws IOException {

        MongoCollection<Document> mn = info.getColl(Config.getInstance().getDbName(),Config.getInstance().getCollectionName());
        MongoNamespace ns = mn.getNamespace();

        String db = "SMTH Wrong";
        assertEquals(db,ns.getDatabaseName());

        System.out.println("Wrong database name and collection name");
    }

    @Test
    void testDBNameBorder() throws IOException {

        MongoCollection<Document> mn = info.getColl(Config.getInstance().getDbName(),Config.getInstance().getCollectionName());
        MongoNamespace ns = mn.getNamespace();

        String db = "";
        assertEquals(db,ns.getDatabaseName());
        System.out.println("DB field should not be empty");
    }


    @Test
    void testCollNamePositive() throws IOException {

        MongoCollection<Document> mn = info.getColl(Config.getInstance().getDbName(),Config.getInstance().getCollectionName());
        MongoNamespace ns = mn.getNamespace();

        String db = "ServerDBCollection";
        assertEquals(db,ns.getCollectionName());
        System.out.println("Test passed successfully");
    }

    @Test
    void testCollNameNegative() throws IOException {

        MongoCollection<Document> mn = info.getColl(Config.getInstance().getDbName(),Config.getInstance().getCollectionName());
        MongoNamespace ns = mn.getNamespace();

        String db = "WrongDbName";

        assertEquals(db,ns.getCollectionName());
        System.out.println(db);
    }

    @Test
    void testCollNameBorder() throws IOException {

        MongoCollection<Document> mn = info.getColl(Config.getInstance().getDbName(),Config.getInstance().getCollectionName());
        MongoNamespace ns = mn.getNamespace();

        String db = "";
        assertEquals(db,ns.getCollectionName());
        System.out.println(db);
    }
}
