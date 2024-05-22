package controlador.metodosCompra;

import java.util.ArrayList;

import modelo.articulos.Articulo;
import modelo.articulos.Electrodomestico;
import modelo.empleados.Empleado;
import modelo.empleados.EncargadoElectrodomesticos;
import vista.clases.Cliente;
import vista.clases.DetallesVenta;
import vista.clases.Menu;
import vista.clases.Supermercado;
import vista.clases.VentasNoSocio;
import vista.clases.VentasSocios;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodosComprarElectrodomesticos {
    private static String nombreEncargadoElectrodomesticos(Supermercado supermercado, String nombreEmpleado) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof EncargadoElectrodomesticos) {
                nombreEmpleado = empleado.getNombre();
            }
        }
        return nombreEmpleado;
    }

    private static String areaEncargadoElectrodomesticos(Supermercado supermercado, String area) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof EncargadoElectrodomesticos) {
                area = empleado.getArea();
            }
        }
        return area;
    }

    public static void comprarElectrodomestico(Cliente cliente, Supermercado supermercado) {
        String nombreEmpleado ="", area="";
        ArrayList<DetallesVenta> detallesVentas = new ArrayList<>();
        boolean seguirComprando = true;
        do {
                // Se vuelve a mostrar el menú de compra
                procesoCompraElectrodomestico(supermercado, detallesVentas);
                // Se pregunta si se quiere seguir comprando
                System.out.println(Texto.deseaSeguirComprando);
                seguirComprando = ES.leerSiNo();
        } while (seguirComprando == true);
        if (cliente.isEsSocio() == true) {
            VentasSocios newVenta = new VentasSocios(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), nombreEncargadoElectrodomesticos(supermercado, nombreEmpleado), areaEncargadoElectrodomesticos(supermercado, area), detallesVentas);
            Menu.generarTicketSocio(newVenta);
        } else {
            VentasNoSocio newVenta = new VentasNoSocio(cliente.getTarjertaCredito(), nombreEncargadoElectrodomesticos(supermercado, nombreEmpleado), areaEncargadoElectrodomesticos(supermercado, area), detallesVentas);
            Menu.generarTicketNoSocio(newVenta);
        }
        


    }

    private static void procesoCompraElectrodomestico(Supermercado supermercado, ArrayList<DetallesVenta> detallesVentas) {
        // Se muestra una lista de las electrodomesticos disponibles
        System.out.println(Texto.seleccionarProducto);
        // Se muestra el nombre y el precio de cada Electrodomestico y se pide al usuario que seleccione una Electrodomestico
        Articulo Electrodomestico = listarelectrodomesticos(supermercado);
        // Se muestra el nombre y el precio de la Electrodomestico seleccionada
        int cantidad = determinarCantidad();
        // Se agrega la Electrodomestico al carrito de compras del cliente
        DetallesVenta newDetalle = new DetallesVenta(Electrodomestico.getNombre(), cantidad, Electrodomestico.getPrecio(), Electrodomestico.getIVA());
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

    private static Articulo listarelectrodomesticos(Supermercado supermercado) {
        ArrayList<Articulo> articuloS = supermercado.articulos;
        ArrayList<Articulo> electrodomesticos = new ArrayList<>();
        for (Articulo articulo : articuloS) {
            if (articulo  instanceof Electrodomestico) {
                electrodomesticos.add(articulo);
            }
        }
        int contador = 1;
        for (Articulo Electrodomestico : electrodomesticos) {
                System.out.println(contador + ". " + Electrodomestico.getNombre() + " - " + Electrodomestico.getPrecio() + " euros");
                contador++;
            }
        int opcion = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido un número de producto válido
        while (opcion < 1 || opcion > electrodomesticos.size()) {
            System.out.println("Opción no válida");
            opcion = ES.pedirEntero();
        }
        return electrodomesticos.get(opcion - 1);
    }
}
