/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package ej1;

import Entidades.Perro;
import Entidades.Persona;
import Servicios.PerroServicio;
import Servicios.PersonaServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaServicio personaServicio = new PersonaServicio();
        PerroServicio perroServicio = new PerroServicio();
        List<Persona> personas = new ArrayList<>();
        List<Perro> perros = new ArrayList<>();
        int opc = 0;
        for (int i = 0; i < 2; i++) {
            System.out.println("Persona "+(i+1));
            Persona persona = personaServicio.crearPersona();
            personas.add(persona);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("Perro "+(i+1));
            Perro perro = perroServicio.crearPerro();
            perros.add(perro);
        }
        
        
        System.out.println("Es el momento de adoptar sus perros!");
        for (Persona persona : personas) {
            System.out.println("\nEs el turno de "+persona.getNombre()+", elije a tu perro: ");
            for (int i = 0; i < perros.size(); i++) {
                System.out.println((i+1)+". "+perros.get(i).getNombre()+"-"+perros.get(i).getRaza().getRaza());
            }
            do {                
                opc = leer.nextInt();
                if(opc <= 0 || opc > perros.size()){
                    System.out.println("La opcion ingresada no existe. Ingrese una opción entre 1 y " + perros.size() + ".");
                }else{
                    persona.setPerro(perros.get((opc - 1)));
                    perros.remove((opc - 1));
                    break;
                }
            } while (opc <= 0 || opc > perros.size());
        }
        
        
        System.out.println("");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
    
}
