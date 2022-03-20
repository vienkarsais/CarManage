package com.edgars.carmanage.models;

import com.edgars.carmanage.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Long phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Roles role;
    @OneToMany(mappedBy = "employee")
    private List<Car> cars;

}
