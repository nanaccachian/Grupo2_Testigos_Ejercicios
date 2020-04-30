package Modelo;

public class Monstruo extends Personaje implements Cloneable{

    public Monstruo(String nombre, float peso, float altura, int imagen, int inteligencia) {
        super(nombre,peso,altura,imagen,inteligencia);
    }

    @Override
    public Monstruo clonar() throws CloneNotSupportedException {
        return (Monstruo) this.clone();
    }
}
