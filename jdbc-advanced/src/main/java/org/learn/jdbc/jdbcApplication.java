package org.learn.jdbc;

import org.learn.jdbc.dao.EmployeeDao;
import org.learn.jdbc.dao.Impl.EmployeeDaoImpl;
import org.learn.jdbc.domain.Employee;

import java.sql.SQLException;

public class jdbcApplication {

    public static void main(String[] args) throws SQLException {

        Employee employee = new Employee(1001, "Alps");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.insert(employee);
    }
}
