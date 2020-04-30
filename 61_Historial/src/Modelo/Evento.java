package Modelo;

public class Evento {

    private String nombre;
    private String desc;

    public Registro ejecutar(Usuario usuario) {
        return new Registro(this,usuario);
    }
}