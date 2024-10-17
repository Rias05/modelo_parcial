/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Noxie
 */
public class VehiculoCompacto extends Vehiculo {

    private int anio;// Año de fabricación del vehículo.

    public VehiculoCompacto(int anio, String codigoVehiculo, String modelo, double precioBase) {
        super(codigoVehiculo, modelo, precioBase);
        this.anio = anio;
    }

    @Override
    public double calcularCostoReparacion(int horas) {
        //  Implementa el método para calcular el costo de reparación,
        //considerando un costo base multiplicado por el número de horas y un descuento del 5% si el vehículo es del año actual
        double costoTotal = (precioBase * horas);
            
        if (esVehiculoNuevo( )){
            double descuento = ( costoTotal / 100) * 5;
            costoTotal = costoTotal - descuento;
        }
        return costoTotal;

    }

    public boolean esVehiculoNuevo() {
        boolean esNuevo = false;
        int añoActual = LocalDate.now().getYear();

        if (anio == (LocalDate.now().getYear())) {
               esNuevo=true;
        }
        return esNuevo;
        
    }

}
