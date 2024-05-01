package com.imaginnovate.tax.service;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.dto.EmployTaxDTO;
import com.imaginnovate.tax.entity.Employ;
import com.imaginnovate.tax.exception.EmployAlreadyExistsException;
import com.imaginnovate.tax.mapper.EmployMapper;
import com.imaginnovate.tax.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployServiceImpl implements EmployService{

    @Autowired
    EmployRepository employRepository;

    @Autowired
    EmployMapper employMapper;

    public EmployServiceImpl() {
    }

    @Override
    public EmployDTO saveEmploy(EmployDTO employDTO) {
        var existsEmployId = employRepository.findById(employDTO.getId()).orElse(null);
        if(existsEmployId != null){
            throw new EmployAlreadyExistsException("Employ already exists in database with given ID "+employDTO.getId());
        }
        Employ employ = employRepository.save(employMapper.mapEmployDTOToEmploy(employDTO));
        return employMapper.mapEmployToEmployDTO(employ);
    }

    @Override
    public List<EmployTaxDTO> getEmployeesTax() {

        List<Employ> employList = employRepository.findAll();
        return employList
                .stream()
                .map(employ -> employMapper.mapEmployToEmployTaxDTO(employ))
                .collect(Collectors.toList());

    }


}
