/*
Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se trata de
un número de jugadores, que, con un revolver de agua, el cual posee una sola carga de agua,
se dispara y se moja. Las clases por hacer del juego son las siguientes:

Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)

Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.

Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package ej2;

import Entidades.Juego;
import Entidades.Jugador;
import Entidades.Revolver;
import Servicios.JuegoServicio;
import Servicios.RevolverServicio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Sebastian
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        JuegoServicio juegoServ = new JuegoServicio();
        Set<Jugador> jugadoresSet = new HashSet<>();
        RevolverServicio rs = new RevolverServicio();
        boolean gameOver = false;
        
        System.out.println("Bienvenido a la ruleta rusa de agua. \nReglas: Evita ser mojado por el revolver de agua! El juego finalizará cuando un jugador sea mojado.");
        System.out.println("Ingrese la cantidad de jugadores (1 a 6 jugadores):");
        int cantJugadores = leer.nextInt(); //Cantidad de jugadores.
        if(cantJugadores <= 1 || cantJugadores > 6){
            if(cantJugadores == 1){
                System.out.println("No es posible jugar con un solo jugador. Se ha seleccionado 6 jugadores por defecto.");
            }else{
                System.out.println("La cantidad de jugadores ingresados no se encuentra en el rango indicado. Se ha seleccionado 6 jugadores por defecto.");
            }
            cantJugadores = 6; //Por default.
        }
        for (int i = 1; i <= cantJugadores; i++) { //Se crea la lista de jugadores.
            int id = i;
            String nombre = "Jugador "+i;
            Jugador jugador = new Jugador(id,nombre);
            jugadoresSet.add(jugador);
        }
        ArrayList<Jugador> jugadores = new ArrayList<>(jugadoresSet);
        
        Revolver r = rs.llenarRevolver(); //Retorna revolver con posiciones aleatorias.
        Juego juego = juegoServ.llenarJuego(jugadores, r); //new game
        while(gameOver == false){
            for (int i = 0; i < jugadores.size(); i++) {
                juegoServ.ronda(juego, i);
                if(jugadores.get(i).isMojado()){
                    gameOver = true;
                    break;
                }
            }
        }
    }
    
}
