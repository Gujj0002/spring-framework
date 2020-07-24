package org.learn.jdbc.dao.Impl;

import org.learn.jdbc.dao.EmployeeDao;
import org.learn.jdbc.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.learn.jdbc.DataSources.jdbcDataSource.getConnection;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String INSERT = "INSERT INTO EMPLOYEE (ID,NAME) VALUES(?,?)";

    @Override
    public void insert(Employee employee) throws SQLException {

        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        preparedStatement =connection.prepareStatement(INSERT);
        preparedStatement.setInt(1, employee.getId() );
        preparedStatement.setString(2, employee.getName());
        preparedStatement.executeUpdate();

        connection.isClosed();

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
