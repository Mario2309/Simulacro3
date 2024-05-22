package vista.clases;
public class Cliente {
    //Atributos 
    private final String nombre;
    private final String apellido;
    private final String tarjertaCredito;
    private final boolean esSocio;
    private static int idSocio = 1;
    //Constructor
    public Cliente(String nombre, String apellido, String tarjertaCredito, boolean esSocio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjertaCredito = tarjertaCredito;
        this.esSocio = esSocio;
        if (esSocio == true) {
            idSocio = generarIdSocio();
        }
    }
    
    // Metodos

    @Override
    public String toString() {
        if (esSocio == true) {
            return "Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Tarjeta de Credito: " + getTarjertaCredito() + ", Es Socio y su Id de Socio es : " + getIdSocio();
        } else {
            return "Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Tarjeta de Credito: " + getTarjertaCredito() + ", No es Socio";
        }
    }

    public void imprimirDatos() {
        System.out.println(toString());
    }

    // Metodo para generar el id de socio
    public static int generarIdSocio() {
        return idSocio++;
    }
    
    //Getters

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getTarjertaCredito() {
        return tarjertaCredito;
    }
    public boolean isEsSocio() {
        return esSocio;
    }
    public int getIdSocio() {
        return idSocio;
    }
    public static void setIdSocio(int idSocio) {
        Cliente.idSocio = idSocio;
    }
    
}
