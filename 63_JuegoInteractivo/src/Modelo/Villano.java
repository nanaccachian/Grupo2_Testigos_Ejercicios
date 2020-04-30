package Modelo;

public class Villano extends Personaje implements Cloneable{

    public Villano(String nombre, float peso, float altura, int imagen, int inteligencia) {
        super(nombre,peso,altura,imagen,inteligencia);
    }

    @Override
    public Villano clonar() throws CloneNotSupportedException {
        return (Villano) this.clone();
    }
}
