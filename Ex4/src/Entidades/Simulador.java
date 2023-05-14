/*
Desarrollar un simulador del sistema de votación de facilitadores en Egg-
El sistema de votación de Egg tiene una clase llamada Alumno con los siguientes atributos:
nombre completo, DNI y cantidad de votos. Además, crearemos una clase Simulador que va a
tener los métodos para manejar los alumnos y sus votaciones. Estos métodos serán llamados
desde el main.

• La clase Simulador debe tener un método que genere un listado de alumnos manera
aleatoria y lo retorne. Las combinaciones de nombre y apellido deben ser generadas de
manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.

• Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro de un
rango real de números de documentos. Y agregar a los alumnos su DNI. Este método
debe retornar la lista de dnis.

• Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad de
objetos Alumno, elegidos por el usuario, y le asigne los nombres y los dnis de las dos
listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni, pero si con el
mismo nombre.

• Se debe imprimir por pantalla el listado de alumnos.

• Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó.

• Crearemos un método votación en la clase Simulador que, recibe el listado de alumnos y
para cada alumno genera tres votos de manera aleatoria. En este método debemos
guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno a la cantidad de
votos a cada alumno que reciba un voto, que es un atributo de la clase Alumno.
Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez al
mismo alumno. Utilizar un hashset para resolver esto.

• Se debe crear un método que muestre a cada Alumno con su cantidad de votos y cuales
fueron sus 3 votos.

• Se debe crear un método que haga el recuento de votos, este recibe la lista de Alumnos y
comienza a hacer el recuento de votos.

• Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear 5
facilitadores suplentes con los 5 segundos alumnos más votados. A continuación, mostrar
los 5 facilitadores y los 5 facilitadores suplentes.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Sebastian
 */
public class Simulador {

    public Simulador() {

    }

    public static ArrayList<String> generarNombres() {
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Juan", "Jose", "Carlos", "Micaela", "Martina", "Camila", "Pedro", "Maria", "Marcos", "Sabrina", "Sara", "Julio"));
        ArrayList<String> apellidos = new ArrayList<>(Arrays.asList("Martinez", "Garcia", "Gonzalez", "Rossi", "Costa", "Estevez", "Echenique", "Ramirez", "Sarmiento", "Moreno", "Muller"));
        ArrayList<String> nombresCompletos = new ArrayList<>();
        int num1, num2;
        for (int i = 0; i < 100; i++) { //elegi 100, porque segun consigna, no importa si se repiten nombres, podrian haber sido menos.
            num1 = (int) (Math.random() * nombres.size());
            num2 = (int) (Math.random() * apellidos.size());
            String nombreGenerado = nombres.get(num1) + " " + apellidos.get(num2);
            nombresCompletos.add(nombreGenerado);
        }
        return nombresCompletos;
    }

    public static ArrayList<Long> generarDnis(int x) { //x es la cantidad de dnis a crear
        ArrayList<Long> dnis = new ArrayList<>();
        for (int i = 0; i < x; i++) { //aca si importa que el dni sea unico para cada objeto alumno. int x = cantidad de dnis = cantidad de objetos alumnos a crear.
            Long dni = (long) (Math.random() * (50000000 - 30000000) + 30000000); //rango entre 30,000,000 y 50,000,000
            dnis.add(dni);
        }
        return dnis;
    }

    public static ArrayList<Alumno> crearAlumnos(int x, ArrayList<String> nombres, ArrayList<Long> dnis) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        int num1, num2;
        for (int i = 0; i < x; i++) {
            num1 = (int) (Math.random() * nombres.size());
            num2 = (int) (Math.random() * dnis.size());
            String nombre = nombres.get(num1);
            Long dni = dnis.get(num2);
            dnis.remove(num2); //elimino el dni elegido de la lista, para que no se vuelva a repetir en otro Alumno.
            Alumno alumno = new Alumno(nombre, dni);
            alumnos.add(alumno);
        }
        return alumnos;
    }

    public static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public static HashMap<Alumno, HashSet<Alumno>> votacion(ArrayList<Alumno> alumnos) {
        HashMap<Alumno, HashSet<Alumno>> votosAlumno = new HashMap<>();
        HashSet<Alumno> alumnosVotados;
        boolean bandera = false;
        int votos;
        for (Alumno alumno : alumnos) {
            alumnosVotados = new HashSet<>();
            alumnosVotados.add(alumno); //para evitar que se vote a si mismo. En linea 128 se corrige.
            for (int i = 0; i < 3; i++) {
                do {
                    int aleatorio = (int) (Math.random() * alumnos.size());
                    alumnosVotados.add(alumnos.get(aleatorio));
                    if(alumnosVotados.size() - 1 == i + 1){ //Al .size() se le resta 1 (ver linea 112)
                        votos = alumnos.get(aleatorio).getCantVotos();
                        votos++;
                        alumnos.get(aleatorio).setCantVotos(votos);
                        bandera = true;
                    }
                } while (bandera == false); //la bandera sera false hasta que se convalide su voto(que no se vote a si mismo, ni repita el mismo voto a un compañero 2 veces)
                bandera = false;
            }
            alumnosVotados.remove(alumno);
            votosAlumno.put(alumno, alumnosVotados);
        }
        return votosAlumno;
    }

    public static void mostrarVotos(HashMap<Alumno, HashSet<Alumno>> listaVotos) {

        for (Map.Entry<Alumno, HashSet<Alumno>> entry : listaVotos.entrySet()) {
            System.out.println("El alumno/a " + entry.getKey().getNombreCompleto() + " obtuvo " + entry.getKey().getCantVotos() + " votos de sus compañeros. Sus votos fueron para: ");
            for (Alumno alumno : entry.getValue()) {
                System.out.println(alumno.getNombreCompleto());
            }
            System.out.println("");
        }
    }
    
    public static void recuentoVotos(ArrayList<Alumno> alumnos){
        alumnos.sort(Alumno.compararVotos); //Comparator
        System.out.println("Los facilitadores elegidos son: ");
        for (int i = 0; i < 5; i++) {
            if(i < 5){
                System.out.println(alumnos.get(i));
            }
        }
        System.out.println("");
        System.out.println("Los facilitadores suplentes son: ");
        for (int i = 5; i < 10; i++) {
            System.out.println(alumnos.get(i));
        }
    }
}
