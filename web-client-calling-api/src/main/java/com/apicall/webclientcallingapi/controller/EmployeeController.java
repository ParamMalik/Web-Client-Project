package com.apicall.webclientcallingapi.controller;

import com.apicall.webclientcallingapi.model.EmployeeModel;
import com.apicall.webclientcallingapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public Flux<EmployeeModel> getAllEmpData() {
        return employeeService.findAll();
    }

    @GetMapping("/all/{id}")
    public Mono<EmployeeModel> getEmpDataByName(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @PostMapping("/save")
    public Mono<EmployeeModel> saveEmpData(@RequestBody EmployeeModel employeeModel){
        return employeeService.saveEmpDetails(employeeModel);
    }

    @PutMapping("/update")
    public Mono<EmployeeModel> updateEmpData(@RequestBody EmployeeModel employeeModel){
        return employeeService.updateEmpDetails(employeeModel);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteEmpData(@PathVariable String id){
        return employeeService.deleteEmpDetails(id);
    }

}
