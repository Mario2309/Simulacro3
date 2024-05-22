package controlador.metodosCompra;

import java.util.ArrayList;

import modelo.articulos.Articulo;
import modelo.articulos.Fresco;
import modelo.empleados.Empleado;
import modelo.empleados.EncargadoFrescos;
import vista.clases.Cliente;
import vista.clases.DetallesVenta;
import vista.clases.Menu;
import vista.clases.Supermercado;
import vista.clases.VentasNoSocio;
import vista.clases.VentasSocios;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodosComprarFrescos {
    private static String nombreEncargadoFrescos(Supermercado supermercado, String nombreEmpleado) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof EncargadoFrescos) {
                nombreEmpleado = empleado.getNombre();
            }
        }
        return nombreEmpleado;
    }

    private static String areaEncargadoFrescos(Supermercado supermercado, String area) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof EncargadoFrescos) {
                area = empleado.getArea();
            }
        }
        return area;
    }

    public static void comprarfresco(Cliente cliente, Supermercado supermercado) {
        String nombreEmpleado ="", area="";
        ArrayList<DetallesVenta> detallesVentas = new ArrayList<>();
        boolean seguirComprando = true;
        do {
                // Se vuelve a mostrar el menú de compra
                procesoComprafresco(supermercado, detallesVentas);
                // Se pregunta si se quiere seguir comprando
                System.out.println(Texto.deseaSeguirComprando);
                seguirComprando = ES.leerSiNo();
        } while (seguirComprando == true);
            if (cliente.isEsSocio() == true) {
                VentasSocios newVenta = new VentasSocios(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), nombreEncargadoFrescos(supermercado, nombreEmpleado), areaEncargadoFrescos(supermercado, area), detallesVentas);
                Menu.generarTicketSocio(newVenta);
            } else {
                VentasNoSocio newVenta = new VentasNoSocio(cliente.getTarjertaCredito(), nombreEncargadoFrescos(supermercado, nombreEmpleado), areaEncargadoFrescos(supermercado, area), detallesVentas);
                Menu.generarTicketNoSocio(newVenta);
            }
    }

    private static void procesoComprafresco(Supermercado supermercado, ArrayList<DetallesVenta> detallesVentas) {
        // Se muestra una lista de las Frescos disponibles
        System.out.println(Texto.seleccionarProducto);
        // Se muestra el nombre y el precio de cada fresco y se pide al usuario que seleccione una fresco
        Articulo fresco = listarFrescos(supermercado);
        // Se muestra el nombre y el precio de la fresco seleccionada
        int cantidad = determinarCantidad();
        // Se agrega la fresco al carrito de compras del cliente
        DetallesVenta newDetalle = new DetallesVenta(fresco.getNombre(), cantidad, fresco.getPrecio(), fresco.getIVA());
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

    private static Articulo listarFrescos(Supermercado supermercado) {
        ArrayList<Articulo> articuloS = supermercado.articulos;
        ArrayList<Articulo> Frescos = new ArrayList<>();
        for (Articulo articulo : articuloS) {
            if (articulo  instanceof Fresco) {
                Frescos.add(articulo);
            }
        }
        int contador = 1;
        for (Articulo fresco : Frescos) {
                System.out.println(contador + ". " + fresco.getNombre() + " - " + fresco.getPrecio() + " euros");
                contador++;
            }
        int opcion = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido un número de producto válido
        while (opcion < 1 || opcion > Frescos.size()) {
            System.out.println("Opción no válida");
            opcion = ES.pedirEntero();
        }
        return Frescos.get(opcion - 1);
    }
}
