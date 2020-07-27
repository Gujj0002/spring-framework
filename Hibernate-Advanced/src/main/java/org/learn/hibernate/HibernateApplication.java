package org.learn.hibernate;

import org.hibernate.Session;
import org.learn.hibernate.datasource.DataSources;
import org.learn.hibernate.domain.Employee;
import org.learn.hibernate.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class HibernateApplication {

    public static void main(String[] args) {

        Session session = DataSources.getSessionFactory().openSession();
        session.getTransaction().begin();

       /* Store store = new Store("Lob-laws", "College square, ON");   // Storing data into database....

        Employee employee = new Employee("John Smith");
        Employee employee1 = new Employee("Tony Stark");

        employee.setStore(store);
        employee1.setStore(store);

        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);

        store.setEmployees(list);
        session.persist(store);
        //  session.save(employee);
        // session.save(employee1);
*/
/*
        List<Store> stores = session.createQuery("FROM Store", Store.class).getResultList();    // getting store list ....

        for (Store s : stores){
            System.out.println(s.getName() + "\t" + s.getLocation());

            for(Employee e : s.getEmployees()){
                System.out.println("\t" + e.getName());
            }
        }

        Employee e  = session.createQuery("FROM Employee where id = 1", Employee.class).getSingleResult();   // getting single employee by id...
        System.out.println(e.getName() + "\t" + e.getStore().getName());*/


        // Hibernate Store Procedure to get data from database...//

       /* List<Store> stores = session.createNamedQuery("SelectAll" , Store.class).getResultList();

        for (Store s: stores){
            System.out.println(s.getName() + s.getLocation());
        }*/

        List<Store> stores = session.createNamedStoredProcedureQuery("SelectAll").getResultList();
        for (Store s: stores) {
            System.out.println(s.getName() + s.getLocation());
        }

        session.getTransaction().commit();
        session.close();
        DataSources.closeSessionFactory();
    }
}
