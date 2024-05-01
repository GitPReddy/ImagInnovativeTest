package com.imaginnovate.tax.mapper;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.dto.EmployTaxDTO;
import com.imaginnovate.tax.entity.Employ;

public interface EmployMapper {
    EmployDTO mapEmployToEmployDTO(Employ employ);
    Employ mapEmployDTOToEmploy(EmployDTO employDTO);
    EmployTaxDTO mapEmployToEmployTaxDTO(Employ employ);
}
