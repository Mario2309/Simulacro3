package modelo.servicios;

public class ProteccionMovil extends Servicio {
    private final String descripcion = "Este servicio consiste en poner protectores de pantalla en todo tipo de dispositivos moviles";
    private final double IVA = 1.21;
    
    public ProteccionMovil(String nombre, String descripcion, double precio, double iVA) {
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
