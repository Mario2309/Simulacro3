package modelo.servicios;

public abstract class Servicio {
    protected final String nombre;
    protected String descripcion;
    protected final double precio;
    protected double IVA;
    protected final double precioIVA;
    
    public Servicio(String nombre, String descripcion, double precio, double iVA) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        IVA = iVA;
        precioIVA = precio*iVA;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public double getIVA() {
        return IVA;
    }
    public void setIVA(double iVA) {
        IVA = iVA;
    }
    public double getPrecioIVA() {
        return precioIVA;
    }
    
}
