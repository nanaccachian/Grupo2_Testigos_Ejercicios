package Modelo;

import ExceptionPackage.YaHayTresUsuariosException;

public class Usuario {

    private Integer id;
    private String nombre;
    private static Integer usuariosCreados = 0;

    private Usuario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        usuariosCreados++;
    }

    public Usuario getInstance(Integer vID, String vNombre) throws YaHayTresUsuariosException {
        if (usuariosCreados < 3) {
            return new Usuario(vID, vNombre);
        } else {
            throw new YaHayTresUsuariosException();
        }
    }
}