/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Auto;
import Entidades.Cliente;
import Entidades.Poliza;
import Enumeraciones.Cobertura;
import Enumeraciones.FormaPago;
import Utilidades.ComprobarFecha;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class PolizaServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Poliza crearPoliza(){
        ClienteServicio clienteServ = new ClienteServicio();
        AutoServicio autoServ = new AutoServicio();
        Cliente cliente = clienteServ.crearCliente();
        Auto vehiculo = autoServ.crearAuto();
        System.out.println("Ingrese numero de poliza");
        long numPoliza = leer.nextLong();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Ingrese fecha de inicio (DD/MM/AAAA): ");
        String fechaInicio;
        Date fechaI = null;
        do {            
            fechaInicio = leer.next().replace(" ", "/").replace("-", "/");
            if(ComprobarFecha.isDate(fechaInicio) == false){
                System.out.println("Fecha ingresada incorrecta.");
            }
        } while (ComprobarFecha.isDate(fechaInicio) == false);
        try {
            fechaI = dateFormat.parse(fechaInicio);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        
        System.out.println("Ingrese fecha de finalizacion (DD/MM/AAAA): ");
        String fechaFin;
        Date fechaF = null;
        do {            
            fechaFin = leer.next().replace(" ", "/").replace("-", "/");
            if(ComprobarFecha.isDate(fechaFin) == false){
                System.out.println("Fecha ingresada incorrecta.");
            }
        } while (ComprobarFecha.isDate(fechaFin) == false);
        try {
            fechaF = dateFormat.parse(fechaFin);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        
        System.out.println("Ingrese cantidad de cuotas: ");
        int cuotas = leer.nextInt();
        
        boolean flag = false;
        String formaPago;
        do {            
            System.out.println("Ingrese la forma de pago: ");
            formaPago = leer.next().toUpperCase().replace(" ", "_");
            for (FormaPago value : FormaPago.values()) {
                if(value.toString().equalsIgnoreCase(formaPago)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                System.out.println("La forma de pago ingresada es incorrecta.");
            }
        } while (flag == false);
        flag = false;
        
        System.out.println("Ingrese el monto total asegurado: ");
        double montoTotalAsegurado = leer.nextDouble();
        char opc;
        boolean incluyeGranizo = false;
        double montoMaximoGranizo;
        System.out.println("¿Incluye granizo?(S/N)");
        do {            
            opc = leer.next().toUpperCase().charAt(0);
            if(opc != 'S' && opc != 'N'){
                System.out.println("Opcion ingresada incorrecta. Ingrese Si o No.");
            }else if(opc == 'S'){
                incluyeGranizo = true;
            }else{
                incluyeGranizo = false;
            }
        } while (opc != 'S' && opc != 'N');
        if(incluyeGranizo){
            System.out.println("Ingrese monto maximo de granizo:");
            montoMaximoGranizo = leer.nextDouble();
        }else{
            montoMaximoGranizo = 0;
        }
        
        String cobertura = null;
        do {            
            System.out.println("Ingrese el tipo de cobertura (total, contra terceros, etc.: ");
            cobertura = leer.next().toUpperCase().replace(" ", "_");
            for (Cobertura value : Cobertura.values()) {
                if(value.toString().equalsIgnoreCase(cobertura)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                System.out.println("El tipo de cobertura ingresado es incorrecto.");
            }
        } while (flag == false);
        
        return new Poliza(cliente, vehiculo, numPoliza, fechaI, fechaF, cuotas, FormaPago.valueOf(formaPago), montoTotalAsegurado, incluyeGranizo, montoMaximoGranizo, Cobertura.valueOf(cobertura));
    }
}
