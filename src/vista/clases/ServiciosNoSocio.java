package vista.clases;

public class ServiciosNoSocio {
    // Atributos
    private final String idTarjetaSocio = "Compra como invitado";
    private final String apellidoCliente = "Compra como invitado";
    private final String tarjetaCreditoCliente;
    private final String nombreServicio;
    private final String descripcionServicio;
    private final double precioServicio;
    private final double ivaServicio;
    private final double totalServicio;
    private final int opcion;
    private final String nombreEmpleado;
    private final String areaTrabajoEmpleado;
    
    // Constructor
    public ServiciosNoSocio(String tarjetaCreditoCliente, String nombreServicio, String descripcionServicio,
            double precioServicio, double ivaServicio, int opcion, String nombreEmpleado,
            String areaTrabajoEmpleado) {
        this.tarjetaCreditoCliente = tarjetaCreditoCliente;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.precioServicio = precioServicio;
        this.ivaServicio = ivaServicio;
        this.totalServicio = precioServicio + ivaServicio;
        this.opcion = opcion;
        this.nombreEmpleado = nombreEmpleado;
        this.areaTrabajoEmpleado = areaTrabajoEmpleado;
    }
    // Metodos
    // Formato de la tarjeta de credito
    public String formatoTarjetaCredito() {
        String formatoTarjeta = "**** **** **** " + tarjetaCreditoCliente.substring(12);
        return formatoTarjeta;
    }
    
    

    @Override
    public String toString() {
        return "Id tarjeta de socio: " + idTarjetaSocio + "\n" +
                "Nombre cliente: " + apellidoCliente + "\n" +
                "Tarjeta de credito: " + formatoTarjetaCredito() + "\n" 
                + "Nombre del servicio: " + nombreServicio + "\n" +
                "Descripcion del servicio: " + descripcionServicio + "\n" +
                "Precio del servicio: " + precioServicio + "\n" +
                "IVA del servicio: " + ivaServicio + "\n" +
                "Total del servicio: " + totalServicio + "\n" +
                "Valoracion del servicio: " + opcion + "\n" 
                + "Empleado: " + nombreEmpleado + "\n" +
                "Area de trabajo: " + areaTrabajoEmpleado + "\n";
    }
    // Getters
    public String getIdTarjetaSocio() {
        return idTarjetaSocio;
    }
    public String getApellidoCliente() {
        return apellidoCliente;
    }
    public String getTarjetaCreditoCliente() {
        return tarjetaCreditoCliente;
    }
    public String getNombreServicio() {
        return nombreServicio;
    }
    public String getDescripcionServicio() {
        return descripcionServicio;
    }
    public double getPrecioServicio() {
        return precioServicio;
    }
    public double getIvaServicio() {
        return ivaServicio;
    }
    public double getTotalServicio() {
        return totalServicio;
    }
    public int getOpcion() {
        return opcion;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public String getAreaTrabajoEmpleado() {
        return areaTrabajoEmpleado;
    }
    
    // Constructor
    
}
