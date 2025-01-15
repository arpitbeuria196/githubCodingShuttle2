package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getMySuperSecretMessage()
//    {
//        return  "Secret message: jbsjxasklxnslk@123";
//    }

   private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")//Dynamic URL paths
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        EmployeeDTO employeeDTO =  employeeService.getEmployeeById(employeeId);
        if(employeeDTO == null) return ResponseEntity.notFound().build();

        return  ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees()
    {
        return  employeeService.getAllEmployees();
    }

    @PostMapping
    public  ResponseEntity<EmployeeDTO>  createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {
        EmployeeDTO savedEmployee =  employeeService.createEmployee(inputEmployee);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,
    @PathVariable Long employeeId)
    {
        return  employeeService.updateEmployeeId(employeeId,employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(
                                   @PathVariable Long employeeId)
    {
          employeeService.deleteEmployeeId(employeeId);
    }


    @PatchMapping("/{employeeId}")
    EmployeeDTO updateEmployeeById(@RequestBody Map<String,Object> updates,
                                   @PathVariable Long employeeId)
    {
        return  employeeService.updatePartialEmployeeId(employeeId,updates);
    }





}
