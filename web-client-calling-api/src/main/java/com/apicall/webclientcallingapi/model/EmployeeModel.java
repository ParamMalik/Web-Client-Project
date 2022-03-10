package com.apicall.webclientcallingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor

public class EmployeeModel {
    private String id;
    private String Name;
    private Double Salary;
    private String Street;
    private String City;
}
