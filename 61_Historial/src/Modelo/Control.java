package Modelo;

public class Control {

    private Usuario usuario;
    private Evento evento;
    private Historial historial;
    private Control control;

    public void hacerLasCosasQueTieneQueHacer() {
        historial.agregarRegistro(evento.ejecutar(usuario));
    }

    public void setUsuario(Usuario vUsuario) {
        this.usuario = vUsuario;
    }

    public void setEvento(Evento vEvento) {
        this.evento = vEvento;
    }

    private Control() {
        this.historial = Historial.getInstance();
    }

    public Control getInstance() {
        if (control == null) {
            control = new Control();
        }
        return control;
    }
}