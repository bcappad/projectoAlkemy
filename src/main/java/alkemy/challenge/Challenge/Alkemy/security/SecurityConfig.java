package alkemy.challenge.Challenge.Alkemy.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/auth/me").hasAnyRole("USER")
                .antMatchers(HttpMethod.POST,"/auth/login","/auth/register").permitAll()
                .antMatchers(HttpMethod.GET,"/users").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/users/:id").hasAnyRole("USER")
                .antMatchers(HttpMethod.PATCH,"/users/:id").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET,"/categories").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/categories/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/categories").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/categories/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/categories/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/news").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/news/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/news/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/news/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/activities ").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/activities/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/slides").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/slides/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/slides").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/slides/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/slides/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/contacts").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/contacts").hasAnyRole("USER")
                .antMatchers(HttpMethod.POST,"/testimonials").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/testimonials/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/testimonials/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/members").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/members").hasAnyRole("USER")
                .antMatchers(HttpMethod.DELETE,"/members/:id").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/members/:id").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET,"/comments").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/comments").hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT,"/comments/:id").hasAnyRole("USER")
                .antMatchers(HttpMethod.DELETE,"/comments/:id").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET,"/posts/:id/comments").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET,"/organization/public").hasAnyRole("USER")
                .antMatchers(HttpMethod.POST,"/organization/public").hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }
}
