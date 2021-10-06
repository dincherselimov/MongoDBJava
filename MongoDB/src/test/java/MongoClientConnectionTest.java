import MongoDB.MongoClientConnection;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MongoClientConnectionTest {


    @Test
    public void testMongoClientConn() throws IOException {

        MongoClientConnection mongoClientConnection = new MongoClientConnection();
        mongoClientConnection.connectToDB();

        MongoClient mongoClient = new MongoClient();

        assertNotNull(mongoClient);
    }

}
