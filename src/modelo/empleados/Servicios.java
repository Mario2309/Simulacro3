package modelo.empleados;

public class Servicios extends Empleado{
    //Atributos
    private final String area = "Servicios";

    //Constructor
    public Servicios(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }

}
