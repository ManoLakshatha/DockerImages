package Training.Program.services;

import static Training.Program.constants.Constants.database_name;
import static Training.Program.constants.Constants.devices_collection;
import static Training.Program.constants.Constants.shipments_collection;
import static Training.Program.constants.Constants.uri;

import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.function.Function;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Training.Program.interfaces.ShipmentInterface;
import Training.Program.models.Shipments;
import Training.Program.models.Users;
import Training.Program.repositories.ShipmentRepository;

@Service
public class ShipmentServices implements ShipmentInterface {

	 
	    
		@Autowired
		private ShipmentRepository shipmentRepo;
		
	    
		
	    public ShipmentServices(ShipmentRepository shipmentRepo) {
			super();
			this.shipmentRepo = shipmentRepo;
		}



		@Override
		public Shipments saveShipment(Shipments shipment) {
			// TODO Auto-generated method stub
			return shipmentRepo.save(shipment);
		}
		
	    
		

}
