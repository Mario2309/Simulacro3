package modelo.articulos;

public class Fruta extends Articulo{
    // Atributos

    private final String Tipo = "Frutería";
    private final double IVA = 1.21; 

    public Fruta(String nombre, String tipo, double precio, double iVA) {
        super(nombre, tipo, precio, iVA);
        super.tipo = this.Tipo;
        super.IVA = this.IVA;
        //TODO Auto-generated constructor stub
    }

    public String getTipo() {
        return Tipo;
    }

    public double getIVA() {
        return IVA;
    }

    

}
