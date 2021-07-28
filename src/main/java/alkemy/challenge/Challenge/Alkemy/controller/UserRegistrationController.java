package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.UserModel;
import alkemy.challenge.Challenge.Alkemy.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserRegistrationController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping (path = "auth/register")
    public String registerUser(@RequestBody UserModel registeringUser){
        return myUserDetailsService.registerUserInDB(registeringUser);
    }
}
