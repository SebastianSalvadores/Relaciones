/*
Ha llegado el momento de poner de prueba tus conocimientos. Para te vamos a contar que te
ha contratado La Tercera Seguros, una empresa aseguradora que brinda a sus clientes
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

import Enumeraciones.Chasis;
import Enumeraciones.Marca;
import Enumeraciones.Tipo;

/**
 *
 * @author Sebastian
 */
public class Auto {
    private Marca marca;
    private String modelo;
    private int anio;
    private long numMotor;
    private Chasis chasis;
    private String color;
    private Tipo tipoAuto;

    public Auto() {
    }

    public Auto(Marca marca, String modelo, int anio, long numMotor, Chasis chasis, String color, Tipo tipoAuto) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.numMotor = numMotor;
        this.chasis = chasis;
        this.color = color;
        this.tipoAuto = tipoAuto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public long getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(long numMotor) {
        this.numMotor = numMotor;
    }

    public Chasis getChasis() {
        return chasis;
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Tipo getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(Tipo tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    @Override
    public String toString() {
        return "Auto{" + "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", numMotor=" + numMotor + ", chasis=" + chasis + ", color=" + color + ", tipoAuto=" + tipoAuto + '}';
    }
    
}
