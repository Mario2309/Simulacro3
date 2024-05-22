package modelo.articulos;

public abstract class Articulo {
    
    // Atributos
    protected final String nombre;
    protected String tipo;
    protected final double precio;
    protected double IVA;
    protected final double precioIVA;
    
    // Constructor
    
    public Articulo(String nombre, String tipo, double precio, double iVA) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        IVA = iVA;
        precioIVA = precio*iVA;
    }

    // Metodos

    // Getters y Setters
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIVA() {
        return IVA;
    }

    public double getPrecioIVA() {
        return precioIVA;
    }
    
}
