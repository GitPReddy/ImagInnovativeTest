package com.imaginnovate.tax.entity;

import com.imaginnovate.tax.utils.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employ")
public class Employ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeID")
    private Integer id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false)
    private String email;

    @Convert(converter = StringListConverter.class)
    @Column(name = "PhoneNumber", nullable = false)
    private List<String> phoneNumber;

    @Column(name = "DOJ", nullable = false)
    private String doj;

    @Column(name = "Salary", nullable = false)
    private Double salary;

}
