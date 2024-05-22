package modelo.articulos;

public class Electrodomestico extends Articulo{
    // Atributos

    private final String Tipo = "Electrodoméstico";
    private final double IVA = 1.21;
    
    public Electrodomestico(String nombre, String tipo, double precio, double iVA) {
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
