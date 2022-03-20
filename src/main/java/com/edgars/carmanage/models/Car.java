package com.edgars.carmanage.models;

import com.edgars.carmanage.enums.FuelType;
import com.edgars.carmanage.enums.Gearbox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String maker;
    private String model;
    private LocalDate yearMade;
    private FuelType fuelType;
    private Gearbox gearbox;
    private Integer seats;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;




}
