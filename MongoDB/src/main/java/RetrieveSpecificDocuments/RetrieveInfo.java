package RetrieveSpecificDocuments;

import Config.Config;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.io.IOException;
import java.util.function.Consumer;
import static com.mongodb.client.model.Filters.eq;


/**
 * Retrieving specific documents from the collection of the database
 */
public class RetrieveInfo {

    public static void main(String[] args) throws IOException {

        RetrieveInfo info = new RetrieveInfo();
        info.RetrieveSpecificInfo();
    }

    /**
     * Establish a connection
     * Get the DataBase name
     * Get the Collection Name
     * Retrieve specific documents from the collection
     * @return
     */
    public String RetrieveSpecificInfo() throws IOException {
        ConnectToMongo connectToMongo = new ConnectToMongo();

        MongoCollection<Document> ServerDBCollection = connectToMongo.getColl(Config.getInstance().getDbName(),
                Config.getInstance().getCollectionName());

        //Retrieving specific documents from a collection by applying filter criteria.
        //pass a JSON document containing the criteria you are searching for to the find method.
        FindIterable<Document> findIterable = ServerDBCollection.find(eq("to", "AZ"));

        //Print the results of the iteration
        Consumer<Document> printConsumer = new Consumer<>() {
            public void accept(final Document doc) {
                System.out.println(doc.toJson());
            }
        };

        //Iterate the cursor for documents, passing the printConsumer as a parameter.
        findIterable.forEach(printConsumer);
        return String.valueOf(printConsumer);
    }
}
