/*
Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1
y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.
 */
package ej3;

import Entidades.Baraja;
import Entidades.Carta;
import Enumeracion.Palo;
import Servicio.BarajaServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Baraja baraja = new Baraja();
        BarajaServicio bs = new BarajaServicio();
        ArrayList<Carta> monton = new ArrayList<>();
        
        //Creacion de 40 cartas.
        for (Palo palo : Palo.values()) {
            for (int i = 1; i <= 12; i++) {
                if(i != 8 && i != 9){
                    Carta carta = new Carta(i,palo);
                    baraja.getCartas().add(carta);
                }
            }
        }
        int opc = 0;
        do {            
            System.out.println("1. Barajar"
                    + "\n2. Siguiente carta"
                    + "\n3. Cartas disponibles"
                    + "\n4. Pedir cartas"
                    + "\n5. Mostrar cartas en el monton"
                    + "\n6. Mostrar cartas en la baraja"
                    + "\n7. Salir");
            do {                
                opc = leer.nextInt();
                if(opc < 1 || opc > 7){
                    System.out.println("Opcion incorrecta. Ingrese nuevamente.");
                }
            } while (opc < 1 || opc > 7);
            switch (opc) {
                case 1:
                    bs.barajar(baraja);
                    break;
                case 2:
                    if(bs.cartasDisponibles(baraja) == 0){
                        System.out.println("No hay mas cartas.");
                    }else{
                        Carta sigCarta = bs.siguienteCarta(baraja);
                        monton.add(sigCarta);
                        System.out.println(sigCarta);
                    }
                    break;
                case 3:
                    System.out.println("Hay "+bs.cartasDisponibles(baraja)+" cartas en la baraja.");
                    break;
                case 4:
                    System.out.println("¿Cuantas cartas?");
                    int cant = leer.nextInt();
                    if(bs.cartasDisponibles(baraja) >= cant){
                        List<Carta> cartasPedidas = bs.darCartas(baraja, cant);
                        for (Carta cartaPedida : cartasPedidas) {
                            monton.add(cartaPedida);
                            System.out.println(cartaPedida);
                        }
                    }else{
                        System.out.println("La cantidad de cartas pedidas supera la cantidad de cartas en la baraja.");
                    }
                    break;
                case 5:
                    bs.cartasMonton(monton);
                    break;
                case 6:
                    if(bs.cartasDisponibles(baraja) != 0){
                        bs.mostrarBaraja(baraja);
                    }else{
                        System.out.println("No hay cartas en la baraja.");
                    }
            }
            System.out.println("");
            try {
                Thread.sleep(1000); //Delay de 1 segundos
            } catch (InterruptedException e) {
            }
        } while (opc != 7);
        
    }      
}
