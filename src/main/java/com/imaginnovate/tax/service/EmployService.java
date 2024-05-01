package com.imaginnovate.tax.service;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.dto.EmployTaxDTO;

import java.util.List;

public interface EmployService {
    EmployDTO saveEmploy(EmployDTO employDTO);

    List<EmployTaxDTO> getEmployeesTax();
}
