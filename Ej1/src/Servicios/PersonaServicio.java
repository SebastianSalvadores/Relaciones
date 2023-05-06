/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package Servicios;

import Entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class PersonaServicio {
    
    private Scanner leer;
    
    public PersonaServicio() {
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Persona crearPersona(){
        System.out.println("Ingrese nombre de la persona: ");
        String nombre = leer.next();
        System.out.println("Ingrese apellido de la persona: ");
        String apellido = leer.next();
        System.out.println("Ingrese edad: ");
        int edad = leer.nextInt();
        System.out.println("Ingrese documento: ");
        long documento = leer.nextLong();
        return new Persona(nombre, apellido, edad, documento);
    }
    
}
