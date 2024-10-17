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
public class VehiculoSUV extends Vehiculo {
    private boolean traccionIntegral ;

    public VehiculoSUV( String codigoVehiculo, String modelo, double precioBase, boolean traccionIntegral) {
        super(codigoVehiculo, modelo, precioBase);
        this.traccionIntegral = traccionIntegral;
    }

    @Override
    public double calcularCostoReparacion(int horas) {
        double costoTotal = (precioBase * horas);
            
        if (esTraccionIntegral()){
            double descuento = ( costoTotal / 100) * 10;
            costoTotal = costoTotal - descuento;
        }
        return costoTotal;
    }

    public boolean isTraccionIntegral() {
        return traccionIntegral;
    }

    public void setTraccionIntegral(boolean traccionIntegral) {
        this.traccionIntegral = traccionIntegral;
    }

    
    public boolean esTraccionIntegral(){
        boolean tiene = false;

        if (isTraccionIntegral()) {
            tiene = true;
              
        }
        return tiene;
    }
    
    
}
