/*
Realiza un programa en donde exista una clase Jugador que contenga nombre, apellido, posición
y número. Luego otra clase Equipo que contenga una colección de jugadores. Una vez hecho
esto, desde el main recorreremos el equipo mostrando la información de cada jugador.
 */
package ejjugador;

import Entidades.Equipo;
import Entidades.Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class EjJugador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Equipo equipo = new Equipo();
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese nombre");
            String nombre = leer.next();
            System.out.println("Ingrese apellido");
            String apellido = leer.next();
            System.out.println("Ingrese posicion");
            String posicion = leer.next();
            System.out.println("Ingrese numero");
            int numero = leer.nextInt();
            Jugador jugador = new Jugador(nombre, apellido, posicion, numero);
            jugadores.add(jugador);
        }
        
        equipo.setJugadores(jugadores);
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.println(jugador);
        }
        System.out.println(equipo);
    }
    
}
