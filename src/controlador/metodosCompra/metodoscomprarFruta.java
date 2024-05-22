package controlador.metodosCompra;

import java.util.ArrayList;

import modelo.articulos.Articulo;
import modelo.articulos.Fruta;
import modelo.empleados.Empleado;
import modelo.empleados.Frutero;
import vista.clases.Cliente;
import vista.clases.DetallesVenta;
import vista.clases.Menu;
import vista.clases.Supermercado;
import vista.clases.VentasNoSocio;
import vista.clases.VentasSocios;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodoscomprarFruta {
    private static String nombreFrutero(Supermercado supermercado, String nombreEmpleado) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof Frutero) {
                nombreEmpleado = empleado.getNombre();
            }
        }
        return nombreEmpleado;
    }

    private static String areaFrutero(Supermercado supermercado, String area) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof Frutero) {
                area = empleado.getArea();
            }
        }
        return area;
    }

    public static void comprarFruta(Cliente cliente, Supermercado supermercado) {
        String nombreEmpleado ="", area="";
        ArrayList<DetallesVenta> detallesVentas = new ArrayList<>();
        boolean seguirComprando = true;
        do {
                // Se vuelve a mostrar el menú de compra
                procesoCompraFruta(supermercado, detallesVentas);
                // Se pregunta si se quiere seguir comprando
                System.out.println(Texto.deseaSeguirComprando);
                seguirComprando = ES.leerSiNo();
        } while (seguirComprando == true);
            if (cliente.isEsSocio()) {
                VentasSocios newVenta = new VentasSocios(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), nombreFrutero(supermercado, nombreEmpleado), areaFrutero(supermercado, area), detallesVentas);
                Menu.generarTicketSocio(newVenta);
            } else {
                VentasNoSocio newVenta = new VentasNoSocio(cliente.getTarjertaCredito(), nombreFrutero(supermercado, nombreEmpleado), areaFrutero(supermercado, area), detallesVentas);
                Menu.generarTicketNoSocio(newVenta);
            }
        


    }

    private static void procesoCompraFruta(Supermercado supermercado, ArrayList<DetallesVenta> detallesVentas) {
        // Se muestra una lista de las frutas disponibles
        System.out.println(Texto.seleccionarProducto);
        // Se muestra el nombre y el precio de cada fruta y se pide al usuario que seleccione una fruta
        Articulo fruta = listarFrutas(supermercado);
        // Se muestra el nombre y el precio de la fruta seleccionada
        int cantidad = determinarCantidad();
        // Se agrega la fruta al carrito de compras del cliente
        DetallesVenta newDetalle = new DetallesVenta(fruta.getNombre(), cantidad, fruta.getPrecio(), fruta.getIVA());
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

    private static Articulo listarFrutas(Supermercado supermercado) {
        ArrayList<Articulo> articuloS = supermercado.articulos;
        ArrayList<Articulo> frutas = new ArrayList<>();
        for (Articulo articulo : articuloS) {
            if (articulo  instanceof Fruta) {
                frutas.add(articulo);
            }
        }
        int contador = 1;
        for (Articulo fruta : frutas) {
                System.out.println(contador + ". " + fruta.getNombre() + " - " + fruta.getPrecio() + " euros");
                contador++;
            }
        int opcion = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido un número de producto válido
        while (opcion < 1 || opcion > frutas.size()) {
            System.out.println("Opción no válida");
            opcion = ES.pedirEntero();
        }
        return frutas.get(opcion - 1);
    }
}
