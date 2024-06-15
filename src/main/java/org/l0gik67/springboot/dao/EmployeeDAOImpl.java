package org.l0gik67.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.l0gik67.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> getAllEmployees(){

        List<Employee> result = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return result;
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int id){

        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id){


        Query query = entityManager.createQuery("delete from Employee where id =: empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
