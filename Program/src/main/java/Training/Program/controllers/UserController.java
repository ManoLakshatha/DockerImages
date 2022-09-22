package Training.Program.controllers;

import static Training.Program.services.Mongodb.isUsernameAvailable;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Training.Program.models.Users;
import Training.Program.services.Mongodb;

import static Training.Program.utils.UserValidation.validateUsername;
import static Training.Program.utils.UserValidation.validateEmail;
import static Training.Program.utils.UserValidation.validatePassword;



@Controller
@RequestMapping(path = "")
public class UserController {

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
                throw new Exception("Passwords don't match!");
            
            Mongodb.addUser(user.getUserName(), user.getEmailId(),user.getPassword());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user);
            return "register";
        }
        model.addAttribute("success", "Registration Successful!");
        model.addAttribute("user", new Users());
        return "register";
    }

  
    

}
