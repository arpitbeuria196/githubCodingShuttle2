package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO
{
    private  Long id;

    @NotBlank(message = "Name Of the Employee Cannot be Empty:")
    @Size(min =3, max=10,message = "Number of Characters in name should be in the range:[3,10]")
    private  String name;

    @Email(message = "Email Should Be Valid")
    private String email;

    @Max(value = 80,message = "Age Can't be greater than 80")
    @Min(value = 20,message = "Age Can't be Less than 20")
    private  int age;

   // @Pattern(regexp = "^(ADMIN|USER)$")
    @NotBlank(message = "Role Of Employee Can't be Blank Be USer or ADMIN")
    @EmployeeRoleValidation
    private  String role;//ADMIN USER

    @PastOrPresent(message = "DateOf Joining field in Employee can't be in Future")
    private LocalDate dateOfJoining;

    @NotNull(message = "Salary of Employee Should be Not Null")
    @Positive(message = "Salary of Employee Should be Positive")
    @DecimalMax(value = "100000.99", message = "Salary can't exceed 100000.99")
    @DecimalMin(value = "100.50", message = "Salary can't be less than 100.50")
    private Double salary;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private  Boolean isActive;



}
