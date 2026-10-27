package com.example.article.model;

import org.hibernate.Session;

public class TestHibernate {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            System.out.println("Connexion Hibernate réussie !");
        }

        HibernateUtil.shutdown();
    }
}