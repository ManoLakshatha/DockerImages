package Training.Program.controllers;

import static Training.Program.constants.Constants.password_match_error;
import static Training.Program.constants.Constants.registration_success;
import static Training.Program.services.UserServices.isUsernameAvailable;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Training.Program.models.Users;
import Training.Program.services.UserServices;

import static Training.Program.utils.FormValidation.validateUsername;
import static Training.Program.utils.FormValidation.validateEmail;
import static Training.Program.utils.FormValidation.validatePassword;



@Controller
public class UserController {

	
	
	private UserServices mongo;
	
	
	
    public UserController(UserServices mongo) {
		super();
		this.mongo = mongo;
	}

	@GetMapping(path = "register")
    public String viewRegistrationPage(Model model){
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping(path = "register")
    public String registerUser(@ModelAttribute Users user, Model model){
        try{
        	
            validateUsername(user.getUserName());
            
            isUsernameAvailable(user.getUserName());
            validateEmail(user.getEmailId());
            
            validatePassword(user.getPassword());
            
            if(!user.confirmPassword())
                throw new Exception(password_match_error);
            
            mongo.addUser(user.getUserName(), user.getEmailId(),user.getPassword());
            
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user);
            return "register";
        }
        model.addAttribute("success", registration_success);
        model.addAttribute("user", new Users());
        return "register";
    }

  
    

}
