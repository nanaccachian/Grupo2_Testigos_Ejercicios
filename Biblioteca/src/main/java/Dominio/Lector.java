package Dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lectores")
public class Lector extends Persona {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "lector")
    public final List<Prestamo> prestamos = new ArrayList<>();

    public Lector(int dni, String nombre) {
        super(dni, nombre);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        if (prestamos.size() < 3)
            prestamos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public boolean puedePedirPrestamo() {
        return prestamos.stream().anyMatch(prestamo -> prestamo.getMulta() != 0);
    }


}
