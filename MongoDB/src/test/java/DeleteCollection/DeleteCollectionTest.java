package DeleteCollection;

import RetrieveSpecificDocuments.ConnectToMongo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCollectionTest {

    DeleteCollection deleteCollection;

    @BeforeEach
    void setUp() {
        deleteCollection = new DeleteCollection();
    }

    @Test
    void delete() throws IOException {
       String d =  deleteCollection.delete();

       assertEquals("",d);

    }
}