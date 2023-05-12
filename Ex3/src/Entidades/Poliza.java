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
package Entidades;

import Enumeraciones.Cobertura;
import Enumeraciones.FormaPago;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class Poliza {
    private Cliente cliente;
    private Auto vehiculo;
    private long numPoliza;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantCuotas;
    private FormaPago formaPago;
    private double montoTotalAsegurado;
    private boolean incluyeGranizo;
    private double montoMaximoGranizo;
    private Cobertura cobertura;

    public Poliza() {
    }

    public Poliza(Cliente cliente, Auto vehiculo, long numPoliza, Date fechaInicio, Date fechaFin, int cantCuotas, FormaPago formaPago, double montoTotalAsegurado, boolean incluyeGranizo, double montoMaximoGranizo, Cobertura cobertura) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.numPoliza = numPoliza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantCuotas = cantCuotas;
        this.formaPago = formaPago;
        this.montoTotalAsegurado = montoTotalAsegurado;
        this.incluyeGranizo = incluyeGranizo;
        this.montoMaximoGranizo = montoMaximoGranizo;
        this.cobertura = cobertura;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Auto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Auto vehiculo) {
        this.vehiculo = vehiculo;
    }

    public long getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(long numPoliza) {
        this.numPoliza = numPoliza;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getMontoTotalAsegurado() {
        return montoTotalAsegurado;
    }

    public void setMontoTotalAsegurado(double montoTotalAsegurado) {
        this.montoTotalAsegurado = montoTotalAsegurado;
    }

    public boolean isIncluyeGranizo() {
        return incluyeGranizo;
    }

    public void setIncluyeGranizo(boolean incluyeGranizo) {
        this.incluyeGranizo = incluyeGranizo;
    }

    public double getMontoMaximoGranizo() {
        return montoMaximoGranizo;
    }

    public void setMontoMaximoGranizo(double montoMaximoGranizo) {
        this.montoMaximoGranizo = montoMaximoGranizo;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    @Override
    public String toString() {
        return "Poliza{" + "cliente=" + cliente + ", vehiculo=" + vehiculo + ", numPoliza=" + numPoliza + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cantCuotas=" + cantCuotas + ", formaPago=" + formaPago + ", montoTotalAsegurado=" + montoTotalAsegurado + ", incluyeGranizo=" + incluyeGranizo + ", montoMaximoGranizo=" + montoMaximoGranizo + ", cobertura=" + cobertura + '}';
    }
    
}
