package Modelo;

import java.util.Scanner;

public class Sistema {

    private static final Scanner scanner = new Scanner(System.in);

    private static Sistema instance = null;

    public static void main(String[] args) {
        iniciarOperaciones();
    }

    public static void iniciarOperaciones() {

        System.out.println("Comprar billetes(1),");
        int operacion = scanner.nextInt();
        if (operacion == 1)
            comprarBillete();

    }

    public static void comprarBillete() {

        Viaje viaje = pedirViaje();

        System.out.println("Es usted fumador? true/false");
        boolean fumador = scanner.nextBoolean();

        System.out.println("Quiere plaza preferencial? true/false");
        boolean preferencial = scanner.nextBoolean();

        System.out.println("Quiere ventanilla? true/false");
        boolean ventanilla = scanner.nextBoolean();

        Plaza plaza = viaje.buscarPlazaDisponible(fumador, preferencial, ventanilla);

        if (plaza == null) {
            System.out.println("No hay disponibilidad");
        }

        Billete billete = pagarPlaza(plaza, viaje);

        System.out.println("Billete adquirido: " + billete.toString());
    }

    private static Billete pagarPlaza(Plaza plaza, Viaje viaje) {

        System.out.println("La plaza sale: " + plaza.getPrecio() + ". Como desea abonar?");
        Pago pago = pago();

        Billete billete = new Billete(pago, plaza, plaza.esPreferencial(), viaje,
                new Viajero("apellido", "nombre", 123)); // HABRIA QUE PEDIR LOS DATOS DEL VIAJERO PERO NO ES LO
                                                         // IMPORTANTE EN ESTE EJERCICIO

        viaje.addBillete(billete);
        viaje.reservarPlaza(plaza);

        return billete;
    }

    private static Pago pago() {
        // ACA SE LE PREGUNTARIA EL MEDIO DE PAGO Y LOS DATOS DE LA TARJETA SI SON
        // NECESARIOS
        return new Pago("tarjeta de credito");
    }

    private static Viaje pedirViaje() {

        System.out.println("Que viaje queres hacer?");

        for (Viaje v : Registro.getViajes()) {
            System.out.println(v.getId() + ") " + v.getHorario().toString());
        }

        int viaje_id = scanner.nextInt();

        return Registro.getViajes().stream().filter(v -> v.getId() == viaje_id).findFirst().get();
        // SI PONE UN CODIGO INCORRECTO ROMPE, PERO HABRIA QUE PONERLO EN UN WHILE NOMAS
        // Y CERO GANAS
    }

    private Sistema() {

    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();
        return instance;
    }
}