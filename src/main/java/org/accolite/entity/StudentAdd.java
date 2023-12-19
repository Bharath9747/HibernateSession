package org.accolite.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Address_1")
public class StudentAdd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int cityId;
    private String location;

    public StudentAdd(String location) {
        this.location = location;
    }
//      @OneToOne(targetEntity = Student.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "id",referencedColumnName = "id")

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> studentSet;

    public List<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(List<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public StudentAdd(int city, List<Student> student) {
        this.cityId = city;
        this.studentSet = student;
    }



    @Override
    public String toString() {
        return "StudentAdd{" +
                "cityId='" + cityId + '\'' ;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }


    public StudentAdd() {
    }
}
