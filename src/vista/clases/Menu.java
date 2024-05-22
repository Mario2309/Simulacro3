package vista.clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controlador.metodosCompra.metodosComprarBazar;
import controlador.metodosCompra.metodosComprarCarne;
import controlador.metodosCompra.metodosComprarElectrodomesticos;
import controlador.metodosCompra.metodosComprarFrescos;
import controlador.metodosCompra.metodosComprarLimpieza;
import controlador.metodosCompra.metodosComprarPescado;
import controlador.metodosCompra.metodoscomprarFruta;
import controlador.metodosServicios.metodosServicioEstampado;
import controlador.metodosServicios.metodosServiciosArregloElectrodomesticos;
import controlador.metodosServicios.metodosServiciosBordados;
import controlador.metodosServicios.metodosServiciosProtectoresPantalla;
import modelo.articulos.Articulo;
import modelo.articulos.Bazar;
import modelo.articulos.Carne;
import modelo.articulos.Electrodomestico;
import modelo.articulos.Fresco;
import modelo.articulos.Fruta;
import modelo.articulos.Limpieza;
import modelo.articulos.Pescado;
import modelo.empleados.Carnicero;
import modelo.empleados.Empleado;
import modelo.empleados.EncargadoBazar;
import modelo.empleados.EncargadoElectrodomesticos;
import modelo.empleados.EncargadoFrescos;
import modelo.empleados.EncargadoLimpieza;
import modelo.empleados.Frutero;
import modelo.empleados.Pescadero;
import modelo.servicios.ArregloElectrodomestico;
import modelo.servicios.Bordado;
import modelo.servicios.Estampado;
import modelo.servicios.ProteccionMovil;
import modelo.servicios.Servicio;
import vista.utiles.ES;
import vista.utiles.Texto;

public class Menu {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Supermercado> supermercados = new ArrayList<>();
    static int contadorTicketsSocios = 1;
    static int contadorTicketsNoSocios = 1;
    static int contadorTicketsServiciosSocio = 1;
    static int contadorTicketsServiciosNoSocio = 1;

