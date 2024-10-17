/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noxie
 */
public class Taller {

    private String nombreTaller;
    private List<Vehiculo> inventarioVehiculos;
    private List<Vehiculo> vehiculosEnReparacion;
    private List<Vehiculo> vehiculosFueraDeServicio;

    public Taller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
        this.inventarioVehiculos = new ArrayList<>();
        this.vehiculosEnReparacion = new ArrayList<>();
        this.vehiculosFueraDeServicio = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        //  Permite agregar un nuevo vehículo al inventario del taller, lanzando una excepción si ya existe un vehículo con el mismo código.
       
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getCodigoVehiculo() == vehiculo.getCodigoVehiculo()) {
                throw new IllegalArgumentException("El vehículo con este código ya existe.");
            }
        
        }
        inventarioVehiculos.add(vehiculo);
    }

    public void calcularCostoReparacion(String codigoVehiculo, int horas) {
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getCodigoVehiculo() == codigoVehiculo) {
                v.calcularCostoReparacion(horas);

            }
            if (v.getEstado() != EstadoVehiculo.EN_REPARACION) {
                throw new IllegalArgumentException("El vehículo con código " + codigoVehiculo + " no está en reparación.");
            }

        }

    }

    public void iniciarReparacion(String codigoVehiculo, String descripcion) {
        //Marca el vehículo como en reparación y lo añade a la lista de vehículos en reparación. Lanza una excepción si ya está en reparación
        for (Vehiculo v : inventarioVehiculos) {

            if (v.getEstado() == EstadoVehiculo.EN_REPARACION ){
                throw new IllegalArgumentException("error el vehiculo con el cdoigo " + codigoVehiculo + " ya esta en reparacion");

            }
            if (v.getCodigoVehiculo().equals(codigoVehiculo)) {// amnera correcta

                v.iniciarReparacion(nombreTaller, descripcion);
                vehiculosEnReparacion.add(v);

            }

        }

    }
    
    
    
    public void finalizarReparacion(String codigoVehiculo){
        for (Vehiculo v :vehiculosEnReparacion){
            if (!v.getCodigoVehiculo().equals(codigoVehiculo)){
                throw new IllegalArgumentException("error el vehiculo con el cdoigo " + codigoVehiculo + " NO ESTA EN REPARACION");
                
            }
            else{
                 v.finalizarReparacion();
                 vehiculosEnReparacion.remove(v) ;
                 v.setEstado(EstadoVehiculo.DISPONIBLE);
            }
           
            
            
        }
        
    }
    public List<Vehiculo> traerVehiculosDisponibles(){
        
        List<Vehiculo> disponibles = new ArrayList<>();
        
        for (Vehiculo v: inventarioVehiculos){
            if (v.getEstado()!= EstadoVehiculo.EN_REPARACION){
                disponibles.add(v);
                
                
            }
            
        }
        return disponibles;
    }
    public List<Vehiculo> traerVehiculos(EstadoVehiculo estado){
        List<Vehiculo> cumplen = new ArrayList<>();
        for (Vehiculo v : inventarioVehiculos){
            
            if(v.getEstado()== estado){
                cumplen.add(v);
                
                
            }
            
        }
        return cumplen;
        
    }
    public void obtenerHistorialReparaciones(String codigoVehiculo){
        for (Vehiculo v :inventarioVehiculos ){
            if (v.getCodigoVehiculo().equals(codigoVehiculo) ){
                v.obtenerHistorialReparaciones();
                
            }
            else{
                throw new IllegalArgumentException("error el vehiculo no exite con el cdoigo " + codigoVehiculo);
            }
            
        }
        
    }

}
