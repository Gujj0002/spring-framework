package org.learn.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learn.hibernate.dao.EmployeeDao;
import org.learn.hibernate.dao.Impl.EmployeeDaoImpl;
import org.learn.hibernate.dataSource.DataSources;
import org.learn.hibernate.domain.Employee;

import java.util.List;

public class hibernateApplication {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
      /*  List<Employee> list = employeeDao.findAll();

        for (Employee employee : list){
            System.out.println(employee);
        }
       */

       /* Employee employee = new Employee("Tony Stark");
        employeeDao.insert(employee);*/

      // employeeDao.delete(1);


        employeeDao.findAll().forEach(e -> System.out.println(e));
        DataSources.closeSessionFactory();
    }
}
