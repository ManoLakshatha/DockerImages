package Training.Program.services;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



import static Training.Program.constants.Constants.database_name;
import static Training.Program.constants.Constants.devices_collection;

import static Training.Program.constants.Constants.uri;

import java.util.Vector;

import org.bson.Document;
import com.mongodb.client.MongoClients;



@Service
public class DeviceService {
    

	  private static final MongoDatabase database;


	    static {
	        MongoClient mongoClient = MongoClients.create(uri);
	        database = mongoClient.getDatabase(database_name);
	    }
	    
	    
	    private static final MongoCollection<Document> devices = database.getCollection(devices_collection);
	
	
	    public static Vector<String> getDeviceIDs(){
	        Vector<String> devices = new Vector<>();
	        devices.add("00001");
	        devices.add("00002");
	        devices.add("00003");
	        devices.add("00004");
	        return devices;
	    }

	    public static Vector<Document> getDevices() {
	        Vector<Document> devices = new Vector<>();
	        for (Document document : DeviceService.devices.find())
	            devices.add(document);
	        return devices;
	    }
}
