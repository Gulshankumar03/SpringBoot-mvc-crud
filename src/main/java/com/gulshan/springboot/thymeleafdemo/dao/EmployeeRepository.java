package com.gulshan.springboot.thymeleafdemo.dao;

import com.gulshan.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
    // This will automatically create all the CRUD methods for you

}
