package Training.Program.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository {
	
	void addShipment(String username, String si_no,String container_no, String desc, String route,String goods,String device,
            String date, String po_no,String delivery_no,String ndc_no,String batch_id,String serial_no);
}
