package Training.Program.services;



import org.bson.Document;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import Training.Program.repositories.UserRepository;
import static Training.Program.constants.Constants.database_name;
import static Training.Program.constants.Constants.incorrect_password;
import static Training.Program.constants.Constants.uri;
import static Training.Program.constants.Constants.user_not_found;
import static Training.Program.constants.Constants.username_already_taken;
import static Training.Program.constants.Constants.users_collection;
import static Training.Program.utils.FormValidation.myHash;


@Service
public class UserServices implements UserRepository {

	

	    private static final MongoDatabase database;


	    static {
	        MongoClient mongoClient = MongoClients.create(uri);
	        database = mongoClient.getDatabase(database_name);
	    }

	    private static final MongoCollection<Document> users = database.getCollection(users_collection);

	  

	    public void addUser(String username,String email, String password){
	        Document document = new Document();
	        document.append("_id", username);
	        document.append("email", email);
	        document.append("Password", myHash(password));
	        users.insertOne(document);
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


	}