package modelo.empleados;

public class Carnicero extends Empleado{
    //Atributos
    private final String area = "Carnicero";

    //Constructor
    public Carnicero(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }

}
