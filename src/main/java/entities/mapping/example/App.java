package entities.mapping.example;

import entities.mapping.example.onetomany.bidirectional.Course;
import entities.mapping.example.onetomany.bidirectional.Instructor;
import entities.mapping.example.onetomany.unidirectional.Employee;
import entities.mapping.example.onetomany.unidirectional.Task;
import entities.mapping.example.onetoone.bidirectional.Computer;
import entities.mapping.example.onetoone.bidirectional.Owner;
import entities.mapping.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Instructor instructor = new Instructor();
        instructor.setInstructorFullName("Mathew Kamsky");

        List<Course> courses = new ArrayList<>();
        Course course1 = new Course();
        course1.setCourseName("C++ Basics");
        Course course2 = new Course();
        course2.setCourseName("Introduction to Machine Learning");
        Course course3 = new Course();
        course3.setCourseName("React + Typescript from scratch");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

       courses.stream().forEach(c -> c.setInstructor(instructor));
        session.save(instructor);
        session.save(course1);
        session.save(course2);
        session.save(course3);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
