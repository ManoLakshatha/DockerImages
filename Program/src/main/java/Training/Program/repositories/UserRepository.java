package Training.Program.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Training.Program.models.Users;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {

	
}
