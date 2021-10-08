package DeleteCollection;

import Config.Config;
import RetrieveSpecificDocuments.ConnectToMongo;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.io.IOException;

/**
 * Deleting Collection from mongo database
 */
public class DeleteCollection {
    public static void main(String[] args) throws IOException {

        DeleteCollection deleteCollection = new DeleteCollection();
        deleteCollection.delete();
    }

        public String delete() throws IOException {

            //Creating a Mongo client
            MongoClient mongo = new MongoClient();
            //Connecting to the database
            MongoDatabase database = mongo.getDatabase(Config.getInstance().getDbName());

            //Retrieving the list of collections
            MongoIterable<String> list = database.listCollectionNames();
            System.out.println("List of collections:");
            for (String name : list) {
                System.out.println(name);
            }
            MongoCollection<Document> collection =  database.getCollection("assayed");
            collection.drop();
            database.listCollectionNames();

            System.out.println("Collection dropped successfully");
            System.out.println("List of collections after the delete operation:");

            for (String name : list) {
                System.out.println(name);
                if(name.contains("ServerDBCollection")){
                    System.out.println("Not Deleted");
                }
                else{
                    System.out.println("Deleted");
                }
                return name;
            }
         return String.valueOf(collection);
        }
}

