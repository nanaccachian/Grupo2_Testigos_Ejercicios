package Consola;

import Dominio.*;
import db.*;

public class Main {

    public static void main(String[] args) {
        boolean queres = true;

        do {
            System.out.println("Ingrese el código de la operación que desea realizar: Agregar organización (1), Agregar egreso (2), Agregar usuario (3), Agregar ingreso (4), Crear / Modificar sistema de categorias (5), Definir relacion entre criterios (6),  Cerrar sesion(0)");
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
    }

    public static void crearPrestamo() {
        System.out.println("Ingrese el código de la copia del libro");
        int copia_id = Scaneador.scanearInt();

        System.out.println("Ingrese su DNI");
        int lector_id = Scaneador.scanearInt();

        Prestamo prestamo;

        EntityManagerHelper.beginTransaction();

    }
}
