package modelo.empleados;

public class Frutero extends Empleado{
    //Atributos
    private final String area = "Frutero";

    //Constructor
    public Frutero(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }
}
