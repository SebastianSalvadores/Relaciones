/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Auto;
import Enumeraciones.Chasis;
import Enumeraciones.Marca;
import Enumeraciones.Tipo;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class AutoServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Auto crearAuto(){
        boolean flag = false;
        String marca;
        do {            
            System.out.println("Ingrese marca del vehiculo: ");
            marca = leer.next().toUpperCase().replace(" ", "_");
            for (Marca value : Marca.values()) {
                if(value.toString().equalsIgnoreCase(marca)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                System.out.println("La marca no fue encontrada.");
            }
        } while (flag == false);
        flag = false;
        System.out.println("Ingrese modelo del vehiculo: ");
        String modelo = leer.next();
        System.out.println("Ingrese año de fabricación: ");
        int anio = leer.nextInt();
        System.out.println("Ingrese numero del motor: ");
        long numMotor = leer.nextLong();
        String chasis;
        do {            
            System.out.println("Ingrese chasis: ");
            chasis = leer.next().toUpperCase().replace(" ", "_");
            for (Object value : Chasis.values()) {
                if(value.toString().equalsIgnoreCase(chasis)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                System.out.println("Chasis ingresado incorrecto.");
            }
        } while (flag == false);
        flag = false;
        System.out.println("Ingrese color del vehiculo: ");
        String color = leer.next();
        String tipoAuto;
        do {            
            System.out.println("Ingrese tipo de vehiculo(camioneta, sedan, etc.): ");
            tipoAuto = leer.next().toUpperCase().replace(" ", "_");
            for (Object value : Tipo.values()) {
                if(value.toString().equalsIgnoreCase(tipoAuto)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                System.out.println("Tipo ingresado incorrecto.");
            }
        } while (flag == false);
        return new Auto(Marca.valueOf(marca), modelo, anio, numMotor, Chasis.valueOf(chasis), color, Tipo.valueOf(tipoAuto));
    }
}
