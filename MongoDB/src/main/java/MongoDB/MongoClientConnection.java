package MongoDB;

import Config.Config;
import XmlToJsonParser.XML2JSON;
import com.mongodb.*;
import java.io.File;
import java.io.IOException;

/**
 * Connecting to mongodb and inserting xml files parsed into json format
 */
public class MongoClientConnection {


    public static void main(String[] args) throws IOException {
        MongoClientConnection mcn = new MongoClientConnection();
        mcn.insertIntoDB();

    }

    public DBCollection mongoConnect(String db, String coll) throws IOException {
        //Start new MongoClient
        MongoClient mongoClient = new MongoClient();

        //get the existing database with name "name"
        DB database = mongoClient.getDB(String.valueOf(db));
        database.getName();

        return database.getCollection(String.valueOf(coll));
    }

    /**
     * Connect to mongodb
     * Parse xml file to json format
     * Insert the json file into mongodb
     */
        public void insertIntoDB() throws IOException {

        //get the existing collection with name "name"
         DBCollection ServerDBCollection = mongoConnect("ServerDB","ServerDBCollection");

        //create an instance of class XML2JSON
        XML2JSON xml2JSON = new XML2JSON();

        //push the parsed xml into the mongodb database
        ServerDBCollection.insert((xml2JSON.parse(new File(Config.getInstance().getXmlFilePath()))));

        //Retrieving the all the documents in the collection
        DBCursor iterDoc = ServerDBCollection.find();
        for (DBObject dbObject : iterDoc) {
            if(dbObject!= null){
                System.out.println(dbObject);
            }

        }
    }
}
