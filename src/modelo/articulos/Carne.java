package modelo.articulos;

public class Carne extends Articulo{
    // Atributos

    private final String Tipo = "Carne";
    private final double IVA = 1.10;
    
    public Carne(String nombre, String tipo, double precio, double iVA) {
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
