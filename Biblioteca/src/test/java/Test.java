
import db.EntityManagerHelper;
import Dominio.*;

import java.time.LocalDate;

public class Test {


    @org.junit.Test
    public void test1() {

        Lector lector = new Lector(1,"Pedro Alfonso");
        Lector lector1 = new Lector(2,"Pedro Alfonso 2");
        Lector lector2 = new Lector(3,"Pedro Alfonso 3");
        Lector lector3 = new Lector(4,"Pedro Alfonso 4");
        Lector lector4 = new Lector(5,"Pedro Alfonso 5");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(lector);
        EntityManagerHelper.getEntityManager().persist(lector1);
        EntityManagerHelper.getEntityManager().persist(lector2);
        EntityManagerHelper.getEntityManager().persist(lector3);
        EntityManagerHelper.getEntityManager().persist(lector4);

        EntityManagerHelper.commit();
    }

    @org.junit.Test
    public void test2() {
        Autor autor = new Autor(123, "Hernesto", "argentino", LocalDate.of(1999,12,13));

        Libro libro1 = new Libro("buenos dias", autor, "policial", 2010,"Estrada");
        Copia copia1 = new Copia("Prestamo",libro1);

        Lector lector45 = new Lector(89,"Pedrito");
        Prestamo prestamo = new Prestamo(lector45,copia1);

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(lector45);
        EntityManagerHelper.getEntityManager().persist(autor);
        EntityManagerHelper.getEntityManager().persist(libro1);
        EntityManagerHelper.getEntityManager().persist(copia1);
        EntityManagerHelper.getEntityManager().persist(prestamo);

        EntityManagerHelper.commit();
    }

}
