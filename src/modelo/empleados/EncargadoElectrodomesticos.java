package modelo.empleados;

public class EncargadoElectrodomesticos extends Empleado{
    //Atributos
    private final String area = "Encargado de Electrodomesticos";

    //Constructor
    public EncargadoElectrodomesticos(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    //Metodos

    // Getters
    public String getArea() {
        return area;
    }
}
