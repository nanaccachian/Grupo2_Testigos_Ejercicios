package Visitor;

public class InteresBancario extends Visitor {

    public void visit(TarjetaDeCredito tarjetaDeCredito) {
        tarjetaDeCredito.setInteresAcumulado((float) (tarjetaDeCredito.getInteresAcumulado() + 0.05));
    }
    public void visit(Cuenta cuenta) {
        cuenta.setMonto(cuenta.getMonto()*0.99);
    }
}
