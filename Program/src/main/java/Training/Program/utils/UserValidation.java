package Training.Program.utils;

import java.util.regex.Pattern;
import static Training.Program.utils.Constants.password_length_error;
import static Training.Program.utils.Constants.special_case_error;
import static Training.Program.utils.Constants.upper_case_error;
import static Training.Program.utils.Constants.lower_case_error;
import static Training.Program.utils.Constants.number_error;
import static Training.Program.utils.Constants.username_length_error;
import static Training.Program.utils.Constants.username_error;
import static Training.Program.utils.Constants.username_case_error;
import static Training.Program.utils.Constants.email_blank;
import static Training.Program.utils.Constants.email_error;

public class UserValidation {

	
	  public static boolean validateUsername(String username) throws Exception {
	        if(username.length() < 4)
	            throw new Exception(username_length_error);
	        else if(!Character.isAlphabetic(username.charAt(0)))
	            throw new Exception(username_error);
	        else{
	            for(char c : username.toCharArray()){
	                if(!(Character.isLetterOrDigit(c) || c == '_' || c == '-'))
	                    throw new Exception(username_case_error);
	            }
	            return true;
	        }
	    }
	  
	  

	    public static boolean validateEmail(String email) throws Exception {
	    	  final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    	   
	    	    if(email.isBlank())
		            throw new Exception(email_blank);
		        else if(! EMAIL_REGEX.matcher(email).matches())
		            throw new Exception(email_error);
		        else {
		        	return true;
		        }
		            
		        
	    }
	    
	    
	    
	    
	    public static boolean validatePassword(String password) throws Exception{	    	
	    	
	    	  if(password.length() < 8)
		            throw new Exception(password_length_error);
		        else{
		            int upper = 0, lower = 0, num = 0, special = 0;
		            for(char c : password.toCharArray()){
		                if(Character.isSpaceChar(c) || c == '>' || c == '<' || c == '&' || c == ';')
		                    throw new Exception("Password has invalid characters: " + c);
		                else if(Character.isUpperCase(c))
		                    upper++;
		                else if(Character.isLowerCase(c))
		                    lower++;
		                else if(Character.isDigit(c))
		                    num++;
		                else
		                    special++;

		            }
		            if(upper < 1)
		                throw new Exception(upper_case_error);
		            if(lower < 1)
		                throw new Exception(lower_case_error);
		            if(num < 1)
		                throw new Exception(number_error);
		            if(special < 1)
		                throw new Exception(special_case_error);
		            return true;
		        }	
	    }
	
	
	    public static boolean notEmpty(String s, String msg) throws Exception{
	        if(s.equals(""))
	            throw new Exception(msg);
	        return true;
	    }
	
	    
	    public static String myHash(String s){
	        return Integer.toHexString(s.hashCode());
	    }
}
