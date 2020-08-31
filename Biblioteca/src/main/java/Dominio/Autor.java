package Dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "autores")
public class Autor extends Persona{

    @Column
    private String nacionalidad;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    public Autor(int dni, String nombre, String nacionalidad, LocalDate fechaDeNacimiento) {
        super(dni, nombre);
        this.nacionalidad = nacionalidad;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
}
