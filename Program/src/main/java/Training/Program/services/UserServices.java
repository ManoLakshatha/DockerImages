package Training.Program.services;



import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Training.Program.interfaces.UserServicesInterface;
import Training.Program.models.Users;
import Training.Program.repositories.UserRepository;
import static Training.Program.constants.Constants.database_name;
import static Training.Program.constants.Constants.incorrect_password;
import static Training.Program.constants.Constants.uri;
import static Training.Program.constants.Constants.user_not_found;
import static Training.Program.constants.Constants.username_already_taken;
import static Training.Program.constants.Constants.users_collection;
import static Training.Program.utils.FormValidation.myHash;


@Service
public class UserServices implements UserServicesInterface {

	
		@Autowired
		private UserRepository userRepo;
		
		
		

		public UserServices(UserRepository userRepo) {
			super();
			this.userRepo = userRepo;
		}




		@Override
		public Users saveUser(Users users) {
			
			
			Users user= new Users(users.getUserName(),users.getEmailId(),myHash(users.getPassword()));
			return userRepo.save(user);
		}


	}