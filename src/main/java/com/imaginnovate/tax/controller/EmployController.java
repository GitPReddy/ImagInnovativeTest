package com.imaginnovate.tax.controller;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.dto.EmployTaxDTO;
import com.imaginnovate.tax.exception.EmployNotValidException;
import com.imaginnovate.tax.service.EmployService;
import com.imaginnovate.tax.utils.EmployUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employ")
public class EmployController {

    @Autowired
    EmployService employService;

    @PostMapping("/save")
    public ResponseEntity<EmployDTO> saveEmploy(@RequestBody EmployDTO employDTO){
        if(EmployUtil.validateEmploy(employDTO)){
            throw new EmployNotValidException("Please validate the employ fields");
        }
        EmployDTO employ = employService.saveEmploy(employDTO);
        return new ResponseEntity<>(employ, HttpStatus.OK);
    }

    @GetMapping("/getTax")
    public ResponseEntity<List<EmployTaxDTO>> getEmployeesTax(){
        List<EmployTaxDTO> employeesTax = employService.getEmployeesTax();
        return new ResponseEntity<>(employeesTax, HttpStatus.OK);
    }
}
