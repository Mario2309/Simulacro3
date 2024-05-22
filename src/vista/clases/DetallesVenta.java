package vista.clases;
public class DetallesVenta {
    private final String nombreArticulo;
    private final int cantidad;
    private final double precio;
    private final double iva;
    private final double totalSinIva;
    private final double totalConIva;
    // Constructor
    public DetallesVenta(String nombreArticulo, int cantidad, double precio, double iva) {
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.iva = iva;
        this.totalSinIva = cantidad * precio;
        this.totalConIva = totalSinIva * iva;
    }
    public String getNombreArticulo() {
        return nombreArticulo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public double getIva() {
        return iva;
    }
    public double getTotalSinIva() {
        return totalSinIva;
    }
    public double getTotalConIva() {
        return totalConIva;
    }
    
    
}
