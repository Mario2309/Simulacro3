package modelo.empleados;

public class EncargadoFrescos extends Empleado{
    //Atributos
    private final String area = "Encargado de articulos frescos";

    //Constructor
    public EncargadoFrescos(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }
}
