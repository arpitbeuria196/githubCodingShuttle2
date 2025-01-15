package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.repositories;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
