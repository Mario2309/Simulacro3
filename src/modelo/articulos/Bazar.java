package modelo.articulos;

public class Bazar extends Articulo{
    // Atributos

    private final String Tipo = "Bazar";
    private final double IVA = 1.21;
    
    public Bazar(String nombre, String tipo, double precio, double iVA) {
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
