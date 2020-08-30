package Main;

import Domain.*;
import Servicios.*;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        georefMain();
        MLMain();
    }

    public static void georefMain() throws IOException {
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

    public static void MLMain() throws IOException {
        MercadoLibre.ServicioML servicioML = MercadoLibre.ServicioML.instancia();

        System.out.println("Seleccione una de las siguientes provincias, ingresando su id:");

        ListadoDeProvinciasML listadoDeProvinciasArgentinas = servicioML.listadoDeProvinciasML();
        for (ProvinciasML unaProvincia:listadoDeProvinciasArgentinas.states) {
            System.out.println(unaProvincia.getId() + ") " + unaProvincia.getName());
        }

        Scanner entradaEscaner = new Scanner(System.in);
        String idProvinciaElegida = entradaEscaner.nextLine();

        Optional<ProvinciasML> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeId(idProvinciaElegida);

        if (posibleProvincia.isPresent()) {
            ProvinciasML provinciaSeleccionada = posibleProvincia.get();
            ListadoDeMunicipiosML municipiosDeLaProvincia = servicioML.listadoDeMunicipiosDeProvinciaML(provinciaSeleccionada);
            System.out.println("Los municipios de la provincia " + provinciaSeleccionada.getName() + " son:");
            for(MunicipioML unMunicipio: municipiosDeLaProvincia.cities){
                System.out.println(unMunicipio.getName());
            }
        }
        else System.out.println("No existe la provincia seleccionada");
    }
}