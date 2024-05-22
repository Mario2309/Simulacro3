package controlador.metodosCompra;

import java.util.ArrayList;

import modelo.articulos.Articulo;
import modelo.articulos.Carne;
import modelo.empleados.Carnicero;
import modelo.empleados.Empleado;
import vista.clases.Cliente;
import vista.clases.DetallesVenta;
import vista.clases.Menu;
import vista.clases.Supermercado;
import vista.clases.VentasNoSocio;
import vista.clases.VentasSocios;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodosComprarCarne {
    private static String nombreCarnicero(Supermercado supermercado, String nombreEmpleado) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof Carnicero) {
                nombreEmpleado = empleado.getNombre();
            }
        }
        return nombreEmpleado;
    }

    private static String areaCarnicero(Supermercado supermercado, String area) {
        ArrayList<Empleado> trabajadores = supermercado.getEmpleados();
        for (Empleado empleado : trabajadores) {
            if (empleado instanceof Carnicero) {
                area = empleado.getArea();
            }
        }
        return area;
    }

    public static void comprarcarne(Cliente cliente, Supermercado supermercado) {
        String nombreEmpleado ="", area="";
        ArrayList<DetallesVenta> detallesVentas = new ArrayList<>();
        boolean seguirComprando = true;
        do {
                // Se vuelve a mostrar el menú de compra
                procesoCompracarne(supermercado, detallesVentas);
                // Se pregunta si se quiere seguir comprando
                System.out.println(Texto.deseaSeguirComprando);
                seguirComprando = ES.leerSiNo();
        } while (seguirComprando == true);
            if (cliente.isEsSocio() == true) {
                VentasSocios newVenta = new VentasSocios(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), nombreCarnicero(supermercado, nombreEmpleado), areaCarnicero(supermercado, area), detallesVentas);
                Menu.generarTicketSocio(newVenta);
            } else {
                VentasNoSocio newVenta = new VentasNoSocio(cliente.getTarjertaCredito(), nombreCarnicero(supermercado, nombreEmpleado), areaCarnicero(supermercado, area), detallesVentas);
                Menu.generarTicketNoSocio(newVenta);
            }  
        


    }

    private static void procesoCompracarne(Supermercado supermercado, ArrayList<DetallesVenta> detallesVentas) {
        // Se muestra una lista de las carnes disponibles
        System.out.println(Texto.seleccionarProducto);
        // Se muestra el nombre y el precio de cada carne y se pide al usuario que seleccione una carne
        Articulo carne = listarcarnes(supermercado);
        // Se muestra el nombre y el precio de la carne seleccionada
        int cantidad = determinarCantidad();
        // Se agrega la carne al carrito de compras del cliente
        DetallesVenta newDetalle = new DetallesVenta(carne.getNombre(), cantidad, carne.getPrecio(), carne.getIVA());
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

    private static Articulo listarcarnes(Supermercado supermercado) {
        ArrayList<Articulo> articuloS = supermercado.articulos;
        ArrayList<Articulo> carnes = new ArrayList<>();
        for (Articulo articulo : articuloS) {
            if (articulo  instanceof Carne) {
                carnes.add(articulo);
            }
        }
        int contador = 1;
        for (Articulo carne : carnes) {
                System.out.println(contador + ". " + carne.getNombre() + " - " + carne.getPrecio() + " euros");
                contador++;
            }
        int opcion = ES.pedirEntero();
        // Se comprueba que el usuario ha introducido un número de producto válido
        while (opcion < 1 || opcion > carnes.size()) {
            System.out.println("Opción no válida");
            opcion = ES.pedirEntero();
        }
        return carnes.get(opcion - 1);
    }
}
