package vista.clases;
import java.util.ArrayList;

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
import modelo.empleados.Servicios;
import modelo.servicios.ArregloElectrodomestico;
import modelo.servicios.Bordado;
import modelo.servicios.Estampado;
import modelo.servicios.ProteccionMovil;
import modelo.servicios.Servicio;

public class Supermercado {
    // Atributos
    private final String nombre;
    public ArrayList<Articulo> articulos = new ArrayList<>();
    ArrayList<Servicio> servicios = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<VentasSocios> ventasSocios = new ArrayList<>();
    
    // Constructor
    public Supermercado(String nombre) {
        this.nombre = nombre;
        agregarArticuloPredeterminados();
        agregarEmpleadosPred();
        generarServicios();
    }
    
    // Métodos
    
    public void agregarEmpleadosPred(){
        // Array de nombres
        String[] nombres = {"Juan", "María", "Pedro", "Lucía", "Carlos", "Ana", "José", "Elena"};
        
        // Array de apellidos
        String[] apellidos = {"García", "Martínez", "López", "Sánchez", "Pérez", "González", "Rodríguez", "Fernández"};
        
        // Se crea el objeto y se agrega a la lista de empleados
        Empleado empleado1 = new Frutero(nombres[0], apellidos[0]);
        empleados.add(empleado1);
        Empleado empleado2 = new Pescadero(nombres[1], apellidos[1]);
        empleados.add(empleado2);
        Empleado empleado3 = new Carnicero(nombres[2], apellidos[2]);
        empleados.add(empleado3);
        Empleado empleado4 = new EncargadoFrescos(nombres[3], apellidos[3]);
        empleados.add(empleado4);
        Empleado empleado5 = new EncargadoBazar(nombres[4], apellidos[4]);
        empleados.add(empleado5);
        Empleado empleado6 = new EncargadoElectrodomesticos(nombres[5], apellidos[5]);
        empleados.add(empleado6);
        Empleado empleado7 = new EncargadoLimpieza(nombres[6], apellidos[6]);
        empleados.add(empleado7);
        Empleado empleado8 = new Servicios(nombres[7], apellidos[7]);
        empleados.add(empleado8);
    }

    public void agregarArticuloPredeterminados(){
    frutas();
    pescado();
    carnes();
    frescos();
    bazar();
    electrodomesticos();
    limpieza();
    }

    private void limpieza() {
        // Array nombres
        String[] nombres = {"Jabon", "Desinfectante", "Pastilas del Lavavajillas"};
        // Array precios
        double[] precios = {1.0, 1.5, 3.5};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Limpieza(nombres[i], "", precios[i], 0.0));
        }
    }

    private void electrodomesticos() {
        // Array nombres
        String[] nombres = {"Lavadora", "Secadora", "Licuadora"};
        // Array precios
        double[] precios = {150.0, 55.0, 74.99};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Electrodomestico(nombres[i], "", precios[i], 0.0));
        }
    }

    private void bazar() {
        // Array nombres
        String[] nombres = {"Pala", "Peine", "Vaso"};
        // Array precios
        double[] precios = {1.0, 1.5, 3.5};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Bazar(nombres[i], "", precios[i], 0.0));
        }
    }

    private void frescos() {
        // Array nombres
        String[] nombres = {"Leche", "Yogurt", "Queso"};
        // Array precios
        double[] precios = {2.0, 2.5, 3.0};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Fresco(nombres[i], "", precios[i],0.0));
        }
    }

    private void carnes() {
        // Array nombres
        String[] nombres = {"Lomo", "Pechuga", "Pollo"};
        // Array precios
        double[] precios = {15.0, 10.0, 12.0};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Carne(nombres[i], "", precios[i], 0.0));
        }
    }

    private void pescado() {
        // Array nombres
        String[] nombres = {"Salmón", "Atún", "Pulpo"};
        // Array precios
        double[] precios = {10.0, 12.0, 15.0};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Pescado(nombres[i], "", precios[i],0.0));
        }
    }

    private void frutas() {
        // Array nombres
        String[] nombres = {"Manzana", "Pera", "Naranja"};
        // Array precios
        double[] precios = {1.5, 1.8, 1.9};
        // Se crea el objeto y se agrega a la lista de articulos
        for (int i = 0; i < precios.length; i++) {
            articulos.add(new Fruta(nombres[i], "", precios[i],0.0)); 
        }
    }

    // Agregar un artículo al supermercado
    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }
    
    // Agregar un servicio al supermercado
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    
    // Agregar un empleado al supermercado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    // Mostrar los artículos del supermercado
    public void mostrarProductos() {
        int contador = 1;
        for (Articulo articulo : articulos) {
            System.out.println("Articulo " + contador + ": " + articulo.getNombre() + " - " + articulo.getPrecio());
            contador++;
        }
    }

    // Mostrar los servicios del supermercado
    public void mostrarServicios() {
        int contador = 1;
        for (Servicio servicio : servicios) {
            System.out.println("Servicio " + contador + ": " + servicio.getNombre() + " - " + servicio.getPrecio());
            contador++;
        }
    }
    
    // Mostrar los empleados del supermercado
    public void mostrarEmpleados() {
        int contador = 1;
        for (Empleado empleado : empleados) {
            System.out.println("Empleado " + contador + ": " + empleado.getNombre() + " - " + empleado.getArea());
            contador++;
        }
    }

    public void generarServicios(){
        estampados();
        bordados();
        proteccionMovil();
        arregloElectrodomesticos();
    }

    private void estampados() {
        // Array nombres
        String[] nombres = {"Estampado de camisa", "Estampado de pantalon", "Estampado de remera"};
        // Array precios
        double[] precios = {50.0, 35.0, 24.99};
        // Se crea el objeto y se agrega a la lista de servicios
        for (int i = 0; i < precios.length; i++) {
            servicios.add(new Estampado(nombres[i], "", precios[i], 0.0));
        }
    }

    private void bordados() {
        // Array nombres
        String[] nombres = {"Bordado de camisa", "Bordado de pantalon", "Bordado de remera"};
        // Array precios
        double[] precios = {50.0, 35.0, 24.99};
        // Se crea el objeto y se agrega a la lista de servicios
        for (int i = 0; i < precios.length; i++) {
            servicios.add(new Bordado(nombres[i], "", precios[i], 0.0));
        }
    }

    private void proteccionMovil() {
        // Array nombres
        String[] nombres = {"Cambio de pantalla", "Cambio de batería", "Cambio de chip"};
        // Array precios
        double[] precios = {100.0, 150.0, 200.0};
        // Se crea el objeto y se agrega a la lista de servicios
        for (int i = 0; i < precios.length; i++) {
            servicios.add(new ProteccionMovil(nombres[i], "", precios[i], 0.0));
        }
    }

    private void arregloElectrodomesticos() {
        // Array nombres
        String[] nombres = {"Arreglar Lavadora", "Arreglar Secadora", "Arreglar Licuadora"};
        // Array precios
        double[] precios = {150.0, 55.0, 74.99};
        // Se crea el objeto y se agrega a la lista de servicios
        for (int i = 0; i < precios.length; i++) {
            servicios.add(new ArregloElectrodomestico(nombres[i], "", precios[i], 0.0));
        }
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<VentasSocios> getVentasSocios() {
        return ventasSocios;
    }

    public void setVentasSocios(ArrayList<VentasSocios> ventasSocios) {
        this.ventasSocios = ventasSocios;
    }
    
}
