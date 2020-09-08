package Main;

import Servicios.GeoRef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import Domain.*;
import Servicios.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MLMain();
    }

    public static void MLMain() throws IOException {
        MercadoLibre.ServicioML servicioML = MercadoLibre.ServicioML.instancia();
        List<MunicipioML> municipiosML = new ArrayList<>();

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
            for(MunicipioML unMunicipio: municipiosDeLaProvincia.cities)
                municipiosML.add(new MunicipioML(unMunicipio.getId(),unMunicipio.getName()));
            List<Municipio> municipiosGR = georefMain(posibleProvincia.get());
            compararAPIs(municipiosGR,municipiosML);
        } else System.out.println("No existe la provincia seleccionada");

    }

    public static List<Municipio> georefMain(ProvinciasML prov) throws IOException {
        List<Municipio> municipiosGR = new ArrayList<>();
        GeoRef.ServicioGeoref servicioGeoref = GeoRef.ServicioGeoref.instancia();

        ListadoDeMunicipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvinciaConNombre(prov.getName());

        for (Municipio unMunicipio : municipiosDeLaProvincia.municipios)
            municipiosGR.add(new Municipio(unMunicipio.getId(), unMunicipio.getNombre()));
        return municipiosGR;
    }

    private static void compararAPIs(List<Municipio> municipiosGR, List<MunicipioML> municipiosML) {
        List<Municipio> municipiosGR2 = municipiosGR.stream().filter(mun-> !mun.estaEnLista(municipiosML)).collect(Collectors.toList());
        List<MunicipioML> municpiosML2= municipiosML.stream().filter(mun-> !mun.estaEnLista(municipiosGR)).collect(Collectors.toList());

        System.out.println("Los municipios que si tiene Georef y no tiene MercadoLibre son: ");
        mostrarLista(municipiosGR2);
        System.out.println("Los municipios que no tiene Georef y si tiene MercadoLibre son: ");
        mostrarLista2(municpiosML2);
    }

    public static void mostrarLista(List<Municipio> municipios) {
        for(Municipio municipio:municipios)
            System.out.println(municipio.getNombre());
    }

    public static void mostrarLista2(List<MunicipioML> municipios) {
        for(MunicipioML municipio:municipios)
            System.out.println(municipio.getName());
    }
}