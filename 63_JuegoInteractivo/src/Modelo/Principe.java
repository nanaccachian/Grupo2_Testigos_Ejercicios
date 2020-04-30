package Modelo;

public class Principe extends Personaje implements Cloneable{

    public Principe(String nombre, float peso, float altura, int imagen, int inteligencia) {
        super(nombre,peso,altura,imagen,inteligencia);
    }

    @Override
    public Principe clonar() throws CloneNotSupportedException {
        return (Principe) this.clone();
    }
}
