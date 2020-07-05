package Visitor;

public class TarjetaDeCredito extends Visitable {

    private float interesAcumulado;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public float getInteresAcumulado() {
        return interesAcumulado;
    }

    public void setInteresAcumulado(float interesAcumulado) {
        this.interesAcumulado = interesAcumulado;
    }
}
