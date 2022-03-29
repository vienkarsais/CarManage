package com.edgars.carmanage.security;

import com.edgars.carmanage.repositories.EmployeeRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserDetailServiceImpl implements UserDetailsService  {

    private EmployeeRepo employeeRepo;

    @Autowired
    public UserDetailServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = new UserWrapper(employeeRepo.getEmployeeByUsername(username));
        return userDetails;
    }
}
