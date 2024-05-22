package modelo.servicios;

public class ArregloElectrodomestico extends Servicio{
    private final String descripcion = "Este servicio consiste en realizar pequeñas reparaciones en todo ripo de electrodomesticos";
    private final double IVA = 1.21;
    
    public ArregloElectrodomestico(String nombre, String descripcion, double precio, double iVA) {
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
