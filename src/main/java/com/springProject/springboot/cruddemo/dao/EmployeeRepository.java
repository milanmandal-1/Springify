package com.springProject.springboot.cruddemo.dao;

import com.springProject.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //hdacv
}
