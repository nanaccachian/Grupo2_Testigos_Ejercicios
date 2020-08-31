package Dominio;

import javax.persistence.*;

@Entity
@Table(name = "copias")
public class Copia {

    @Column
    public String estado = "Presente";

    @ManyToOne
    @JoinColumn(name = "libro_id",referencedColumnName = "id")
    public Libro libro;

    @Id
    @GeneratedValue
    public int id;

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public Copia(Libro libro) {
        this.libro = libro;
    }
}
