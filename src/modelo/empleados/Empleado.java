package modelo.empleados;

public abstract class Empleado {
    // Atributos
    protected final String nombre;
    protected final String apellido;
    protected final String area;

    // Constructor
    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = "";
    }

    
    // Métodos
    
    // Getters
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public String getArea() {
        return area;
    }
}
