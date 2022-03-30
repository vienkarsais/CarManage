package com.edgars.carmanage.security;

import com.edgars.carmanage.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@Data
@AllArgsConstructor
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailServiceImpl userDetailService;

    @Override
    protected void configure (HttpSecurity security) throws Exception{
        security.httpBasic()
            .and().formLogin().defaultSuccessUrl("/main")
            .and().authorizeRequests()
                .antMatchers("/car/**", "/main/**", "/employee/allEmployees").authenticated()
                .antMatchers("/employee/**").hasAnyAuthority(Roles.ADMIN.getKey(), Roles.MANAGER.getKey())
                .antMatchers("/login", "/styles/**", "/error").permitAll()
            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
            .and().csrf().disable();
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
