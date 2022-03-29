package com.edgars.carmanage.security;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@Data
@AllArgsConstructor
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    private EmployeeRepo employeeRepo;
    private UserDetailServiceImpl userDetailService;
    private PasswordEncoder encoder;

    @Override
    protected void configure (HttpSecurity security) throws Exception{
        security.
                httpBasic().
                and().formLogin().and().logout()
                .and()
                .authorizeRequests().antMatchers("/car/**").authenticated()
                .and()
                .authorizeRequests().antMatchers("/employee/managerList")
                .hasAuthority(Roles.ADMIN.getKey())
                .and()
                //.authorizeRequests().antMatchers("/").hasAnyAuthority(Authorities.SHOW_MAIN_PAGE.getKey(), UserRoles.ADMIN.getAuthority()).and().
                //authorizeRequests().antMatchers("/rest/showAnimals").authenticated().
                //and().
                //authorizeRequests().antMatchers(HttpMethod.POST, "/postAnimal").authenticated().
                //and().authorizeRequests().antMatchers(HttpMethod.POST, "registerUser").not().authenticated()
                //.and().
                .authorizeRequests().antMatchers("**").permitAll().
                and().
                csrf().disable();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
