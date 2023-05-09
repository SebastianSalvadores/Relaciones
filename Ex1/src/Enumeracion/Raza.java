/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
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
    BORDER_COLLIE("Border Collie"),
    CANICHE("Caniche"),
    DOGO("Dogo"),
    BEAGLE("Beagle"),
    DOBERMAN("Doberman"),
    PASTOR_ALEMAN("Pastor Alemán"),
    GOLDEN_RETRIEVER("Golden Retriever"),
    MESTIZO("Mestizo");
    
    String raza;
    Raza (String raza){
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }
    
}
