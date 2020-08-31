package Dominio;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "lector_dni", referencedColumnName = "dni")
    private Lector lector;

    @ManyToOne
    @JoinColumn(name = "copia_id", referencedColumnName = "id")
    private Copia copia;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaDeInicio;

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public Lector getLector() {
        return lector;
    }

    public Prestamo(Lector lector, Copia copia) {
        this.lector = lector;
        this.copia = copia;
        this.fechaDeInicio = LocalDate.now();
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Copia getCopia() {
        return copia;
    }

    public int getId() {
        return id;
    }
}
