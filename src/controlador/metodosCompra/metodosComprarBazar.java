package controlador.metodosCompra;

import java.util.ArrayList;

import modelo.articulos.Articulo;
import modelo.articulos.Bazar;
import modelo.empleados.Empleado;
import modelo.empleados.EncargadoBazar;
import vista.clases.Cliente;
import vista.clases.DetallesVenta;
import vista.clases.Menu;
import vista.clases.Supermercado;
import vista.clases.VentasNoSocio;
import vista.clases.VentasSocios;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodosComprarBazar {
    private static String nombreEncargadoBazar(Supermercado supermercado, String nombreEmpleado) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof EncargadoBazar) {
                nombreEmpleado = empleado.getNombre();
            }
        }
        return nombreEmpleado;
    }

    private static String areaEncargadoBazar(Supermercado supermercado, String area) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof EncargadoBazar) {
                area = empleado.getArea();
            }
        }
        return area;
    }

    public static void comprarBazar(Cliente cliente, Supermercado supermercado) {
        String nombreEmpleado ="", area="";
        ArrayList<DetallesVenta> detallesVentas = new ArrayList<>();
        boolean seguirComprando = true;
        do {
                // Se vuelve a mostrar el menú de compra
                procesoCompraBazar(supermercado, detallesVentas);
                // Se pregunta si se quiere seguir comprando
                System.out.println(Texto.deseaSeguirComprando);
                seguirComprando = ES.leerSiNo();
        } while (seguirComprando == true);
        if (cliente.isEsSocio() == true) {
            VentasSocios newVenta = new VentasSocios(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), nombreEncargadoBazar(supermercado, nombreEmpleado), areaEncargadoBazar(supermercado, area), detallesVentas);
            Menu.generarTicketSocio(newVenta);
        } else {
            VentasNoSocio newVenta = new VentasNoSocio(cliente.getTarjertaCredito(), nombreEncargadoBazar(supermercado, nombreEmpleado), areaEncargadoBazar(supermercado, area), detallesVentas);
            Menu.generarTicketNoSocio(newVenta);
        }
    }

    private static void procesoCompraBazar(Supermercado supermercado, ArrayList<DetallesVenta> detallesVentas) {
        // Se muestra una lista de las bazares disponibles
        System.out.println(Texto.seleccionarProducto);
        // Se muestra el nombre y el precio de cada Bazar y se pide al usuario que seleccione una Bazar
        Articulo Bazar = listarbazares(supermercado);
        // Se muestra el nombre y el precio de la Bazar seleccionada
        int cantidad = determinarCantidad();
        // Se agrega la Bazar al carrito de compras del cliente
        DetallesVenta newDetalle = new DetallesVenta(Bazar.getNombre(), cantidad, Bazar.getPrecio(), Bazar.getIVA());
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

    private static Articulo listarbazares(Supermercado supermercado) {
        ArrayList<Articulo> articuloS = supermercado.articulos;
        ArrayList<Articulo> bazares = new ArrayList<>();
        for (Articulo articulo : articuloS) {
            if (articulo  instanceof Bazar) {
                bazares.add(articulo);
            }
        }
        int contador = 1;
        for (Articulo Bazar : bazares) {
                System.out.println(contador + ". " + Bazar.getNombre() + " - " + Bazar.getPrecio() + " euros");
                contador++;
            }
        int opcion = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido un número de producto válido
        while (opcion < 1 || opcion > bazares.size()) {
            System.out.println("Opción no válida");
            opcion = ES.pedirEntero();
        }
        return bazares.get(opcion - 1);
    }
}
