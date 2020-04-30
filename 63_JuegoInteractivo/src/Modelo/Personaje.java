package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje implements Cloneable{
    private String nombre;
    private float peso;
    private float altura; //en cm
    private int imagen; //suponemos que es un valor de su imagen si es positiva o negativa
    private int inteligencia;
    private List<Habilidad> habilidades = new ArrayList<Habilidad>();
    private List<String> caracteristicas = new ArrayList<String>();

    public Personaje(String nombre, float peso, float altura, int imagen, int inteligencia) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.imagen = imagen;
        this.inteligencia = inteligencia;
    }

    public void usarHabilidad(Habilidad habilidad) {
        habilidad.usar(this);
    }
    
    public void definirCaracteristicas() {
        personalidadInteligencia();
        personalidadImagen();
        caracteristicaAltura();
        caracteristicaPeso();
    } 

    public void personalidadInteligencia() {
        if (inteligencia > 60) //VALOR ARBITRARIO
            caracteristicas.add("listo");
        else
            caracteristicas.add("bobo");
    }

    public void personalidadImagen() {
        if (imagen > 60) //VALOR ARBITRARIO
            caracteristicas.add("bueno");
        else
            caracteristicas.add("malo");
    }

    public void caracteristicaAltura() {
        if (imagen > 170) //VALOR ARBITRARIO
            caracteristicas.add("alto");
        else
            caracteristicas.add("bajo");
    }

    public void caracteristicaPeso() {
        if (imagen > 80) //VALOR ARBITRARIO
            caracteristicas.add("gordo");
        else
            caracteristicas.add("flaco");
    }

    public abstract Object clonar() throws CloneNotSupportedException;


}

