/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Enumeraciones.Chasis;

/**
 *
 * @author Sebastian
 */
public class ComprobarFecha {
    
    public static boolean isDate(String str) {
        return str.matches("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}");
    }

}
