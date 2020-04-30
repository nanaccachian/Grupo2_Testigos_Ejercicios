package Modelo;

public class Heroe extends Personaje implements Cloneable{

    public Heroe(String nombre, float peso, float altura, int imagen, int inteligencia) {
        super(nombre,peso,altura,imagen,inteligencia);
    }

    @Override
    public Heroe clonar() throws CloneNotSupportedException {
        return (Heroe) this.clone();
    }
}
