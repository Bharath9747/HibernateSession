package org.accolite;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.accolite.entity.StudentAdd;
import org.accolite.entity.Student;
import org.accolite.util.Utility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Manager {
    public static void main(String[] args) {
//        create(1,"Nambi","Vaishnavi",23);
//        create(2,"Ashok","Kumar",23);
//            getById(1);
//        getAll();
//        update("Seeni", 1);
//        create("XYZ","ABC",23,"City1","State");
//        create("XYZ","ABC",23,new StudentAdd(1,"TN"));
        Student student = new Student("XYZ","ABC",23);
        Student student1 = new Student("ABC","XYZ",23);
        StudentAdd studentAdd = new StudentAdd("Tuty");
        student.setAddress(studentAdd);
        student1.setAddress(studentAdd);
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
session.persist(student);
session.persist(student1);

        transaction.commit();
        session.flush();
        session.close();

    }


    private static void create(String fname, String lname, int age, StudentAdd address) {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Student st = new Student();
        st.setLastName(lname);
        st.setFirstName(fname);
        st.setAge(age);
        StudentAdd studentAdd = address;
//        studentAdd.setStudent(st);
        session.save(studentAdd);
        transaction.commit();
        session.flush();
        session.close();
    }

    private static void create(String fname, String lname, int age, int city, String state) {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Student st = new Student();
        st.setLastName(lname);
        st.setFirstName(fname);
        st.setAge(age);
//        st.setAddress(new StudentAdd(city,state));
        session.save(st);
        transaction.commit();
        session.flush();
        session.close();
    }

    private static void update(String lastName, int i) {
        Session session = Utility.getSession();
        Student s = session.get(Student.class, i);
        s.setLastName(lastName);
        session.update(s);
        session.flush();
        session.close();
    }

    private static void getAll() {
        Session session = Utility.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        query.from(Student.class);
        List<Student> studentList = session.createQuery(query).getResultList();
        studentList.forEach(System.out::println);
        session.flush();
        session.close();
    }

    private static void getById(int i) {
        Session session = Utility.getSession();
        Student s = session.get(Student.class, i);
        System.out.println(s);
        session.flush();
        session.close();
    }


    private static void create(int id, String firstName, String lastName, int age) {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
//        student.setId(id);
        student.setAge(age);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        session.save(student);
        transaction.commit();
        session.flush();
        session.close();
    }


}