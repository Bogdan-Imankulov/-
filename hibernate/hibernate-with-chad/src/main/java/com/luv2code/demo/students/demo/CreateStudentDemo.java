package com.luv2code.demo.students.demo;

import com.luv2code.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.openSession();
            Student student = new Student("Mark", "Jones","pajones@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

}
