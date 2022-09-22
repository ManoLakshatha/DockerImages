package Training.Program.utils;

import java.util.regex.Pattern;

public class UserValidation {

	
	  public static boolean validateUsername(String username) throws Exception {
	        if(username.length() < 4)
	            throw new Exception("Username should have at least 4 characters!");
	        else if(!Character.isAlphabetic(username.charAt(0)))
	            throw new Exception("Username should start with an alphabetic character!");
	        else{
	            for(char c : username.toCharArray()){
	                if(!(Character.isLetterOrDigit(c) || c == '_' || c == '-'))
	                    throw new Exception("Username should have alphanumeric characters\n or underscore or hyphen only!");
	            }
	            return true;
	        }
	    }
	  
	  

	    public static boolean validateEmail(String email) throws Exception {
	    	  final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    	    return EMAIL_REGEX.matcher(email).matches();
	    }
	    
	    
	    
	    
	    public static boolean validatePassword(String password) throws Exception{
	        if(password.length() < 8)
	            throw new Exception("Password should have at least 8 characters!");
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
	            if(upper < 2)
	                throw new Exception("Password should have at least 2 upper-case characters");
	            if(lower < 2)
	                throw new Exception("Password should have at least 2 lower-case characters");
	            if(num < 2)
	                throw new Exception("Password should have at least 2 numeric characters");
	            if(special < 2)
	                throw new Exception("Password should have at least 2 special characters");
	            return true;
	        }
	    }
	
	
	    public static boolean notEmpty(String s, String msg) throws Exception{
	        if(s.equals(""))
	            throw new Exception(msg);
	        return true;
	    }
	
}
