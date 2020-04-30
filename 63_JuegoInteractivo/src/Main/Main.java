package Main;

import Modelo.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Sistema sistema = Sistema.getInstance();

        Principe principeEncantador = new Principe("Principe Encantador", 75, 175, 40, 25);
        Monstruo shrek = new Monstruo("Shrek",120,190,5,70);

        sistema.nuevoPersonaje(principeEncantador);
        sistema.nuevoPersonaje(shrek);

        Monstruo shrek2 = (Monstruo) sistema.clonarPersonaje(shrek);

        System.out.println(shrek2.getClass());
        System.out.println(!shrek.equals(shrek2)); //PARA VERIFICAR QUE NO ERAN EL MISMO OBJETO

        sistema.crearPartida(shrek);
    }
}
