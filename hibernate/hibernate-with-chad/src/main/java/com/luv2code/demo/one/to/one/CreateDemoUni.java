package com.luv2code.demo.one.to.one;

import com.luv2code.demo.entities.Instructor;
import com.luv2code.demo.entities.InstructorDetails;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemoUni {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory()) {

        }
    }
}
