package modelo.articulos;

public class Pescado extends Articulo{
    // Atributos

    private final String Tipo = "Pescado";
    private final double IVA = 1.10;
    
    
    public Pescado(String nombre, String tipo, double precio, double iVA) {
        super(nombre, tipo, precio, iVA);
        super.tipo = this.Tipo;
        super.IVA = this.IVA;
    }
    public String getTipo() {
        return Tipo;
    }

    public double getIVA() {
        return IVA;
    }
    
}