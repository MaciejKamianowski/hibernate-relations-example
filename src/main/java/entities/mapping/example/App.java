package entities.mapping.example;

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

        Employee employee = new Employee();
        employee.setEmployeeName("Mathew");

        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task();
        task1.setTaskName("Make unit tests");
        Task task2 = new Task();
        task2.setTaskName("Make frontend in React");
        tasks.add(task1);
        tasks.add(task2);
        employee.setTasks(tasks);

        session.save(employee);
        session.save(task1);
        session.save(task2);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
