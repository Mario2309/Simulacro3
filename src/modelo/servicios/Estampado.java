package modelo.servicios;

public class Estampado extends Servicio{
    private final String descripcion = "Este servicio consiste en realizar estampados en todo tipo de prendas";
    private final double IVA = 1.21;
    
    public Estampado(String nombre, String descripcion, double precio, double iVA) {
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
