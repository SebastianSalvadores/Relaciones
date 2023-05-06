/*
Realiza un programa en donde una clase Persona tenga como atributo nombre, apellido y un
objeto de clase Dni. La clase Dni tendrá como atributos la serie (carácter) y número. Prueba
acceder luego a los atributos del dni de la persona creando objetos y jugando desde el main.
 */
package ejpersona;

import Entidades.Dni;
import Entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class EjPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese nombre");
        String nombre = leer.next();
        System.out.println("Ingrese apellido");
        String apellido = leer.next();
        System.out.println("Ingrese numero de DNI");
        long numero = leer.nextLong();
        System.out.println("Ingrese serie(caracter)");
        char serie = leer.next().charAt(0);
        Dni dni = new Dni(serie, numero);
        Persona persona = new Persona(nombre,apellido,dni);
        System.out.println(persona.toString());
    }
    
}
