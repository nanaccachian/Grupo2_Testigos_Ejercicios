package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Lector extends Persona{
    private final List<Prestamo> prestamos = new ArrayList<>();

    public Lector() { }

    public void agregarPrestamo(Prestamo prestamo) {
        if (prestamos.size() < 3)
            prestamos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public boolean puedePedirPrestamo() {
        return prestamos.stream().anyMatch(prestamo -> !prestamo.getMulta());
    }
}
