/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cliente;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class ClienteServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Cliente crearCliente(){
        System.out.println("Ingrese nombre del cliente: ");
        String nombre = leer.next();
        System.out.println("Ingrese apellido del cliente: ");
        String apellido = leer.next();
        System.out.println("Ingrese documento del cliente: ");
        long documento = leer.nextLong();
        System.out.println("Ingrese mail del cliente: ");
        String mail = leer.next();
        System.out.println("Ingrese domicilio del cliente: ");
        String domicilio = leer.next();
        System.out.println("Ingrese telefono del cliente: ");
        long telefono = leer.nextLong();
        return new Cliente(nombre, apellido, documento, mail, domicilio, telefono);
    }
}
