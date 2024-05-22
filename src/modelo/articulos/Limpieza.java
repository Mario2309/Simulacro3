package modelo.articulos;

public class Limpieza extends Articulo{
    // Atributos

    private final String Tipo = "Limpieza";
    private final double IVA = 1.21;
    
    public Limpieza(String nombre, String tipo, double precio, double iVA) {
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