    public static void menuPrincipal() {
        System.out.println(Texto.menuPrincipal);
        int opcion = ES.pedirEntero();
        switch (opcion) {
            case 1:
                // Opción 1
                menuCliente();
                break;
            case 2:
                // Opción 2
                seleccionarSuper();
                break;
            case 3:
                // Opción 3
                supermercados.add(crearSuper());
                break;
            case 0:
                // Salir del programa
                System.out.println("¡Hasta pronto!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private static Supermercado crearSuper() {
        System.out.println(Texto.crearSuper);
        String nombre = ES.pedirCadena();
        return new Supermercado(nombre);
    }

    // Listar supermercados
    public static void listarSupermercados() {
        if (supermercados.isEmpty()) {
            System.out.println("No hay supermercados disponibles");
        } else{
            int contador = 1;
            for (Supermercado supermercado : supermercados) {
                System.out.println(contador + ". " + supermercado.getNombre());
                contador++;
            }
            int opcion = ES.pedirEntero();
            Supermercado supermercado = supermercados.get(opcion - 1);
            menuSupermercado(supermercado);  
        }
    }

    private static void seleccionarSuper() {
        System.out.println(Texto.seleccionarSuper);
        listarSupermercados();
    }

    public static void menuCliente() {
        while (true) {
            System.out.println(Texto.menuClientes);
            int opcion = ES.pedirEntero();
            Cliente cliente = null;
            switch (opcion) {
                case 1:
                    // Opción 1
                    cliente = crearCliente();
                    clientes.add(cliente);
                    break;
                case 2:
                    // Opción 2
                    listarClientes();
                    break;
                case 3:
                    // Opción 3
                    listarClientes2();
                    break;
                case 0:
                    // Volver al menú principal
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private static void listarClientes2() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            int contador = 1;
            for (Cliente cliente : clientes) {
                System.out.println(contador + ". " + cliente.getNombre() + " " + cliente.getApellido());
                contador++;
            }
            int opcion = ES.pedirEntero();
            Cliente cliente = clientes.get(opcion - 1);
            // Se muestra el menú de compra de servicio
            seleccionarSuperComprar2(cliente);
        }
    }

    private static void seleccionarSuperComprar2(Cliente cliente) {
        System.out.println(Texto.seleccionarSuperComprar);
        listarSupermercadosCompra2(cliente);
    }

    private static void listarSupermercadosCompra2(Cliente cliente) {
        if (supermercados.isEmpty()) {
            System.out.println("No hay supermercados disponibles");
        } else{
            int contador = 1;
            for (Supermercado supermercado : supermercados) {
                System.out.println(contador + ". " + supermercado.getNombre());
                contador++;
            }
            int opcion = ES.pedirEntero();
            Supermercado supermercado = supermercados.get(opcion - 1);
            menuCompraServicio(cliente, supermercado);
        }
    }

    private static void menuCompraServicio(Cliente cliente, Supermercado supermercado) {
        while (true) {
            System.out.println(Texto.menuCompraServicio);
            int opcion = ES.pedirEntero();
            switch (opcion) {
                case 1:
                    // Opción 1
                    metodosServicioEstampado.compraServicioEstampado(cliente, supermercado);
                    break;
                case 2:
                    // Opción 2
                    metodosServiciosBordados.compraServicioBordado(cliente, supermercado);
                    break;
                case 3:
                    // Opción 3
                    metodosServiciosProtectoresPantalla.compraServicioProteccionMovil(cliente, supermercado);
                    break;
                case 4:
                    // Opción 4
                    metodosServiciosArregloElectrodomesticos.compraServicioArregloElectrodomestico(cliente, supermercado);
                    break;
                case 0:
                    // Volver al menú principal
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private static void listarClientes() {
        // Se comprueba que hay clientes registrados
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            int contador = 1;
            for (Cliente cliente : clientes) {
                System.out.println(contador + ". " + cliente.getNombre() + " " + cliente.getApellido());
                contador++;
            }
            int opcion = ES.pedirEntero();
            Cliente cliente = clientes.get(opcion - 1);
            // Se muestra el menú de compra
            seleccionarSuperComprar(cliente);
        }
    }

    private static void seleccionarSuperComprar(Cliente cliente){
        System.out.println(Texto.seleccionarSuperComprar);
        listarSupermercadosCompra(cliente);
    }

    // Listar supermercados
    public static void listarSupermercadosCompra(Cliente cliente) {
        if (supermercados.isEmpty()) {
            System.out.println("No hay supermercados disponibles");
        } else{
            int contador = 1;
            for (Supermercado supermercado : supermercados) {
                System.out.println(contador + ". " + supermercado.getNombre());
                contador++;
            }
            int opcion = ES.pedirEntero();
            Supermercado supermercado = supermercados.get(opcion - 1);
            menuCompra(cliente, supermercado);
        }
    }

    private static void menuCompra(Cliente cliente, Supermercado supermercado) {
        while (true) {
            System.out.println(Texto.menuCompra);
            int opcion = ES.pedirEntero();
            switch (opcion) {
                case 1:
                    // Opción 1
                    metodoscomprarFruta.comprarFruta(cliente, supermercado);
                    break;
                case 2:
                    metodosComprarPescado.comprarPescado(cliente, supermercado);
                    break;
                case 3:
                    metodosComprarCarne.comprarcarne(cliente, supermercado);
                    break;
                case 4:
                    metodosComprarFrescos.comprarfresco(cliente, supermercado);
                    break;
                case 5:
                    metodosComprarBazar.comprarBazar(cliente, supermercado);
                    break;
                case 6:
                    metodosComprarElectrodomesticos.comprarElectrodomestico(cliente, supermercado);
                    break;
                case 7:
                    metodosComprarLimpieza.comprarLimpieza(cliente, supermercado);
                    break;
                case 0:
                    // Volver al menú principal
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;       
            }
        }
    }

    private static Cliente crearCliente() {
        System.out.println(Texto.nombreCliente);
        String nombre = ES.pedirCadena();
        System.out.println(Texto.apellidoCliente);
        String apellido = ES.pedirCadena();
        System.out.println(Texto.numeroTarjetaCliente);
        String numeroTarjeta = ES.pedirCadena();
        // Se comprueba que el número de tarjeta sea válido hasta que el usuario lo introduzca correctamente
        while (!validarNumeroTarjeta(numeroTarjeta)) {
            numeroTarjeta = ES.pedirCadena();
        }
        System.out.println(Texto.esSocio);
        boolean esSocio = ES.leerSiNo();
        return new Cliente(nombre, apellido, numeroTarjeta, esSocio);
    }

    private static boolean validarNumeroTarjeta(String numeroTarjeta) {
        if (numeroTarjeta.length() == 16) {
            return true;
        } else {
            System.out.println("El número de tarjeta debe tener 16 dígitos");
            // Devuelve true si el número de tarjeta es válido, false si no lo es
            return false;
        }
    }

    public static void menuSupermercado(Supermercado supermercado){
        while (true) {
            System.out.println(Texto.menuSupermercado);
            int opcion = ES.pedirEntero();
            switch (opcion) {
                case 1:
                    // Opción 1
                    crearEmpleado(supermercado);
                    break;
                case 2:
                    // Opción 2
                    agregarProducto(supermercado);
                    break;
                case 3:
                    // Opción 3
                    agregarServicio(supermercado);
                    break;
                    
                case 4:
                    // Opción 4
                    eliminarProducto(supermercado);
                    break;
                case 5:
                    // Opción 5
                    eliminarServicio(supermercado);
                    break;
                case 0:
                    // Volver al menú principal
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private static void eliminarServicio(Supermercado supermercado) {
        System.out.println(Texto.listaServicios);
        int contador = 1;
        for (Servicio servicio : supermercado.servicios) {
            System.out.println(contador + ". " + servicio.getNombre());
            contador++;
        }
        System.out.println(Texto.eliminarServicio);
        int opcion = ES.pedirEntero();
        // Se comprueba que el número de servicio sea válido hasta que el usuario lo introduzca correctamente
        while (!validarNumeroServicioDisponible(opcion, supermercado)) {
            opcion = ES.pedirEntero();
        }
        // Se elimina el servicio seleccionado
        supermercado.servicios.remove(opcion-1);
    }

    private static boolean validarNumeroServicioDisponible(int opcion, Supermercado supermercado) {
        if (opcion-1 >= 0 || opcion-1 <= supermercado.articulos.size()) {
            return true;
        } else {
            System.out.println("El número de servicio no es válido");
            // Devuelve true si el número de servicio es válido, false si no lo es
            return false;
        }
    }

    private static void eliminarProducto(Supermercado supermercado) {
        System.out.println(Texto.listaProductos);
        int contador = 1;
        for (Articulo producto : supermercado.articulos) {
            System.out.println(contador + ". " + producto.getNombre());
            contador++;
        }
        System.out.println(Texto.eliminarProducto);
        int opcion = ES.pedirEntero();
        // Se comprueba que el número de producto sea válido hasta que el usuario lo introduzca correctamente
        while (!validarNumeroProductoDisponible(opcion, supermercado)) {
            opcion = ES.pedirEntero();
        }
        // Se elimina el producto seleccionado
        supermercado.articulos.remove(opcion-1);
    }

    private static boolean validarNumeroProductoDisponible(int opcion, Supermercado supermercado) {
        if (opcion-1 >= 0 || opcion-1 <= supermercado.articulos.size()-1) {
            return true;
        } else {
            System.out.println("El número de producto no es válido");
            // Devuelve true si el número de producto es válido, false si no lo es
            return false;
        }
    }

    private static void agregarServicio(Supermercado supermercado) {
        System.out.println(Texto.nombreServicio);
        String nombre = ES.pedirCadena();
        System.out.println(Texto.descripcionServicio);
        String descripcion = ES.pedirCadena();
        System.out.println(Texto.precioServicio);
        double precio = ES.pedirDouble();
        System.out.println(Texto.determinaElTipoDeServicio + Texto.tiposServicios);
        int tipoServicio = ES.pedirEntero();
        // Se comprueba que el número de servicio sea válido hasta que el usuario lo introduzca correctamente
        while (!validarNumeroServicio(tipoServicio)) {
            tipoServicio = ES.pedirEntero();
        }
        switch (tipoServicio) {
            case 1:
                Servicio newServicio = new Bordado(nombre, descripcion, precio, 0.0);
                supermercado.servicios.add(newServicio);
                break;
            case 2:
                newServicio = new Estampado(nombre, descripcion, precio, 0.0);
                supermercado.servicios.add(newServicio);
                break;
            case 3:
                newServicio = new ProteccionMovil(nombre, descripcion, precio, 0.0);
                supermercado.servicios.add(newServicio);
                break;
            case 4:
                newServicio = new ArregloElectrodomestico(nombre, descripcion, precio, 0.0);
                supermercado.servicios.add(newServicio);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private static boolean validarNumeroServicio(int tipoServicio) {
        if (tipoServicio >= 1 || tipoServicio <= 4) {
            return true;
        } else {
            System.out.println("El número de servicio debe ser mayor o igual que 1 y menor o igual que 4");
            // Devuelve true si el número de servicio es válido, false si no lo es
            return false;
        }
    }

    private static void agregarProducto(Supermercado supermercado) {
        System.out.println(Texto.ingredaElNombreDelProducto);
        String nombre = ES.pedirCadena();
        System.out.println(Texto.ingredaElPrecioDelProducto);
        double precio = ES.pedirDouble();
        System.out.println(Texto.determinaElTipoDeProducto + Texto.tiposProductos);
        int tipoProducto = ES.pedirEntero();
        // Se comprueba que el número de producto sea válido hasta que el usuario lo introduzca correctamente
        while (!validarNumeroProducto(tipoProducto)) {
            tipoProducto = ES.pedirEntero();
        }
        switch (tipoProducto) {
            case 1:
                Articulo nuevoProducto = new Fruta(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            case 2:
                nuevoProducto = new Pescado(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            case 3:
                nuevoProducto = new Carne(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            case 4:
                nuevoProducto = new Fresco(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            case 5:
                nuevoProducto = new Bazar(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            case 6:
                nuevoProducto = new Electrodomestico(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            case 7:
                nuevoProducto = new Limpieza(nombre, "", precio, 0.0);
                supermercado.articulos.add(nuevoProducto);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private static boolean validarNumeroProducto(int tipoProducto) {
        if (tipoProducto >= 1 && tipoProducto <= 7) {
            return true;
        } else {
            System.out.println("El número de producto debe ser entre 1 y 7");
            // Devuelve true si el número de producto es válido, false si no lo es
            return false;
        }
    }

    private static void crearEmpleado(Supermercado supermercado) {
        System.out.println(Texto.ingredaElNombreDelEmpleado);
        String nombre = ES.pedirCadena();
        System.out.println(Texto.ingredaElApellidoDelEmpleado);
        String apellido = ES.pedirCadena();
        System.out.println(Texto.determinarAreaTrabajo);
        System.out.println(Texto.areaTrabajos);
        int areaTrabajo = ES.pedirEntero();
        // Se comprueba que el número de empleado sea válido hasta que el usuario lo introduzca correctamente
        while (!validarNumeroEmpleado(areaTrabajo)) {
            areaTrabajo = ES.pedirEntero();
        }
        switch (areaTrabajo) {
            case 1:
                Empleado nuevoEmpleado = new Frutero(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
            case 2:
                nuevoEmpleado = new Pescadero(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
            case 3:
                nuevoEmpleado = new Carnicero(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
            case 4:
                nuevoEmpleado = new EncargadoFrescos(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
            case 5:
                nuevoEmpleado = new EncargadoBazar(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
            case 6:
                nuevoEmpleado = new EncargadoElectrodomesticos(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
            case 7:
                nuevoEmpleado = new EncargadoLimpieza(nombre, apellido);
                supermercado.empleados.add(nuevoEmpleado);
                break;
        
            default:
                System.out.println("Opción no válida");
                break;
        }
        System.out.println("Empleado creado correctamente");
    }

    private static boolean validarNumeroEmpleado(int areaTrabajo) {
        if (areaTrabajo >= 1 && areaTrabajo <= 7) {
            return true;
        } else {
            System.out.println("El número de empleado debe ser mayor o igual que 1 y menor o igual que 7");
            // Devuelve true si el número de empleado es válido, false si no lo es
            return false;
        }
    }

    public static void generarTicketSocio(VentasSocios newCompra){
        String nombre = "TicketsSocios";
        String nombreFichero = "ticket_socio_" + contadorTicketsSocios + ".txt";
        contadorTicketsSocios++;
        File fichero = new File (nombre);
        if (!fichero.exists()) {
            fichero.mkdir();
        }

        String Ruta = nombre + "/" + nombreFichero;

        try {
            FileWriter escritura = new FileWriter(Ruta);
            escritura.write(newCompra.toString());
            escritura.close();
            System.out.println("Ticket generado correctamente");
        } catch (IOException e) {
            System.out.println("Error al generar el ticket");

        }
        
    }

    public static void generarTicketNoSocio(VentasNoSocio newCompra){
        String nombre = "TicketsNoSocios";
        String nombreFichero = "ticket_no_socio_" + contadorTicketsNoSocios + ".txt";
        contadorTicketsNoSocios++;
        File fichero = new File (nombre);
        if (!fichero.exists()) {
            fichero.mkdir();
        }

        String Ruta = nombre + "/" + nombreFichero;

        try {
            FileWriter escritura = new FileWriter(Ruta);
            escritura.write(newCompra.toString());
            escritura.close();
            System.out.println("Ticket generado correctamente");
        } catch (IOException e) {
            System.out.println("Error al generar el ticket");
        }
    }

    public static void generarTicketServicioSocio(ServiciosSocio newServicio) {
        String nombre = "TicketsServiciosSocio";
        String nombreFichero = "ticket_servicio_socio_" + contadorTicketsServiciosSocio + ".txt";
        contadorTicketsServiciosSocio++;
        File fichero = new File (nombre);
        if (!fichero.exists()) {
            fichero.mkdir();
        }

        String Ruta = nombre + "/" + nombreFichero;
        
        try {
            FileWriter escritura = new FileWriter(Ruta);
            escritura.write(newServicio.toString());
            escritura.close();
            System.out.println("Ticket generado correctamente");
        } catch (IOException e) {
            System.out.println("Error al generar el ticket");
        }
    }

    public static void generarTicketServicioNoSocio(ServiciosNoSocio newServicio) {
        String nombre = "TicketsServiciosNoSocio";
        String nombreFichero = "ticket_servicio_no_socio_" + contadorTicketsServiciosNoSocio + ".txt";
        contadorTicketsServiciosNoSocio++;
        File fichero = new File (nombre);
        if (!fichero.exists()) {
            fichero.mkdir();
        }

        String Ruta = nombre + "/" + nombreFichero;
        
        try {
            FileWriter escritura = new FileWriter(Ruta);
            escritura.write(newServicio.toString());
            escritura.close();
            System.out.println("Ticket generado correctamente");
        } catch (IOException e) {
            System.out.println("Error al generar el ticket");
        }
    }
}
