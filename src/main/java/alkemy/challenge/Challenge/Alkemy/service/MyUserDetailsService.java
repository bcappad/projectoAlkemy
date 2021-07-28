package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.UserModel;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;
import alkemy.challenge.Challenge.Alkemy.config.BCryptConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Usuario " + email + " no encontrado."));
        return user.map(
    }

    // Returns message "User ____ has been registered.
    public String registerUserInDB(UserModel registeringUser) {
        try {
            loadUserByUsername(registeringUser.getEmail());
        }
        String encryptedPassword = bcryptEnconder.encode(registeringUser.getPassword());
        registeringUser.setPassword(encryptedPassword);
        userRepository.save(registeringUser);
        return ("El usuario " + registeringUser.getEmail() + " ha sido registrado.");
    }
}
