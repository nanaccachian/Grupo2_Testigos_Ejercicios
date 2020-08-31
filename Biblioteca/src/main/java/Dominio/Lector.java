package Dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "lectores")
public class Lector extends Persona {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lector")
    public final List<Prestamo> prestamos = new ArrayList<>();

    @Column
    private long multa = 0;

    public Lector(int dni, String nombre) {
        super(dni, nombre);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        if (prestamos.size() < 3)
            prestamos.add(prestamo);
    }

    public long getMulta() {
        return multa;
    }

    public void multar() {
        multa = 0;
        for(Prestamo prestamo:prestamos) {
            long a = DAYS.between(prestamo.getFechaDeInicio(),LocalDate.now());
            if (a > 30)
                multa += 2*a;
        }
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public boolean puedePedirPrestamo() {
        return multa == 0;
    }
}
