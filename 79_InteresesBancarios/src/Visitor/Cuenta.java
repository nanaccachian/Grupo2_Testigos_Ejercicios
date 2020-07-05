package Visitor;

public abstract class Cuenta extends Visitable {

    private double monto;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
