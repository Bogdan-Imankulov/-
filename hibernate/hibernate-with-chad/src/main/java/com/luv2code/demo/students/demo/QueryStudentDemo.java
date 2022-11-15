package com.luv2code.demo.students.demo;

import com.luv2code.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();
            System.out.println(studentList);
            List<Student> paulList = session.createQuery("from Student s where s.firstName='Paul'").getResultList();
            System.out.println(paulList);
            session.getTransaction().commit();
        }
    }
}
