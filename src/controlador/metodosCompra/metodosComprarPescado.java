package controlador.metodosCompra;

import java.util.ArrayList;

import modelo.articulos.Articulo;
import modelo.articulos.Pescado;
import modelo.empleados.Empleado;
import modelo.empleados.Pescadero;
import vista.clases.Cliente;
import vista.clases.DetallesVenta;
import vista.clases.Menu;
import vista.clases.Supermercado;
import vista.clases.VentasNoSocio;
import vista.clases.VentasSocios;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodosComprarPescado {
    private static String nombrePescadero(Supermercado supermercado, String nombreEmpleado) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof Pescadero) {
                nombreEmpleado = empleado.getNombre();
            }
        }
        return nombreEmpleado;
    }

    private static String areaPescadero(Supermercado supermercado, String area) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof Pescadero) {
                area = empleado.getArea();
            }
        }
        return area;
    }

    public static void comprarPescado(Cliente cliente, Supermercado supermercado) {
        String nombreEmpleado ="", area="";
        ArrayList<DetallesVenta> detallesVentas = new ArrayList<>();
        boolean seguirComprando = true;
        do {
                // Se vuelve a mostrar el menú de compra
                procesoCompraPescado(supermercado, detallesVentas);
                // Se pregunta si se quiere seguir comprando
                System.out.println(Texto.deseaSeguirComprando);
                seguirComprando = ES.leerSiNo();
        } while (seguirComprando == true);
            if (cliente.isEsSocio() == true) {
                VentasSocios newVenta = new VentasSocios(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), nombrePescadero(supermercado, nombreEmpleado), areaPescadero(supermercado, area), detallesVentas);
                Menu.generarTicketSocio(newVenta);
            } else {
                VentasNoSocio newVenta = new VentasNoSocio(cliente.getTarjertaCredito(), nombrePescadero(supermercado, nombreEmpleado), areaPescadero(supermercado, area), detallesVentas);
                Menu.generarTicketNoSocio(newVenta);
            }
    }

    private static void procesoCompraPescado(Supermercado supermercado, ArrayList<DetallesVenta> detallesVentas) {
        // Se muestra una lista de las Pescado disponibles
        System.out.println(Texto.seleccionarProducto);
        // Se muestra el nombre y el precio de cada Pescado y se pide al usuario que seleccione una Pescado
        Articulo Pescado = listarPescado(supermercado);
        // Se muestra el nombre y el precio de la Pescado seleccionada
        int cantidad = determinarCantidad();
        // Se agrega la Pescado al carrito de compras del cliente
        DetallesVenta newDetalle = new DetallesVenta(Pescado.getNombre(), cantidad, Pescado.getPrecio(), Pescado.getIVA());
        detallesVentas.add(newDetalle);
    }

    private static int determinarCantidad() {
        // Se pregunta al usuario cuántas unidades desea comprar
        System.out.println(Texto.cantidadProducto);
        int cantidad = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido una cantidad válida
        while (cantidad <= 0) {
            System.out.println("Cantidad no válida");
            cantidad = ES.pedirEntero();
        }
        return cantidad;
    }

    private static Articulo listarPescado(Supermercado supermercado) {
        ArrayList<Articulo> articuloS = supermercado.articulos;
        ArrayList<Articulo> Pescado = new ArrayList<>();
        for (Articulo articulo : articuloS) {
            if (articulo  instanceof Pescado) {
                Pescado.add(articulo);
            }
        }
        int contador = 1;
        for (Articulo pescado : Pescado) {
                System.out.println(contador + ". " + pescado.getNombre() + " - " + pescado.getPrecio() + " euros");
                contador++;
            }
        int opcion = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido un número de producto válido
        while (opcion < 1 || opcion > Pescado.size()) {
            System.out.println("Opción no válida");
            opcion = ES.pedirEntero();
        }
        return Pescado.get(opcion - 1);
    }
}
