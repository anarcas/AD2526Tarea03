/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._ad_u03;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author anaranjo
 */
public class App {

    public static void main(String[] args) {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Query<Guarderia> query = session.createQuery("from Guarderia g", Guarderia.class);
            List<Guarderia> guarderias = query.list();
            
            for (Guarderia guarde : guarderias) {
                System.out.println("Guardería: " + guarde.getNombre() + " --Presupuesto: " + guarde.getPresupuesto()+ " --Capacidad: " + guarde.getCapacidad());
            }
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
