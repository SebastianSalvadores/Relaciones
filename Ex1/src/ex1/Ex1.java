/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
 */
package ex1;

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
public class Ex1 {

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
        int m;
        System.out.println("¿Cuantas personas quieren adoptar perros?");
        int n = leer.nextInt();
        System.out.println("¿Cuantos perros disponibles para adoptar? (minimo "+n+").");
        do {            
            m = leer.nextInt();
            if(m < n){
                System.out.println("Tienen que haber disponibles al menos "+n+" perros.");
            }
        } while (m < n);
        
        for (int i = 0; i < n; i++) {
            System.out.println("Persona "+(i+1));
            Persona persona = personaServicio.crearPersona();
            personas.add(persona);
        }
        for (int i = 0; i < m; i++) {
            System.out.println("Perro "+(i+1));
            Perro perro = perroServicio.crearPerro();
            perros.add(perro);
        }
        
        
        System.out.println("Es el momento de adoptar sus perros!");
        for (Persona persona : personas) {
            System.out.println("\nEs el turno de "+persona.getNombre()+", elije a tu perro: ");
            for (int i = 0; i < perros.size(); i++) {
                System.out.println((i+1)+". "+perros.get(i).getNombre()+" - "+perros.get(i).getRaza().getRaza());
            }
            do {                
                opc = leer.nextInt();
                if(opc <= 0 || opc > perros.size()){
                    System.out.println("La opcion ingresada no existe. Ingrese una opción entre 1 y " + perros.size() + ".");
                }else if(perros.get(opc - 1).isAdoptado()){
                    System.out.println("El perro ya fue adoptado. Ingrese otra opción.");
                }else{
                    persona.setPerro(perros.get((opc - 1)));
                    perros.get(opc - 1).setAdoptado(true);
                    //perros.remove((opc - 1));
                    break;
                }
            } while (opc <= 0 || opc > perros.size() || perros.get(opc - 1).isAdoptado());
        }
        
        
        System.out.println("");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
    
}
