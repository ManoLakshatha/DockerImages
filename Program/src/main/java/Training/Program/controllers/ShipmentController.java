package Training.Program.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static Training.Program.constants.Constants.batch_id;
import static Training.Program.constants.Constants.container_number;
import static Training.Program.constants.Constants.date;
import static Training.Program.constants.Constants.delivery_number;
import static Training.Program.constants.Constants.description;
import static Training.Program.constants.Constants.device;
import static Training.Program.constants.Constants.goods;
import static Training.Program.constants.Constants.ndc_number;
import static Training.Program.constants.Constants.po_numnber;
import static Training.Program.constants.Constants.route;
import static Training.Program.constants.Constants.serial_number;
import static Training.Program.constants.Constants.shipment_number;
import static Training.Program.constants.Constants.submitted_successfully;
import static Training.Program.utils.FormValidation.notEmpty;

import Training.Program.models.Shipments;
import Training.Program.models.Users;
import Training.Program.services.Mongodb;



@Controller
@RequestMapping(path = "/api")
public class ShipmentController {

    private Users user = null;

    @GetMapping(path = "login")
    public String viewLoginPage(Model model){
        if(this.user != null)
            return "redirect:/api/dashboard";
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping(path = "login")
    public String signInUser(@ModelAttribute Users user, Model model){
        if(this.user != null)
            return "redirect:/api/dashboard";
        try{
            Mongodb.authenticateUser(user.getUserName(), user.getPassword());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", new Users());
            return "login";
        }
        this.user = user;
        return "redirect:/api/dashboard";
    }
    
    
  

    @GetMapping(path = "dashboard")
    public String viewDashboard(Model model){
        if(this.user == null)
            return "redirect:/api/login";
        else
            model.addAttribute("user", this.user);
            return "dashboard";
    }

    @GetMapping(path = "logout")
    public String logoutUser(){
        if(this.user != null)
            this.user = null;
        return "redirect:/api/login";
    }

    @GetMapping(path="devices")
    public String getDevicesDataStream(Model model){
        if(this.user == null)
            return "redirect:/api/login";
        else{
            model.addAttribute("devices", Mongodb.getDevices());
            return "deviceDataStream";
        }
    }

    @GetMapping(path = "createShipment")
    public String createShipmentPage(Model model){
        if(this.user == null)
            return "redirect:/api/login";
        else{
            model.addAttribute("shipment", new Shipments());
            model.addAttribute("devices", Mongodb.getDeviceIDs());
            return "createShipment";
        }
    }

    @PostMapping(path = "createShipment")
    public String submitShipmentForm(@ModelAttribute Shipments shipment, Model model){
        if(this.user == null)
            return "redirect:/api/login";
        else{
            model.addAttribute("devices", Mongodb.getDeviceIDs());
            try {
            	notEmpty(shipment.getInvoiceNumber(), shipment_number);
                notEmpty(shipment.getContainerNumber(),  container_number);
                notEmpty(shipment.getShipmentDescription(), description);
                notEmpty(shipment.getRouteDetail(), route );
                notEmpty(shipment.getGoodsType(), goods );
                notEmpty(shipment.getDevice(), device);
                notEmpty(shipment.getExpectedDeliverydate(), date);
                notEmpty(shipment.getPoNumber(), po_numnber);
                notEmpty(shipment.getDeliveryNumber(), delivery_number );
                notEmpty(shipment.getNdcNumber(),ndc_number );
                notEmpty(shipment.getBatchId(), batch_id);
                notEmpty(shipment.getSerialNumber(),serial_number);
                
                Mongodb.addShipment(this.user.getUserName(), shipment.getInvoiceNumber(), shipment.getContainerNumber(),
                        shipment.getShipmentDescription(), shipment.getRouteDetail(), shipment.getGoodsType(), shipment.getDevice(), shipment.getExpectedDeliverydate(), shipment.getPoNumber(), shipment.getDeliveryNumber(),
                        shipment.getNdcNumber(), shipment.getBatchId(), shipment.getSerialNumber());  
               
            }catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                model.addAttribute("shipment", shipment);
                return "createShipment";
            }
            model.addAttribute("success", submitted_successfully);
            model.addAttribute("shipment", new Shipments());
            return "createShipment";
        }
    }

  

   

}