package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.AuthenticationRequest;
import alkemy.challenge.Challenge.Alkemy.model.AuthenticationResponse;
import alkemy.challenge.Challenge.Alkemy.model.UserModel;
import alkemy.challenge.Challenge.Alkemy.service.JwtService;
import alkemy.challenge.Challenge.Alkemy.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserRegistrationController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping (path = "auth/register")
    public String registerUser(@RequestBody UserModel registeringUser){
        return myUserDetailsService.registerUserInDB(registeringUser);
    }




    //metodo creado para cumplir los requisitos, registerUser es de mi compañero Hector
    //paso a comentar este login por que se sustituira por el createToken
    /*
    @PostMapping(path = "auth/login")
    public UserModel login(@RequestBody UserModel logginUser) throws Exception {
        return myUserDetailsService.loginUser(logginUser);
    }
    */


    //modificado para que el login devuelva un token
    @PostMapping("auth/login")
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        String token = jwtService.createToken(userDetails);
        return new AuthenticationResponse(token);
    }


}
