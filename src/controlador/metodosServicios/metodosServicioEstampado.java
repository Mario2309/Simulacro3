package controlador.metodosServicios;

import java.util.ArrayList;

import modelo.empleados.Empleado;
import modelo.empleados.Servicios;
import modelo.servicios.Estampado;
import modelo.servicios.Servicio;
import vista.clases.Cliente;
import vista.clases.Menu;
import vista.clases.ServiciosNoSocio;
import vista.clases.ServiciosSocio;
import vista.clases.Supermercado;
import vista.utiles.ES;
import vista.utiles.Texto;

public class metodosServicioEstampado {
    
    /** 
     * @param supermercado
     * @param nombre
     * @return String
     */
    private static String nombreEmpleado(Supermercado supermercado, String nombre){
        ArrayList<Empleado> empleados = supermercado.getEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado instanceof Servicios) {
                nombre = empleado.getNombre();
            }
        }
        return nombre;
    }

    
    /** 
     * @param supermercado
     * @param area
     * @return String
     */
    private static String areaEmpleado(Supermercado supermercado, String area){
        ArrayList<Empleado> empleados = supermercado.getEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado instanceof Servicios) {
                area = empleado.getArea();   
            } 
        }
        return area;
    }

    
    /** 
     * @param cliente
     * @param supermercado
     */
    public static void compraServicioEstampado(Cliente cliente, Supermercado supermercado){
        String nombreEmpleado = "", areaEmpleado = "";
        Servicio servicio = listaServiciosEstampado(supermercado);
        System.out.println(Texto.opinionServicioEstampado);
        int opinio = ES.pedirEntero();
        System.out.println(Texto.generandoTicketServicio);
        if (cliente.isEsSocio() == true) {
            ServiciosSocio newServicio = new ServiciosSocio(cliente.getIdSocio(), cliente.getNombre(), cliente.getApellido(), cliente.getTarjertaCredito(), 
                                        servicio.getNombre(), servicio.getDescripcion(), servicio.getPrecio(), servicio.getIVA() ,opinio, nombreEmpleado(supermercado, nombreEmpleado), 
                                        areaEmpleado(supermercado, areaEmpleado));
            Menu.generarTicketServicioSocio(newServicio);
        } else{
            ServiciosNoSocio newServicio = new ServiciosNoSocio(cliente.getTarjertaCredito(), servicio.getNombre(), servicio.getDescripcion(), servicio.getPrecio(), servicio.getIVA(), opinio, nombreEmpleado(supermercado, nombreEmpleado), areaEmpleado(supermercado, areaEmpleado));
            Menu.generarTicketServicioNoSocio(newServicio);
        }
    }

    private static Servicio listaServiciosEstampado(Supermercado supermercado){
        ArrayList<Servicio> servicios = supermercado.getServicios();
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        for (Servicio servicio : servicios) {
            if (servicio instanceof Estampado) {
                listaServicios.add(servicio);
            }
        }
        int contador = 1;
        for (Servicio servicio : listaServicios) {
            System.out.println(contador + " - " + servicio.getNombre());
            contador++;
        }
        int opcion = ES.pedirEntero();
        while (opcion<0||opcion>=listaServicios.size()) {
            System.out.println("Opcion no valida, vuelva a intentarlo.");
            opcion = ES.pedirEntero();
        }
        return listaServicios.get(opcion-1);
    }
}
