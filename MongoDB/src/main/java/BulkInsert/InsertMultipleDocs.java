package BulkInsert;

import Config.Config;
import RetrieveSpecificDocuments.ConnectToMongo;
import RetrieveSpecificDocuments.RetrieveInfo;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * Inserting multiple documents at once to the collection
 */
public class InsertMultipleDocs {

    public static void main(String[] args) throws IOException {
        InsertMultipleDocs insert = new InsertMultipleDocs();
        insert.insertManyDocs();
    }

    public long insertManyDocs() throws IOException {

        //Instantiate ConnectToMongo class
        //Connect to the database
        ConnectToMongo connectToMongo = new ConnectToMongo();

        //Creating a collection object
        MongoCollection<Document> collection = connectToMongo.getColl(Config.getInstance().getDbName(),
                Config.getInstance().getCollectionName());

        long coll = collection.countDocuments();
        System.out.println("Count of documents before insert " + coll);

        Document document1 = new Document("to", "Tove").append("from","Dini").append("heading","Reminder");
        Document document2 = new Document("to", "ASDasd").append("from","dasds").append("heading","aaa");
        Document document3 = new Document("to", "AZ").append("from","gfggf").append("heading","dd");

        //Inserting the created documents
        List<Document> list = new ArrayList<Document>();
        list.add(document1);
        list.add(document2);
        list.add(document3);
        collection.insertMany(list);
        long coll1 = coll + list.size();
        System.out.println("Count of documents after insert " + coll1);

        if (coll1 != coll){
            System.out.println("Inserting many documents successfully");
        }
        return coll1;
    }

}






//        //Creating a MongoDB client
//        MongoClient mongo = new MongoClient();
//
//        //Connecting to the database
//        MongoDatabase database = mongo.getDatabase("ServerDB");
