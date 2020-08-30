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

    @Column
    private long multa;

    public long getMulta() {
        return multa;
    }

    public void multar() {
        long a = DAYS.between(LocalDate.now(),fechaDeInicio);
        if (a > 30)
            multa = a*2;
    }

    public Prestamo(Lector lector, Copia copia) {
        this.lector = lector;
        this.copia = copia;
        this.fechaDeInicio = LocalDate.now();
        this.multa = 0;
    }
}
