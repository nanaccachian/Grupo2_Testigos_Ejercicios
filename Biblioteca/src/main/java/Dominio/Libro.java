package Dominio;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "autor_dni",referencedColumnName = "dni")
    private Autor autor;

    @Column
    private String categoria;

    @Column
    private int anio;

    @Column
    private String editorial;

    public Libro(String nombre, Autor autor, String categoria, int anio, String editorial) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.anio = anio;
        this.id = id;
        this.editorial = editorial;
    }
}
