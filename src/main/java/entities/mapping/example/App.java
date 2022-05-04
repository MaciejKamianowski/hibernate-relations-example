package entities.mapping.example;

import entities.mapping.example.onetoone.bidirectional.Computer;
import entities.mapping.example.onetoone.bidirectional.Owner;
import entities.mapping.example.util.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Owner owner = new Owner();
        Computer computer = new Computer();
        owner.setOwnerName("Main admin");
        computer.setComputerName("Gigabyte DTR");
        owner.setOwnerComputer(computer);

        session.save(computer);
        session.save(owner);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
