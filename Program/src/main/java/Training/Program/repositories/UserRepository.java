package Training.Program.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	void addUser(String username,String email, String password);
	
}
