package UserInterface;

import Domain.Cajero;
import Domain.Ticket;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class InterfazDeUsuario {
    private static InterfazDeUsuario instance = null;
    private static Ticket ticket = null;
    private static Cajero cajero;
    private static Scanner sc = new Scanner(System.in);
    private static boolean bandeja; // REPRESENTARIA LA BANDEJA

    private  InterfazDeUsuario() {
    }

    public static void setTicket(Ticket ticket) {
        InterfazDeUsuario.ticket = ticket;
    }

//    public static InterfazDeUsuario getInstance() {
//        if (instance == null)
//            instance = new InterfazDeUsuario();
//        return instance;
//    }

    public static void seIntrodujoTicket() throws InterruptedException {
        if (ticket!=null) {
            boolean hayCambio;
            float importeAPagar = Cajero.calcularImporte(ticket);

            do {
                System.out.println("Ingrese $"+importeAPagar);
                float dineroIngresado = sc.nextFloat();

                float cambio = dineroIngresado - importeAPagar;

                while (cambio < 0) {
                    System.out.println("Ingrese $"+ cambio*(-1));
                    dineroIngresado += sc.nextFloat();
                    cambio = dineroIngresado - importeAPagar;
                }

                hayCambio = Cajero.tenesCambio(cambio);

                if (!hayCambio) {
                    System.out.println("No tengo cambio, ingrese un valor menor");
                    devolverDinero();
                }

            } while (!hayCambio);

            System.out.println("Recoge el cambio y el recibo");
            Cajero.generarRecibo(importeAPagar,ticket);
            
            darRecibo();

            int a = 0;
            boolean retiro = false;

            while (a < 2 || !retiro) {

                System.out.println("Recogio el cambio? (true/false)");
//              retiro = sc.nextBoolean(); BLOQUEA AL PITIDO, ES UN PROBLEMA DE SO, NO DE DDS

                Thread.sleep(15000);
                pitido();

                a++;
                if (a == 2) {
                    System.out.println("Ticket Retenido");
                    chuparRecibo();
                    retiro = true;
                } else System.out.println("Retire Ticket");
            }
            System.out.println("Muchas gracias!");
        }
    }

    private static void chuparRecibo() { }

    public static void devolverDinero() {
        ReproduceAudio.reproducirAudio("src/main/resources/Monedas.wav"); //REPRESENTANDO QUE DEVUELVE EL DINERO
    }

    private static void pitido() {
        ReproduceAudio.reproducirAudio("src/main/resources/pitido.wav");
    }

    private static void darRecibo() {
        //METODO QUE IMPRIME UN RECIBO Y LO PONE EN LA BANDEJA PARA RETIRARLO
    }

    public static class ReproduceAudio {

        public static void reproducirAudio(String audio) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audio).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch(Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }
    }
}
