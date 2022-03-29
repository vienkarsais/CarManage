package com.edgars.carmanage.security;

import com.edgars.carmanage.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper implements UserDetails {
    private Employee employee;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<EmployeeAuthority> employeeAuthorities = new ArrayList<>();
        EmployeeAuthority employeeAuthority = new EmployeeAuthority();
        employeeAuthority.setAuthority(this.employee.getRole().getKey());
        employeeAuthority.setEmployee(this.employee);
        employeeAuthorities.add(employeeAuthority);
        return employeeAuthorities;
    }

    @Override
    public String getPassword() {
        return this.employee.getPassword();
    }

    @Override
    public String getUsername() {
        return this.employee.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
