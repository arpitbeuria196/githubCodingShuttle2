package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.services;


import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository;

    @Autowired
    private  ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeDTO getEmployeeById(Long employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
        return  modelMapper.map(employeeEntity,EmployeeDTO.class);


    }

    public List<EmployeeDTO> getAllEmployees() {
       List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();

        return   employeeEntities.stream().map
               ((employeeEntity ->
                       modelMapper.map(employeeEntity,EmployeeDTO.class))).collect(Collectors.toList());

    }

    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity =modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return  modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeId(Long employeeId, EmployeeDTO employeeDTO) {
     EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
     employeeEntity.setId(employeeId);
     EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
     return  modelMapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }

    public void deleteEmployeeId(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public EmployeeDTO updatePartialEmployeeId(Long employeeId, Map<String, Object> updates) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists)  return  null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);

        updates.forEach((field,value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class,field);

            if(fieldToBeUpdated!=null)
            {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
            }

        });
        EmployeeEntity updatedEmployeeEntity = employeeRepository.save(employeeEntity);

        return  modelMapper.map(updatedEmployeeEntity,EmployeeDTO.class);

    }
}
