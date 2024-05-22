package modelo.empleados;

public class EncargadoBazar extends Empleado{
    //Atributos
    private final String area = "Articulos de Bazar";

    //Constructor
    public EncargadoBazar(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }
}
