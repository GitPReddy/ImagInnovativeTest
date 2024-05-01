package com.imaginnovate.tax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNumber;
    private String doj;
    private Double salary;

}
