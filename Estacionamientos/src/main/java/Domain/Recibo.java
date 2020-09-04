package Domain;

public class Recibo {
    private float importe;
    private Ticket ticket;

    public Recibo(float importe, Ticket ticket) {
        this.importe = importe;
        this.ticket = ticket;
    }
}
