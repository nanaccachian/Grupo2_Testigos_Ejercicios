package UserInterface;

import Domain.Ticket;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        InterfazDeUsuario.setTicket(new Ticket(10));
        while (true) {
            InterfazDeUsuario.seIntrodujoTicket();
            Thread.sleep(5000);
        }

    }
}
