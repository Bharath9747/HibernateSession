package org.accolite.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_3")
public class Student {
    @Override
    public String toString() {
        return "id : " + id +
                ", firstName : " + firstName +
                ", lastName : " + lastName +
                ", age : " + age;
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private StudentAdd address;

    public StudentAdd getAddress() {
        return address;
    }

    public void setAddress(StudentAdd address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    private String firstName;
    private String lastName;
    private int age;

    public Student() {

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
