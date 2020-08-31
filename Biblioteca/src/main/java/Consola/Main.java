package Consola;

import Dominio.*;
import db.*;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Lector lector = new Lector(1, "Pedro Alfonso");
        Lector lector1 = new Lector(2, "Pedro Alfonso 2");
        Lector lector2 = new Lector(3, "Pedro Alfonso 3");
        Lector lector3 = new Lector(4, "Pedro Alfonso 4");
        Lector lector4 = new Lector(5, "Pedro Alfonso 5");

        Autor autor = new Autor(123, "Hernesto", "argentino", LocalDate.of(1999, 12, 13));

        Libro libro1 = new Libro("buenos dias", autor, "policial", 2010, "Estrada");
        Copia copia1 = new Dominio.Copia(libro1);
        Copia copia2 = new Dominio.Copia(libro1);
        Copia copia3 = new Dominio.Copia(libro1);
        Copia copia4 = new Dominio.Copia(libro1);
        Copia copia5 = new Dominio.Copia(libro1);

        Lector lector45 = new Lector(89, "Pedrito");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(lector);
        EntityManagerHelper.getEntityManager().persist(lector1);
        EntityManagerHelper.getEntityManager().persist(lector2);
        EntityManagerHelper.getEntityManager().persist(lector3);
        EntityManagerHelper.getEntityManager().persist(lector4);
        EntityManagerHelper.getEntityManager().persist(lector45);
        EntityManagerHelper.getEntityManager().persist(autor);
        EntityManagerHelper.getEntityManager().persist(libro1);
        EntityManagerHelper.getEntityManager().persist(copia1);
        EntityManagerHelper.getEntityManager().persist(copia2);
        EntityManagerHelper.getEntityManager().persist(copia3);
        EntityManagerHelper.getEntityManager().persist(copia4);
        EntityManagerHelper.getEntityManager().persist(copia5);


        EntityManagerHelper.commit();

        boolean queres = true;

        do {
            System.out.println("1. Crear prestamo, 2. Devolver libro, 3. Calcular multa");
            int codOperacion = Scaneador.scanearInt();

            if (codOperacion == 1) crearPrestamo();
            else if (codOperacion == 2) devolverLibro();
            else if (codOperacion == 3) calcularMulta();
            else if (codOperacion == 0) break;
            else {
                System.out.println("Ingresaste mal el código de operación, intente de nuevo");
                continue;
            }

            System.out.println("¿Queres realizar otra operación? (true/false)");
            queres = Scaneador.scanearBoolean();

        } while (queres);

        EntityManagerHelper.closeEntityManager();
    }

    private static void calcularMulta() {
        System.out.println("Ingrese su DNI");
        int lector_id = Scaneador.scanearInt();

        Lector lector;

        try {
            EntityManagerHelper.beginTransaction();
            lector = (Lector) EntityManagerHelper.createQuery("from Lector where id = " + lector_id).getSingleResult();
        } catch (NoResultException exception) {
            lector = null;
            System.out.println("No existe el lector");
        }

        if (lector != null) {
            lector.multar();
            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.createQuery("update Lector set multa = "+ lector.getMulta() + " where id = " + lector_id).executeUpdate();
            System.out.println("Cliente multado");
            EntityManagerHelper.commit();
        }
    }

    private static void devolverLibro() {
        System.out.println("Ingrese el código del prestamo");
        int prestamo_id = Scaneador.scanearInt();

        Prestamo prestamo;
        try {
            prestamo = EntityManagerHelper.getEntityManager().find(Prestamo.class,prestamo_id);
        } catch (NoResultException exception) {
            prestamo = null;
            System.out.println("No existe ese prestamo");
        }
        if (prestamo != null) {
            Lector lector = prestamo.getLector();
            lector.eliminarPrestamo(prestamo);
            prestamo.setLector(null);

            EntityManagerHelper.beginTransaction();
            prestamo.getCopia().setEstado("Presente");
            EntityManagerHelper.getEntityManager().flush();
            EntityManagerHelper.createQuery("delete Prestamo where id = " + prestamo_id).executeUpdate();
            EntityManagerHelper.commit();
        }
    }

    public static void crearPrestamo() {
        System.out.println("Ingrese el código de la copia del libro");
        int copia_id = Scaneador.scanearInt();

        Copia copia;
        try {
            copia = (Copia) EntityManagerHelper.createQuery("from Copia where id = " + copia_id).getSingleResult();
        } catch (NoResultException exception) {
            copia = null;
            System.out.println("No existe ese libro");
        }
        if (copia != null) {
            EntityManagerHelper.beginTransaction();
            System.out.println("Ingrese su DNI");
            int lector_id = Scaneador.scanearInt();

            Lector lector = EntityManagerHelper.getEntityManager().find(Lector.class, lector_id);

            if (lector == null) {
                System.out.println("Ingrese el nombre");
                String nombre_lector = Scaneador.scanearString();

                lector = new Lector(lector_id, nombre_lector);
                EntityManagerHelper.persist(lector);
            }

            if (lector.puedePedirPrestamo() && copia.getEstado().equals("Presente")) {
                copia.setEstado("Prestado");
                EntityManagerHelper.createQuery("update Copia set estado = 'Prestado' where id = " + copia_id);
                Prestamo prestamo = new Prestamo(lector, copia);
                lector.agregarPrestamo(prestamo);
                EntityManagerHelper.persist(prestamo);
            }

            EntityManagerHelper.commit();
        }
    }
}
