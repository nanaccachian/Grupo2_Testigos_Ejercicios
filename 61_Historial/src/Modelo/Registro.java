package Modelo;

import java.util.Date;

public class Registro {

    private Evento evento;
    private Date fechaYHora;
    private Usuario usuario;

    public Registro(Evento vEvento, Usuario vUsuario) {
        this.evento = vEvento;
        this.fechaYHora = new Date(System.currentTimeMillis());
        this.usuario = vUsuario;
    }
}