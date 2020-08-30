package Dominio;

import javax.persistence.*;

@Entity
@Table(name = "copias")
public class Copia {

    @Column
    public String estado;

    @ManyToOne
    @JoinColumn(name = "libro_id",referencedColumnName = "id")
    public Libro libro;

    @Id
    @GeneratedValue
    public int id;

    public Copia(String estado, Libro libro) {
        this.estado = estado;
        this.libro = libro;
    }
}
