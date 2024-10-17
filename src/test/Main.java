/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Noxie
 */
import java.util.List;
import model.Vehiculo;
import model.VehiculoCompacto;
import model.VehiculoSUV;
import model.Taller;

public class Main {
      public static void main(String[] args) {
          System.out.println("1-1");
          try{
              
               VehiculoCompacto vehiculo1 = new VehiculoCompacto(2024,"ABC1234","Toyota Corolla",2000.0);
                System.out.println(vehiculo1);
                System.out.println("1-2");
               VehiculoCompacto vehiculo2 = new VehiculoCompacto(2023,"XYZ5678","Honda Civic",2200);
               System.out.println(vehiculo2);
               System.out.println("1-3");
               VehiculoSUV vehiculo3 = new VehiculoSUV("QRS7890","Chevrolet Tahoe, precioBase",2200.0,false);
               System.out.println(vehiculo3);
               System.out.println("2-1");
               double costo2=vehiculo2.calcularCostoReparacion(5);
               System.out.println(costo2);
               System.out.println("3-1");
               Taller taller = new Taller("santos");
               // VehiculoCompacto [codigoVehiculo=LMN1111, modelo=Volkswagen Polo, precioBase=1800.0, anio=2024]
               VehiculoCompacto vehiculo4 = new VehiculoCompacto(2024,"LMN1111","Volkswagen Polo",1800.0);
               taller.agregarVehiculo(vehiculo4);
               System.out.println("3-2");

               VehiculoSUV  vehiculo5 = new VehiculoSUV ("LMN1112","Ford Explorer2",3000.0,true);
               taller.agregarVehiculo(vehiculo5);
               System.out.println("4-1");
               List<Vehiculo> disponibles = taller.traerVehiculosDisponibles();
               for(Vehiculo v : disponibles){
                   System.out.println(v);
                   
               }


               
               
               
               
               

                
                
                
                
          }
          catch(IllegalArgumentException e){
              System.out.println(e.getMessage());
              
              
          
      }
         
      }
    
}
