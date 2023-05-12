/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cuotas;
import Enumeraciones.FormaPago;
import Utilidades.ComprobarFecha;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class CuotasServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Cuotas crearCuotas(int cuota, double montoTotal, FormaPago formaPago){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");               
        System.out.println("Ingrese fecha de vencimiento de cuota "+(cuota+1)+": (DD/MM/AAAA)");
        String fechaV;
        Date fechaVencimiento = null;
        do {            
            fechaV = leer.next().replace(" ", "/").replace("-", "/");
            if(ComprobarFecha.isDate(fechaV) == false){
                System.out.println("Fecha ingresada incorrecta.");
            }
        } while (ComprobarFecha.isDate(fechaV) == false);
        try {
            fechaVencimiento = dateFormat.parse(fechaV);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        
        return new Cuotas(cuota, montoTotal, false, fechaVencimiento, formaPago);
    }
}
