package Training.Program.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Training.Program.models.Shipments;


@Repository
public interface ShipmentRepository extends MongoRepository<Shipments,String>{
	
}
