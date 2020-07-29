package org.learn.jdbc.dao;

import org.learn.jdbc.domain.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    public void insert(Employee employee) throws SQLException;
    public void update(Employee employee);
    public Employee findByEmployeeId(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);


}
