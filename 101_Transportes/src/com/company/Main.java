package com.company;
import Modelo.*;

public class Main {

    public static void main(String[] args) {

        Estandar formaEnvio = new Estandar(10,20,50);
        Transportista FedEx = new Transportista("FedEx",formaEnvio);
        Paquete paquete1 = new Paquete("iPhone", 4);
        Envio envio = new Envio(60, FedEx, paquete1);

        float a = envio.costoEnvio();
        System.out.println("El envio costo con tarifa estandar " + a);

        PorDistancia formaEnvio2 = new PorDistancia(40);
        FedEx.setTipoEnvio(formaEnvio2);

        a = envio.costoEnvio();
        System.out.println("El envio costo con tarifa por distncia es " + a);


    }
}
