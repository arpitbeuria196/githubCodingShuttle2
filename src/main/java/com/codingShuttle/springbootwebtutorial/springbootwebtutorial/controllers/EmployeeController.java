package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getMySuperSecretMessage()
//    {
//        return  "Secret message: jbsjxasklxnslk@123";
//    }

    private  final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")//Dynamic URL paths
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return  employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees()
    {
        return  employeeRepository.findAll();
    }

    @PostMapping
    public  EmployeeEntity  createNewEmployee(@RequestBody EmployeeEntity inputEmployee)
    {
        return  employeeRepository.save(inputEmployee);
    }




}
