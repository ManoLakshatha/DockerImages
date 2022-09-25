package Training.Program.constants;

public final  class Constants {

			//Database string values
	    public static final String uri = "mongodb+srv://Mano:Test123@cluster0.hjj07jz.mongodb.net/?retryWrites=true&w=majority";
	    public static final String database_name = "Training";
	    public static final String users_collection = "Users";
	    public static final String shipments_collection = "Shipments";
	    public static final String devices_collection = "Devices";
	   
	    //password string values
	    public static final String password_length_error ="Password must be at least 8 characters!";
	    public static final String special_case_error ="Password must be at least 1 special characters!";
	    public static final String upper_case_error ="Password must be at least 1 uppercase character!";
	    public static final String lower_case_error ="Password must be at least 1 lowercase  character!";
	    public static final String number_error ="Password must be at least 1  digits!";
	    
	    //username  string values
	    public static final String username_length_error ="Username should have at least 4 characters!";
	    public static final String username_error ="Username should start with an alphabetic character!";
	    public static final String username_case_error ="Username should have alphanumeric characters\n or underscore or hyphen only!";
	    
	    //user validate  string values
	    public static final String email_blank ="email required!";
	    public static final String email_error ="invalid email!";
	    
	   //password mismatch
	    public static final String password_match_error ="Passwords don't match!";
	    public static final String registration_success ="Registration Successful!";
	    public static final String user_not_found ="User not found!";
	    public static final String incorrect_password ="Incorrect Password!";
	    public static final String username_already_taken ="Username Already taken!";
	   
	    //shipment  string values
	    public static final String shipment_number ="Enter Shipment Number!";
	    public static final String container_number ="Enter Container Number!";
	    public static final String description ="Provide a description!";
	    public static final String route ="Select a Route!";
	    public static final String goods ="Select Goods!";
	    public static final String device ="Select Device!";
	    public static final String date ="Enter Date!";
	    public static final String po_numnber ="Enter PO Number!";
	    public static final String delivery_number ="Enter Delivery Number!";
	    public static final String ndc_number ="Enter NDC Number!";
	    public static final String batch_id ="Enter Batch ID!";
	    public static final String serial_number ="Enter Serial Number!";
	    public static final String submitted_successfully ="Submitted successfully!";
	
}
