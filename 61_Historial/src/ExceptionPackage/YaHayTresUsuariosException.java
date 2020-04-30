package ExceptionPackage;

public class YaHayTresUsuariosException extends Exception {

    public YaHayTresUsuariosException() {
        super("Ya hay tres usuarios creados");
    }
}