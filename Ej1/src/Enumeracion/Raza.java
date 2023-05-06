/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package Enumeracion;

/**
 *
 * @author Sebastian
 */
public enum Raza {
    LABRADOR("Labrador"),
    GALGO("Galgo"),
    PITBULL("Pitbull"),
    COLLIE("Collie"),
    CANICHE("Caniche"),
    DOGO("Dogo");
    
    String raza;
    Raza (String raza){
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }
    
}
