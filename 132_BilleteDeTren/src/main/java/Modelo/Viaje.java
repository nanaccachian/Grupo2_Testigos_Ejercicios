package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Viaje {

    @Getter
    private int id;

    private List<Billete> billetes = new ArrayList<Billete>();

    @Getter
    private Horario horario;
    private Tren tren;
    private Set<Plaza> plazasDisponibles = new HashSet<Plaza>();
    private float precioPreferencial;
    private float precioTurista;

    public void reservarPlaza(Plaza plaza) {
        plazasDisponibles.remove(plaza);
    }

    public void addBillete(Billete billete) {
        billetes.add(billete);
    }

    public Plaza buscarPlazaDisponible(boolean fumador, boolean preferencial, boolean ventanilla) {

        Plaza plaza;

        Set<Plaza> plazasPosibles = new HashSet<>();

        if (fumador) {
            plazasPosibles.addAll(plazasDisponibles.stream().filter(p -> p.esFumador()).collect(Collectors.toSet()));
        }

        if (preferencial) {
            plazasPosibles
                    .addAll(plazasDisponibles.stream().filter(p -> p.esPreferencial()).collect(Collectors.toSet()));
        }

        if (ventanilla) {
            plazasPosibles.addAll(plazasDisponibles.stream().filter(p -> p.isVentanilla()).collect(Collectors.toSet()));
        }

        Optional<Plaza> plazaOpcional = plazasPosibles.stream().findFirst();

        if (plazaOpcional.isEmpty())
            return null;

        plaza = plazaOpcional.get();

        return plaza;
    }

    public Viaje(int id, Horario horario, Tren tren, float precioPreferencial, float precioTurista) {
        this.id = id;
        this.horario = horario;
        this.tren = tren;
        this.precioPreferencial = precioPreferencial;
        this.precioTurista = precioTurista;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 30; j++)
                plazasDisponibles.add(new Plaza(tren.getVagones().get(i + 1), false, precioPreferencial,
                        new PlazaIdentifier(i + 1, j + 1)));
            for (int j = 0; j < 30; j++)
                plazasDisponibles.add(new Plaza(tren.getVagones().get(i + 1), true, precioPreferencial,
                        new PlazaIdentifier(i + 1, j + 1)));
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 30; j++)
                plazasDisponibles.add(new Plaza(tren.getVagones().get(i + 5), false, precioTurista,
                        new PlazaIdentifier(i + 5, j + 1)));
            for (int j = 0; j < 30; j++)
                plazasDisponibles.add(new Plaza(tren.getVagones().get(i + 5), true, precioTurista,
                        new PlazaIdentifier(i + 5, j + 1)));
        }
    }
}
