package com.imaginnovate.tax.service;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.exception.InvalidDateException;
import com.imaginnovate.tax.exception.InvalidFieldException;
import com.imaginnovate.tax.utils.EmployUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployServiceImplTest {

    EmployServiceImpl service;

    @Mock
    EmployService employService;


    @BeforeEach
    void setUp() {
        service = new EmployServiceImpl();

    }

    @Test
    void test_validEmployFields() {
        EmployDTO employDTO = new EmployDTO();
        employDTO.setId(202);
        employDTO.setFirstName("Reddy");
        employDTO.setLastName("Ch");
        employDTO.setEmail("reddy@gmail.com");
        employDTO.setPhoneNumber(Arrays.asList("9790915913","9963050154"));
        employDTO.setDoj("11-12-2024");
        employDTO.setSalary(56200.0);
        boolean isValidEmploy = EmployUtil.validateEmploy(employDTO);
        assertEquals(false, isValidEmploy);
    }

    @Test()
    void test_inValidEmployFields() {
        EmployDTO employDTO = new EmployDTO();
        employDTO.setId(202);
        employDTO.setFirstName("");
        employDTO.setLastName("Ch");
        employDTO.setEmail("reddy@gmail.com");
        employDTO.setPhoneNumber(Arrays.asList("9790915913","9963050154"));
        employDTO.setDoj("11-12-2024");
        employDTO.setSalary(56200.0);
        employDTO = mock(EmployDTO.class);
        when(employDTO.getFirstName()).thenThrow(InvalidFieldException.class);


    }
}