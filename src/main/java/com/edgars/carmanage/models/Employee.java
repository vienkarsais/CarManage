package com.edgars.carmanage.models;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.validators.constraints.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Full name is mandatory")
    private String fullName;
    @NotBlank(message = "Username is mandatory")
    private String username;
    private String password;
    @Email
    private String email;
    //@PhoneNumberConstraint
    private Long phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Roles role;
    @OneToMany(mappedBy = "employee")
    private List<Car> cars;
}
