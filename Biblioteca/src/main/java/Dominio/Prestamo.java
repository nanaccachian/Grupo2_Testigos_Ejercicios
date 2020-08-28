package Dominio;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Prestamo {
    private Copia copia;
    private LocalDate fechaDeInicio;
    private Lector lector;
    private boolean multa = false;

    public boolean getMulta() {
        return multa;
    }

    public void multar() {
        if (DAYS.between(LocalDate.now(),fechaDeInicio) > 30)
            multa = true;
    }
}
