package alkemy.challenge.Challenge.Alkemy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptConfiguration extends BCryptPasswordEncoder {

    public BCryptPasswordEncoder BCryptConfiguration(int strength) {
        return new BCryptPasswordEncoder(10);
    }

}
