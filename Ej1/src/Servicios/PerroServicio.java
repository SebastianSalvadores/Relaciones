/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
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
            raza = leer.next().toUpperCase();
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
