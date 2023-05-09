/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
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
