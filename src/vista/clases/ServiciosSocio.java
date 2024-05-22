package vista.clases;

public class ServiciosSocio {
    private static int idVenta;
    private final String nombreCliente;
    private final String apellidoCliente;
    private final String tarjetaCreditoCliente;
    private final String nombreServicio;
    private final String descripcionServicio;
    private final double precioServicio;
    private final double ivaServicio;
    private final double totalServicio;
    private final int valoracionServicio;
    private final String nombreEmpleado;
    private final String areaTrabajoEmpleado;
    
    // Constructor
    public ServiciosSocio(int idSocio, String nombreCliente, String apellidoCliente, String tarjetaCreditoCliente,
            String nombreServicio, String descripcionServicio, double precioServicio, double ivaServicio,
             int valoracionServicio, String nombreEmpleado, String areaTrabajoEmpleado) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.tarjetaCreditoCliente = tarjetaCreditoCliente;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.precioServicio = precioServicio;
        this.ivaServicio = ivaServicio;
        this.totalServicio = precioServicio * ivaServicio;
        this.valoracionServicio = valoracionServicio;
        this.nombreEmpleado = nombreEmpleado;
        this.areaTrabajoEmpleado = areaTrabajoEmpleado;
        idVenta = idSocio;
    }
    // Metodos
    
    // Formato de la tarjeta de credito
    public String formatoTarjetaCredito() {
        String formatoTarjeta = "**** **** **** " + tarjetaCreditoCliente.substring(12);
        return formatoTarjeta;
    }
    
    

    @Override
    public String toString() {
        return "Id tarjeta de socio: " + idVenta + "\n" +
                "Nombre cliente: " + nombreCliente + "\n" +
                "Apellido cliente: " + apellidoCliente + "\n" +
                "Tarjeta de credito: " + formatoTarjetaCredito() + "\n" 
                + "Nombre del servicio: " + nombreServicio + "\n" +
                "Descripcion del servicio: " + descripcionServicio + "\n" +
                "Precio del servicio: " + precioServicio + "\n" +
                "IVA del servicio: " + ivaServicio + "\n" +
                "Total del servicio: " + totalServicio + "\n" +
                "Valoracion del servicio: " + valoracionServicio + "\n" 
                + "Empleado: " + nombreEmpleado + "\n" +
                "Area de trabajo: " + areaTrabajoEmpleado + "\n";
    }
    // Getters 
    public String getNombreServicio() {
        return nombreServicio;
    }
    
    public String getDescripcionServicio() {
        return descripcionServicio;
    }
    public double getPrecioServicio() {
        return precioServicio;
    }
    public int getValoracionServicio() {
        return valoracionServicio;
    }
    public static int getIdVenta() {
        return idVenta;
    }
    public static void setIdVenta(int idVenta) {
        ServiciosSocio.idVenta = idVenta;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public String getApellidoCliente() {
        return apellidoCliente;
    }
    public String getTarjetaCreditoCliente() {
        return tarjetaCreditoCliente;
    }

    public double getIvaServicio() {
        return ivaServicio;
    }

    public double getTotalServicio() {
        return totalServicio;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getAreaTrabajoEmpleado() {
        return areaTrabajoEmpleado;
    }


}
