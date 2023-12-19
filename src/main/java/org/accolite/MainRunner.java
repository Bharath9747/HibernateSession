package org.accolite;

import org.accolite.entity.Employee;
import org.accolite.entity.Gender;
import org.accolite.util.Utility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainRunner {
    public static void main(String[] args) {
        Session session = Utility.getSession();
        Employee employee = new Employee();
        employee.setGender(Gender.MALE);
        employee.setName("Kumar");
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.flush();
        session.close();
    }
}
