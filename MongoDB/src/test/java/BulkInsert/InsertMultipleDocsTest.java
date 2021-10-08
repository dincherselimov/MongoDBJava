package BulkInsert;

import RetrieveSpecificDocuments.ConnectToMongo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InsertMultipleDocsTest {

    InsertMultipleDocs insert;

    @BeforeEach
    void setUp() {
        insert = new InsertMultipleDocs();

    }

    @Test
    void insertManyDocs() throws IOException {

      long ins = insert.insertManyDocs();

      int real = (int) ins ;

      //expected_size = what is the count of documents after insertManyDocuments
      int expected_size = 3;

        assertEquals(expected_size,real);
        System.out.println("\n");
    }

    @Test
    void testInsertManyDocs() {
    }
}