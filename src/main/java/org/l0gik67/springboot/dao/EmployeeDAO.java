package org.l0gik67.springboot.dao;

import org.l0gik67.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
