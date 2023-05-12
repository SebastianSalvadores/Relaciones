/*
Ha llegado el momento de poner de prueba tus conocimientos. Para te vamos a contar que te
ha contratado “La Tercera Seguros”, una empresa aseguradora que brinda a sus clientes
coberturas integrales para vehículos.

Luego de un pequeño relevamiento, te vamos a pasar en limpio los requerimientos del sistema
que quiere realizar la empresa.

    a. Gestión Integral de clientes. En este módulo vamos a registrar la información personal de
    cada cliente que posea pólizas en nuestra empresa. Nombre y apellido, documento, mail,
    domicilio, teléfono.
    b. Gestión de vehículos. Se registra la información de cada vehículo asegurado. Marca,
    modelo, año, número de motor, chasis, color, tipo (camioneta, sedán, etc.).
    c. Gestión de Pólizas: Se registrará una póliza, donde se guardará los datos tanto de un
    vehículo, como los datos de un solo cliente. Los datos incluidos en ella son: número de
    póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, forma de pago, monto total
    asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra
    terceros, etc.). Nota: prestar atención al principio de este enunciado y pensar en las
    relaciones entre clases. Recuerden que pueden ser de uno a uno, de uno a muchos, de
    muchos a uno o de muchos a muchos.
    d. Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza.
    Esas cuotas van a contener la siguiente información: número de cuota, monto total de la
    cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia,
    etc.).

Debemos realizar el diagrama de clases completo, teniendo en cuenta todos los
requerimientos arriba descriptos. Modelando clases con atributos y sus correspondientes
relaciones.
 */
package ex3;

import Entidades.Cliente;
import Entidades.Cuotas;
import Entidades.Poliza;
import Servicios.CuotasServicio;
import Servicios.PolizaServicio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashMap<Long, Poliza> polizas = new HashMap<>();
        ArrayList<Cuotas> cuotas = new ArrayList<>();
        HashMap<Long, ArrayList<Cuotas>> cuotasMap = new HashMap<>();
        HashMap<Long, Poliza> clientes = new HashMap<>();
        HashMap<Long, Poliza> autos = new HashMap<>();
        PolizaServicio polizaServ = new PolizaServicio();
        CuotasServicio cuotasServ = new CuotasServicio();

        int opc;
        do {
            System.out.println("LA TERCERA SEGUROS - MENU PRINCIPAL"
                    + "\n1. Buscar Cliente"
                    + "\n2. Buscar Vehículo"
                    + "\n3. Pólizas"
                    + "\n4. Pagar Cuotas"
                    + "\n5. Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("*** Clientes ***");
                    if (!clientes.isEmpty()) {
                        System.out.println("Ingrese documento del cliente a buscar:");
                        long doc = leer.nextLong();
                        for (Map.Entry<Long, Poliza> entry : clientes.entrySet()) {
                            if (entry.getKey() == doc) {
                                System.out.println(entry.getValue().toString());
                            } else {
                                System.out.println("documento no encontrado.");
                            }
                        }
                    } else {
                        System.out.println("Aun no se ha creado ninguna poliza.");
                    }
                    break;
                case 2:
                    System.out.println("*** Vehículos ***");
                    if (!clientes.isEmpty()) {
                        System.out.println("Ingrese numero de motor del vehículo a buscar:");
                        long numMotor = leer.nextLong();
                        for (Map.Entry<Long, Poliza> entry : autos.entrySet()) {
                            if (entry.getKey() == numMotor) {
                                System.out.println(entry.getValue().toString());
                            } else {
                                System.out.println("numero de motor no encontrado.");
                            }
                        }
                    } else {
                        System.out.println("Aun no se ha creado ninguna poliza.");
                    }
                    break;
                case 3:
                    do {
                        System.out.println("*** Pólizas ***"
                                + "\n1. Crear Poliza"
                                + "\n2. Buscar Poliza"
                                + "\n3. Borrar Poliza"
                                + "\n4. Volver");
                        opc = leer.nextInt();
                        switch (opc) {
                            case 1:
                                System.out.println("Crear poliza");
                                Poliza poliza = polizaServ.crearPoliza();
                                polizas.put(poliza.getNumPoliza(), poliza);
                                clientes.put(poliza.getCliente().getDocumento(), poliza);
                                autos.put(poliza.getVehiculo().getNumMotor(), poliza);
                                System.out.println("Ingrese monto total de las cuotas: ");
                                double montoTotal = leer.nextDouble();
                                montoTotal /= poliza.getCantCuotas();
                                for (int i = 0; i < poliza.getCantCuotas(); i++) {
                                    cuotas.add(cuotasServ.crearCuotas(i, montoTotal, poliza.getFormaPago()));

                                }

                                cuotasMap.put(poliza.getNumPoliza(), cuotas);
                                break;
                            case 2:
                                System.out.println("Ingrese numero de poliza: ");
                                long numPoliza = leer.nextLong();
                                for (Map.Entry<Long, Poliza> entry : polizas.entrySet()) {
                                    if (entry.getKey() == numPoliza) {
                                        System.out.println(entry.getValue().toString());
                                    } else {
                                        System.out.println("numero de poliza no encontrado.");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese numero de poliza: ");
                                long numeroPoliza = leer.nextLong();
                                for (Map.Entry<Long, Poliza> entry : polizas.entrySet()) {
                                    if (entry.getKey() == numeroPoliza) {
                                        polizas.remove(entry.getValue().getNumPoliza());
                                        break;
                                    } else {
                                        System.out.println("numero de poliza no encontrado.");
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Regresando al menu principal.");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    } while (opc != 4);
                    break;
                case 4:
                    if (!cuotasMap.isEmpty()) {
                        System.out.println("Ingrese numero de poliza:");
                        long nroPoliza = leer.nextLong();
                        for (Map.Entry<Long, ArrayList<Cuotas>> entry : cuotasMap.entrySet()) {
                            if (nroPoliza == entry.getKey()) {
                                ArrayList<Cuotas> listaCuotas = entry.getValue();
                                int cant = 0;
                                for (Cuotas cuota : listaCuotas) {
                                    if (cuota.isPagada() == false) {
                                        cant++;
                                    }
                                }
                                if (cant == 0) {
                                    System.out.println("No se han encontrado cuotas sin pagar en la poliza nro: " + nroPoliza);
                                } else {
                                    char opcion;
                                    System.out.println("Se han encontrado " + cant + " cuotas sin pagar.");
                                    for (Cuotas cuota : listaCuotas) {
                                        if (cuota.isPagada() == false) {
                                            System.out.println(cuota.toString());
                                            System.out.println("¿Desea pagarla?(S/N)");
                                            do {

                                                opcion = leer.next().toUpperCase().charAt(0);
                                                if (opcion != 'S' && opcion != 'N') {
                                                    System.out.println("Opcion ingresada incorrecta. Ingrese Si o No.");
                                                } else if (opcion == 'S') {
                                                    cuota.setPagada(true);
                                                    System.out.println("El pago fue realizado.");
                                                }
                                            } while (opcion != 'S' && opcion != 'N');
                                        }
                                    }
                                }
                            } else {
                                System.out.println("No se encontro el numero de poliza.");
                            }
                        }
                    } else {
                        System.out.println("Aun no se ha creado ninguna poliza.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opc != 5);
    }

}
