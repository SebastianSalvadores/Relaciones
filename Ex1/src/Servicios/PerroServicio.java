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

import Entidades.Perro;
import Enumeracion.Raza;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class PerroServicio {
    private Scanner leer;

    public PerroServicio() {
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Perro crearPerro(){
        boolean bandera = false;
        String raza = null;
        System.out.println("Ingrese nombre del perro: ");
        String nombre = leer.next();
        do {            
            System.out.println("Ingrese raza: ");
            raza = leer.next().toUpperCase().replace(" ", "_");
            for (Raza aux : Raza.values()) {
                if(aux.toString().equalsIgnoreCase(raza)){
                    bandera = true;
                    break;
                }
            }
            if(bandera == false){
                System.out.println("La raza no fue encontrada.");
            }
        } while (bandera == false);
        System.out.println("Ingrese edad del perro: ");
        int edad = leer.nextInt();
        System.out.println("Ingrese tamaño: ");
        double tamanio = leer.nextDouble();
        return new Perro(nombre, Raza.valueOf(raza), edad, tamanio);
    }
}
