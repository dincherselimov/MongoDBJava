package MongoDB;

import XmlToJsonParser.XML2JSON;
import com.mongodb.*;

import java.io.IOException;

public class MongoClientConnection {

    public static void main(String[] args) throws IOException {
        MongoClientConnection cn = new MongoClientConnection();
        cn.connectToDB();
    }

    public void connectToDB() throws IOException {

        //Start new MongoClient
        MongoClient mongoClient = new MongoClient();
        //get the existing database with name "name"
        DB database = mongoClient.getDB("ServerDB");
        database.getName();

        //get the existing collection with name "name"
        DBCollection ServerDBCollection = database.getCollection("ServerDBCollection");

        //create an instance of class XML2JSON
        XML2JSON xml2JSON = new XML2JSON();

        //push the parsed xml into the mongodb database
        ServerDBCollection.insert((DBObject) xml2JSON.parse1());
    }
}
