package modelo.empleados;

public class EncargadoLimpieza extends Empleado{
    //Atributos
    private final String area = "Encargado de Limpieza";

    //Constructor
    public EncargadoLimpieza(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }
}
