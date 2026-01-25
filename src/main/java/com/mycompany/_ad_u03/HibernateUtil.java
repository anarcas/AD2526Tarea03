/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._ad_u03;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase para la fabricación de sesiones de Hibernate. Implementa una variable
 * sessionFactory de manera static para asegurar que solo exista una instancia
 * de {@code SessionFactory} en toda la aplicación, optimizando así el uso de
 * recursos y la conexión con el SGBD MySQL.
 *
 * @author Antonio Naranjo Castillo
 * @version 1.0
 */
public class HibernateUtil {

    // Declaración de la variable fábrica de sesiones
    private static SessionFactory sessionFactory;

    /**
     * Bloqueo estático que inicia la configuración de hibernate. Lee el archivo
     * de configuración y construye la fábrica de sesiones.
     */
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Método getter que devuelve la fábrica de sesiones.
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
