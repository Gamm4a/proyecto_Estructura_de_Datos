/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;
import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.ArregloCalificaciones;
import Interfaz.IEstudiantes;

import ObjetosNegocio.Estudiantes;
/**
 *
 * @author Luis Rafael
 */
public class FEstudiantes implements IEstudiantes{
    private ArbolBinarioBusqueda arbol;
    private ArregloCalificaciones<Double> calificaciones;
    
    @Override
    public void agregarCalificacion(double calificacion) {
        calificaciones.agregarElemento(calificacion);
    }
    
    @Override
    public double calcularPromedio() {
        double suma = 0.0;
        if (calificaciones.getTam() == 0) {
            return 0.0;
        }
        for (int i = 0; i < calificaciones.getTam(); i++) {
            suma += calificaciones.obtenerElemento(i);
        }
        return suma / calificaciones.getTam();
    }
    
    @Override
    public boolean modificarCalificacion(double calificacion, double calNueva) {
        return calificaciones.modificarElemento(calificacion, calNueva);
    }
    
    @Override
    public void registrarEstudiante(Estudiantes estudiante){
        arbol.insertar(estudiante.getMatricula());
    }
}
