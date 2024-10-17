/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author Noxie
 */
import model.EstadoVehiculo;
import java.util.List;       // Para usar la interfaz List
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Vehiculo {
    protected String codigoVehiculo ;
    protected String  modelo;
    protected double precioBase ;
    protected EstadoVehiculo  estado ;
    protected List<String> historialReparaciones ;

    public Vehiculo(String codigoVehiculo, String modelo, double precioBase) {
        if (codigoVehiculo.length() != 7) {
            throw new IllegalArgumentException("El código del vehículo debe tener exactamente 7 caracteres.");
        }
        this.codigoVehiculo = codigoVehiculo;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.estado  = EstadoVehiculo.DISPONIBLE;
      
        this.historialReparaciones = new ArrayList<>();
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "codigoVehiculo=" + codigoVehiculo + ", modelo=" + modelo + ", precioBase=" + precioBase + ", estado=" + estado + '}';
    }

   

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }
    public abstract double calcularCostoReparacion(int horas);
    
    public void iniciarReparacion(String nombreTaller , String descripcion){
        // Marca el vehículo como en reparación y añade la fecha(Fecha Actual), el nombre del taller junto con una descripción al historial.
        //Formato “YYYY-MM-DD: [NombreTaller] Descripción
        setEstado(estado.EN_REPARACION);

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formatter);
        String historial =fechaFormateada + ":" + "["+ nombreTaller +"]"+ descripcion ; 
        historialReparaciones.add(historial);


    }
    public void finalizarReparacion(){
        // Marca el vehículo como disponible nuevamente y añade una entrada en el historial indicando el fin de la reparación.
        setEstado(estado.DISPONIBLE);
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaHoraActual.format(formatter);
        
        String historial = fechaFormateada + ": Reparación finalizada.";
        historialReparaciones.add(historial);

        
    }
    public List<String>obtenerHistorialReparaciones(){
        //Retorna el historial de reparaciones del vehículo.
        return historialReparaciones;
    
    }

    
}
