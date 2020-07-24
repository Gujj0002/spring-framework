package org.learn.hibernate.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.learn.hibernate.dao.EmployeeDao;
import org.learn.hibernate.dataSource.DataSources;
import org.learn.hibernate.domain.Employee;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void insert(Employee employee) {
        Session session = DataSources.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Employee employee) {
        Session session = DataSources.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();

    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        Session session = DataSources.getSessionFactory().openSession();
        TypedQuery typedQuery = session.createQuery("from Employee where id=:id" , Employee.class);
        typedQuery.setParameter("id", id);
        Employee employee = (Employee) typedQuery.getSingleResult();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session session = DataSources.getSessionFactory().openSession();
        List<Employee> list =  session.createQuery("from Employee").getResultList();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = DataSources.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.load(Employee.class, id);
        session.delete(employee);

        Query query = session.createQuery("delete Employee where id=:id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println(result);
        transaction.commit();
        session.close();

    }
}
