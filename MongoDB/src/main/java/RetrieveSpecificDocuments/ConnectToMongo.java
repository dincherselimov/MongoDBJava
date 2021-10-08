package RetrieveSpecificDocuments;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Connecting to the mongo database
 */
public class ConnectToMongo {

    public MongoCollection<Document> getColl(String database, String ServerDBCollection){

        //Start new MongoClient
        MongoClient mongoClient = new MongoClient();

        //get the existing database with name "name"
        MongoDatabase db = mongoClient.getDatabase(database);
        db.getName();

        //get the existing collection with name "name"
        return db.getCollection(ServerDBCollection);
    }
}
