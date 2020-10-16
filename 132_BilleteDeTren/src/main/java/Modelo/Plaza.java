package Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class Plaza {

    private Vagon vagon;

    private boolean ventanilla;

    private float precio;

    @Getter
    private PlazaIdentifier nroPlaza;

    public boolean esFumador() {
        return vagon.esFumador();
    }

    public boolean esPreferencial() {
        return vagon.esPreferencial();
    }
}
