package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Copia> copias = new ArrayList<Copia>();
    private String nombre = "LuchoBiblioteca";
    private List<Prestamo> prestamos = new ArrayList<>();
    private Biblioteca instance = null;

    public Biblioteca() { }

    private Biblioteca getInstance() {
        if(instance == null)
            return new Biblioteca();
        else
            return instance;
    }
}
