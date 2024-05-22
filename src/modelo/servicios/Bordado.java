package modelo.servicios;

public class Bordado extends Servicio{
    private final String descripcion = "Este servicio consiste en realizar bordados en todo tipo de prendas";
    private final double IVA = 1.21;
    
    public Bordado(String nombre, String descripcion, double precio, double iVA) {
        super(nombre, descripcion, precio, iVA);
        super.IVA = this.IVA;
        super.descripcion = this.descripcion;
        //TODO Auto-generated constructor stub
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public double getIVA() {
        return IVA;
    }
}
