package Main;

import Domain.*;
import Servicios.*;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GeoRef.ServicioGeoref servicioGeoref = GeoRef.ServicioGeoref.instancia();

        System.out.println("Seleccione una de las siguientes provincias, ingresando su id:");

        ListadoDeProvincias listadoDeProvinciasArgentinas = servicioGeoref.listadoDeProvincias();
        for(Provincia unaProvincia:listadoDeProvinciasArgentinas.provincias){
            System.out.println(unaProvincia.getId() + ") " + unaProvincia.getNombre());
        }

        Scanner entradaEscaner = new Scanner(System.in);
        String idProvinciaElegida = entradaEscaner.nextLine();

        Optional<Provincia> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeId(Integer.parseInt(idProvinciaElegida));

        if(posibleProvincia.isPresent()){
            Provincia provinciaSeleccionada = posibleProvincia.get();
            ListadoDeMunicipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
            System.out.println("Los municipios de la provincia "+ provinciaSeleccionada.getNombre() +" son:");
            for(Municipio unMunicipio: municipiosDeLaProvincia.municipios){
                System.out.println(unMunicipio.getNombre());
            }
        }
        else System.out.println("No existe la provincia seleccionada");
    }
}