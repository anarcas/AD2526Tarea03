/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany._ad_u03;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author anaranjo
 */
public class App {

    public static void main(String[] args) {
        String codigo = "OPQ05";
        String nombre = "El Castillo de mi Bebé";
        int capacidad = 60;
        float presupuesto = 42000f;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            consultarGuarderia(session);
            //guardarGuarderia(session, codigo, nombre, capacidad, presupuesto);
            //borrarGuarderia(session, codigo);
            //actualizarGuarderia(session, codigo);

            session.close();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    static void consultarGuarderia(Session ss) {

        Transaction tst = ss.beginTransaction();

        try {
            Query<Guarderia> query = ss.createQuery("from Guarderia g where capacidad<50", Guarderia.class);
            List<Guarderia> guarderias = query.list();

            for (Guarderia guarde : guarderias) {
                System.out.println("Guardería: " + guarde.getNombre() + " --Presupuesto: " + guarde.getPresupuesto() + " --Capacidad: " + guarde.getCapacidad());
            }

            // Se confirma la transacción
            tst.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void borrarGuarderia(Session ss, String codigo) {

        Transaction tst = ss.beginTransaction();

        try {

            Guarderia guarde = ss.get(Guarderia.class, codigo);

            if (guarde == null) {
                System.out.println("No se encontró la guardería con código: " + codigo);
            } else {
                // Borrar guardería
                ss.delete(guarde);
                System.out.println("Se borró la guardería con código: " + codigo);
            }

            // Se confirma la transacción
            tst.commit();

        } catch (Exception e) {

            if (tst != null) {
                // Hacer rollback en caso de error
                tst.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    static void actualizarGuarderia(Session ss, String codigo) {

        Transaction tst = ss.beginTransaction();

        try {

            Guarderia guarde = ss.get(Guarderia.class, codigo);

            if (guarde == null) {
                System.out.println("No se encontró la guardería con código: " + codigo);
            } else {
                // Actualizar guardería
                guarde.setPresupuesto(43550f);
                ss.update(guarde);
                System.out.println("Se actualizó la guardería con código: " + codigo);
            }

            // Se confirma la transacción
            tst.commit();

        } catch (Exception e) {

            if (tst != null) {
                // Hacer rollback en caso de error
                tst.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    static void guardarGuarderia(Session ss, String codigo, String nombre, int capacidad, float presupuesto) {

        Transaction tst = ss.beginTransaction();

        try {

            Guarderia guarde = new Guarderia("OPQ05");
            guarde.setNombre("El Castillo de mi Bebé");
            guarde.setCapacidad(60);
            guarde.setPresupuesto(42000f);
            ss.save(guarde);

            tst.commit();

        } catch (ConstraintViolationException e) {

            if (tst != null) {
                // Hacer rollback si hay un error
                tst.rollback();
            }
            System.out.println(e.getMessage());

        } catch (Exception e) {

            if (tst != null) {
                // Hacer rollback para cualquier otro error
                tst.rollback();
            }
            System.out.println("No se ha podido guardar el objeto guardería" + e.getMessage());
        }
    }

}
