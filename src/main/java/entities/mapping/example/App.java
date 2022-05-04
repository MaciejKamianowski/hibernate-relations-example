package entities.mapping.example;

import entities.mapping.example.onetoone.unidirectional.Role;
import entities.mapping.example.onetoone.unidirectional.User;
import entities.mapping.example.util.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        Role role = new Role();
        role.setRoleName("admin");
        user.setUserName("Raj");
        user.setUserPwd("Google");
        user.setRole(role);
        session.save(role);
        session.save(user);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
