package com.edgars.carmanage.security;

import com.edgars.carmanage.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAuthority implements GrantedAuthority {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ManyToOne
    private Employee employee;
    private String authority;
}

