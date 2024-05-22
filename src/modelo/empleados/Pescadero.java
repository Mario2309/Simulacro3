package modelo.empleados;

public class Pescadero extends Empleado{
    //Atributos
    private final String area = "Pescadero";

    //Constructor
    public Pescadero(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }
}
