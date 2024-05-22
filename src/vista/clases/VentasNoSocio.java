package vista.clases;
import java.util.ArrayList;

public class VentasNoSocio {
    
    // Atributos
    private final String idTarjetaSocio = "Compra como invitado";
    private final String apellidoCliente = "Compra como invitado";
    private final String tarjetaCreditoCliente;
    private final String nombreEmpleado;
    private final String areaTrabajoEmpleado;
    private ArrayList<DetallesVenta> listaDetallesVenta;
    
    // Constructor
    public VentasNoSocio(String tarjetaCreditoCliente, String nombreEmpleado, String areaTrabajoEmpleado,
            ArrayList<DetallesVenta> listaDetallesVenta) {
        this.tarjetaCreditoCliente = tarjetaCreditoCliente;
        this.nombreEmpleado = nombreEmpleado;
        this.areaTrabajoEmpleado = areaTrabajoEmpleado;
        this.listaDetallesVenta = listaDetallesVenta;
    }
    // Metodos
    public void agregarDetalleVenta(DetallesVenta detalleVenta) {
        listaDetallesVenta.add(detalleVenta);
    }

    // Formato de la tarjeta de credito
    public String formatoTarjetaCredito() {
        String formatoTarjeta = "**** **** **** " + tarjetaCreditoCliente.substring(12);
        return formatoTarjeta;
    }

    // Metodo para listar la venta de forma detallada
    public String listarVenta() {
        String detalles = "";
        for (DetallesVenta detallesVenta : listaDetallesVenta) {
            detalles = detallesVenta.getCantidad() + "X" + detallesVenta.getNombreArticulo() + " " + detallesVenta.getPrecio() + " " + detallesVenta.getTotalConIva() + "\n-----------------------------";
        }
        return "Detalles de la venta:\n" + detalles;
    }

    // Metodo para calcular el total de la venta
    public double calcularTotalVenta() {
        double totalVenta = 0;
        for (DetallesVenta detallesVenta : listaDetallesVenta) {
            totalVenta += detallesVenta.getTotalConIva();
        }
        return totalVenta;
    }

    @Override
    public String toString() {
        return "Id tarjeta de socio: " + idTarjetaSocio + "\n" +
                "Nombre cliente: " + apellidoCliente + "\n" +
                "Tarjeta de credito: " + formatoTarjetaCredito() + "\n" +
                listarVenta() + "\n" +
                "Total de la venta: " + calcularTotalVenta() + "\n"
                + "Empleado: " + nombreEmpleado + "\n" +
                "Area de trabajo: " + areaTrabajoEmpleado + "\n";
    }
    
    // Getters y Setters
    public String getIdTarjetaSocio() {
        return idTarjetaSocio;
    }
    public String getApellidoCliente() {
        return apellidoCliente;
    }
    public String getTarjetaCreditoCliente() {
        return tarjetaCreditoCliente;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public String getAreaTrabajoEmpleado() {
        return areaTrabajoEmpleado;
    }
    public ArrayList<DetallesVenta> getListaDetallesVenta() {
        return listaDetallesVenta;
    }
    public void setListaDetallesVenta(ArrayList<DetallesVenta> listaDetallesVenta) {
        this.listaDetallesVenta = listaDetallesVenta;
    }
    
}
