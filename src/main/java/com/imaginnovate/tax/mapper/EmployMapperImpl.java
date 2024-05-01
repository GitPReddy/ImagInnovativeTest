package com.imaginnovate.tax.mapper;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.dto.EmployTaxDTO;
import com.imaginnovate.tax.entity.Employ;
import com.imaginnovate.tax.utils.EmployUtil;
import org.springframework.stereotype.Service;

@Service
public class EmployMapperImpl implements EmployMapper{
    @Override
    public EmployDTO mapEmployToEmployDTO(Employ employ) {
        EmployDTO employDTO = new EmployDTO();
        employDTO.setId(employ.getId());
        employDTO.setFirstName(employ.getFirstName());
        employDTO.setLastName(employ.getLastName());
        employDTO.setEmail(employ.getEmail());
        employDTO.setPhoneNumber(employ.getPhoneNumber());
        employDTO.setDoj(employ.getDoj());
        employDTO.setSalary(employ.getSalary());
        return employDTO;
    }

    @Override
    public Employ mapEmployDTOToEmploy(EmployDTO employDTO) {
        Employ employ = new Employ();
        employ.setFirstName(employDTO.getFirstName());
        employ.setLastName(employDTO.getLastName());
        employ.setEmail(employDTO.getEmail());
        employ.setPhoneNumber(employDTO.getPhoneNumber());
        employ.setDoj(employDTO.getDoj());
        employ.setSalary(employDTO.getSalary());
        return employ;
    }

    @Override
    public EmployTaxDTO mapEmployToEmployTaxDTO(Employ employ) {
        EmployTaxDTO taxDTO = new EmployTaxDTO();
        taxDTO.setId(employ.getId());
        taxDTO.setFirstName(employ.getFirstName());
        taxDTO.setLastName(employ.getLastName());
        taxDTO.setYearlySalary(EmployUtil.calculateYearlySalary(employ.getSalary(), employ.getDoj()));
        taxDTO.setTaxAmount(EmployUtil.calculateTaxAmount(taxDTO.getYearlySalary()));
        taxDTO.setCessAmount(EmployUtil.calculateCessAmount(taxDTO.getYearlySalary()));
        return taxDTO;
    }
}
