package com.edgars.carmanage.models;

import com.edgars.carmanage.enums.FuelType;
import com.edgars.carmanage.enums.Gearbox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;
    @Transient
    private Long employeeId;

    private String maker;
    private String model;
    private Integer yearMade;
    private FuelType fuelType;
    private Gearbox gearbox;
    private Integer seats;
    private String imageUrl;

    @Override
    public String toString() {
        return "Car{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", yearMade=" + yearMade +
                '}';
    }
}
