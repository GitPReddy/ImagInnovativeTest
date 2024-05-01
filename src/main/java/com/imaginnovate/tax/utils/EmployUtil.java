package com.imaginnovate.tax.utils;

import com.imaginnovate.tax.dto.EmployDTO;
import com.imaginnovate.tax.exception.InvalidDateException;
import com.imaginnovate.tax.exception.InvalidFieldException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class EmployUtil {

    public static boolean validateEmploy(EmployDTO employ){
        if(employ == null)
            return true;

        if(employ.getFirstName() == null || employ.getFirstName().isEmpty())
            throw new InvalidFieldException("First name should not be empty");
        if(employ.getLastName() == null || employ.getLastName().isEmpty())
            throw new InvalidFieldException("Last Name should not be empty");
        if(employ.getEmail() == null || employ.getEmail().isEmpty())
            throw new InvalidFieldException("Email should not be empty");
        if(employ.getPhoneNumber() == null || employ.getPhoneNumber().isEmpty())
            throw new InvalidFieldException("Phone number should not be empty");
        if(validateDate(employ.getDoj()))
            return true;
        if(employ.getSalary() == null)
            throw new InvalidFieldException("Salary should not be empty");

        return false;
    }

    private static boolean validateDate(String doj) {
        if(doj == null || doj.isEmpty())
            throw new InvalidDateException("Date of Join should not be empty");
        else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try{
                Date employDate = dateFormat.parse(doj);
                System.out.println("Valid date " + dateFormat.format(employDate));
            } catch (ParseException e) {
                throw new InvalidDateException("Invalid date");
            }
        }

        return false;
    }

    public static Double calculateTaxAmount(Double yearlySalary){
        Double taxAmount = 0.00;
        double taxSlab1=0, taxSlab2=0, taxSlab3=0;
        if (yearlySalary > 250000) { // slab 1
            double amt = 0;
            if ((yearlySalary - 250000) > 250000)
                amt = 250000;
            else
                amt = yearlySalary - 250000;
            taxSlab1 = (0.05 * amt); // total tax in slab 1
            taxAmount += taxSlab1;
        }
        if (yearlySalary > 500000) { // slab 2
            double amt = 0;
            if ((yearlySalary - 500000) > 500000)
                amt = 500000;
            else
                amt = yearlySalary - 500000;
            taxSlab2 = 0.1 * amt; // total tax in slab 2
            taxAmount += taxSlab2;
        }
        if (yearlySalary > 1000000) { // slab 3
            taxSlab3 = 0.2 * (yearlySalary - 1000000); // total tax in slab 3
            taxAmount += taxSlab3;
        }

        /*
        if(yearlySalary > 250000 && yearlySalary <= 500000)
            taxAmount = (yearlySalary-250000)*0.05; // slab 1
        else if(yearlySalary > 500000 && yearlySalary <= 1000000)
            taxAmount = 200000 + (yearlySalary-500000)*0.1; // slab 1 + slab 2
        else if(yearlySalary > 1000000)
            taxAmount = 1200000 + (yearlySalary-1000000)*0.2;
         */
        return Double.valueOf(Math.round(taxAmount));
    }

    public static Double calculateCessAmount(Double yearlySalary){
        if(yearlySalary > 2500000)
            return Double.valueOf(Math.round(0.02 * (yearlySalary - 2500000)));
        return 0.0;
        //return 0.02 * calculateTaxAmount(yearlySalary);
    }

    public static Double calculateYearlySalary(Double salary, String doj) {
        int joinedDate = Integer.valueOf(doj.split("-")[0]);
        int joinedMonth = Integer.valueOf(doj.split("-")[1]);

        Double totalSalary = 0.0;
        int lossOfPayDays = 0;
        int lossOfMonths = 0;

        if(joinedMonth == 04)
            return Double.valueOf(Math.round(salary*12));
        Map<Integer, Integer> monthsMap = MonthsDateMap.constructMap();


        for(int month=1; month<=12; month++){
            if(month == joinedMonth){
                lossOfPayDays = monthsMap.get(joinedMonth)-joinedDate;
                if(month > 4)
                    lossOfMonths = 12 - (joinedMonth - 4);
                else
                    lossOfMonths = 4 - joinedMonth;
                break;
            }

        }
        totalSalary = ((lossOfMonths) * salary) + (lossOfPayDays * (salary/30));

        return Double.valueOf(Math.round(totalSalary));
    }
}
