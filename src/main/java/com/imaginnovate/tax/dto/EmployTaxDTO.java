package com.imaginnovate.tax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployTaxDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Double yearlySalary;
    private Double taxAmount;
    private Double cessAmount;

}
