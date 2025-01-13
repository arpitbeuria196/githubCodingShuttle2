package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getMySuperSecretMessage()
//    {
//        return  "Secret message: jbsjxasklxnslk@123";
//    }

    @GetMapping("/{employeeId}")//Dynamic URL paths
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return  new EmployeeDTO(employeeId,"Arpit","arpitbeuria196@gmail.com",27, LocalDate.of(2024,12,31),true);
    }

    @GetMapping
    public  String getEmployees(@RequestParam Integer age,
                                @RequestParam String Name)
    {
        return  "Hi My age is"+ age + "And My Name is"+Name;
    }


}
