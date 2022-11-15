package com.luv2code.demo.students.demo;

import com.luv2code.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            System.out.println(student);
            session.createQuery("update Student set email='Paul@yandex.ru'").executeUpdate();
            session.getTransaction().commit();
        }

    }
}
