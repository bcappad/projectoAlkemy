package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.UserDetailsModel;
import alkemy.challenge.Challenge.Alkemy.model.UserModel;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;
import alkemy.challenge.Challenge.Alkemy.config.BCryptConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptConfiguration bcryptEnconder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Usuario " + email + " no encontrado."));
        return user.map(UserDetailsModel::new).get();
    }

    // Returns message "User ____ has been registered or registration failed.
    public String registerUserInDB(UserModel registeringUser) {
        String prompt = "El usuario " + registeringUser.getEmail() + " ya se encuentra registrado.";
        try {
            loadUserByUsername(registeringUser.getEmail());
        } catch (UsernameNotFoundException e){
            String encryptedPassword = bcryptEnconder.encode(registeringUser.getPassword());
            registeringUser.setPassword(encryptedPassword);
            userRepository.save(registeringUser);
            prompt = "El usuario " + registeringUser.getEmail() + " ha sido registrado.";
        }
        return prompt;
    }




    //confirm pass y loginUser son los metodos creados para cumplir con el pedido, el resto de metodos son de mi compañero Hector
    public void confirmPass(UserDetails user, String pass){
        if (bcryptEnconder.matches(pass,user.getPassword())){
        }else{
            throw new Error("Invalid Password");
        }
    }

    public UserModel loginUser(UserModel loginUser) throws Exception{
        try{
            //loadUserByUsername es un metodo de mi compañero
            UserDetails userFound = loadUserByUsername(loginUser.getEmail());
            confirmPass(userFound, loginUser.getPassword());
            return loginUser;
        }catch (Exception e){
            throw new Exception("{ok: false}");
        }


    }

}
