package uz.pdp.pcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.pcmarket.consts.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super_admin").password(passwordEncoder().encode("super_admin")).roles(Role.SUPER_ADMIN).authorities("READ_ALL_PRODUCT", "ADD_PRODUCT", "EDIT_PRODUCT", "DELETE_PRODUCT", "READ_ONE_PRODUCT")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles(Role.MODERATOR).authorities("READ_ALL_PRODUCT", "ADD_PRODUCT", "EDIT_PRODUCT", "READ_ONE_PRODUCT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles(Role.OPERATOR).authorities("READ_ALL_PRODUCT", "ADD_PRODUCT", "READ_ONE_PRODUCT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/product").hasAuthority("READ_ALL_PRODUCT")
                .antMatchers(HttpMethod.POST, "/api/product").hasAuthority("ADD_PRODUCT")
                .antMatchers(HttpMethod.PUT, "/api/product/*").hasAuthority("EDIT_PRODUCT")
                .antMatchers(HttpMethod.DELETE, "/api/product/*").hasAuthority("DELETE_PRODUCT")
                .antMatchers(HttpMethod.GET, "/api/product/*").hasAuthority("READ_ONE_PRODUCT")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
