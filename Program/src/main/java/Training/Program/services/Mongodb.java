package Training.Program.services;

import java.util.Vector;

import org.bson.Document;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static Training.Program.utils.Constants.uri;
import static Training.Program.utils.Constants.database_name;
import static Training.Program.utils.Constants.users_collection;
import static Training.Program.utils.Constants.shipments_collection;
import static Training.Program.utils.Constants.username_already_taken;
import static Training.Program.utils.Constants.user_not_found;
import static Training.Program.utils.Constants.incorrect_password;
import static Training.Program.utils.Constants.devices_collection;
import static Training.Program.utils.UserValidation.myHash;



public class Mongodb {

	

	    private static final MongoDatabase database;


	    static {
	        MongoClient mongoClient = MongoClients.create(uri);
	        database = mongoClient.getDatabase(database_name);
	    }

	    private static final MongoCollection<Document> users = database.getCollection(users_collection);
	    private static final MongoCollection<Document> shipments = database.getCollection(shipments_collection);
	    private static final MongoCollection<Document> devices = database.getCollection(devices_collection);

	  

	    public static void addUser(String username,String email, String password){
	        Document document = new Document();
	        document.append("_id", username);
	        document.append("email", email);
	        document.append("Password", myHash(password));
	        users.insertOne(document);
	    }

	    public static void addShipment(String username, String si_no,String container_no, String desc, String route,String goods,String device,
	             String date, String po_no,String delivery_no,String ndc_no,String batch_id,String serial_no){
	        Document document = new Document();
	        document.append("username", username);
	        document.append("invoiceNumber", si_no);
	        document.append("containerNumber",container_no);
	        document.append("shipmentDescription", desc);
	        document.append("routeDetail", route);
	        document.append("goodsType", goods);
	        document.append("device", device);
	        document.append("expectedDeliverydate", date);
	        document.append("poNumber", po_no);
	        document.append("deliveryNumber", delivery_no);
	        document.append("NdcNumber", ndc_no);
	        document.append("batchId", batch_id);
	        document.append("serialNumber", serial_no);
	        shipments.insertOne(document);
	    }

	    public static boolean isUsernameAvailable(String username) throws Exception {
	        for (Document document : users.find(new Document("_id", username))) {
	            if (document.get("_id").equals(username))
	                throw new Exception(username_already_taken);
	        }
	        return true;
	    }

	    public static boolean authenticateUser(String username, String password) throws Exception {
	        for (Document document : users.find(new Document("_id", username))) {
	            if (document.get("Password").equals(myHash(password)))
	                return true;
	            else
	                throw new Exception(incorrect_password);
	        }
	        throw new Exception(user_not_found);
	    }

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
	        for (Document document : Mongodb.devices.find())
	            devices.add(document);
	        return devices;
	    }

	}