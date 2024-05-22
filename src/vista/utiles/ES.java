package vista.utiles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ES {
    static Scanner sc = new Scanner(System.in);
    // Metodo pedir entero 
    public static int pedirEntero(){
        int entero = -1;
        while (entero == -1) {
            try {
                entero = sc.nextInt();
                if(entero<0) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR: Debe introducir un número positivo!");
                entero = -1;
            } finally{
                sc.nextLine();
            }
        }
        return entero;
    }

    // Metodo pedir double
    public static double pedirDouble(){
        double num = -1;
        while (num == -1) {
            try {
                num = sc.nextDouble();
                if(num<0) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR: Debe introducir un número positivo!");
                num = -1;
            } finally{
                sc.nextLine();
            }
        }
        return num;
    }

    // Metodo pedir cadena
    public static String pedirCadena(){
        return sc.nextLine();
    }

    // Metodo pedir booleano
    public static boolean leerSiNo(){
        while (true) {
            String texto = sc.nextLine().toLowerCase();
            if (texto.length()==1)
                if (texto.charAt(0)=='s') return true;
                else if (texto.charAt(0)=='n') return false;
            System.out.println("El resultado solo puede ser 'S' o 'N':");
        }
    }
}
