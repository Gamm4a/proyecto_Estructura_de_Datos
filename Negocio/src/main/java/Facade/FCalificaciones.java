/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.ArregloCalificaciones;
import Interfaz.ICalificaciones;
import ObjetosNegocio.Estudiantes;


/**
 *
 * @author Luis Rafael
 */
public class FCalificaciones implements ICalificaciones{

    private ArbolBinarioBusqueda<Estudiantes> arbol = new ArbolBinarioBusqueda<>();

    @Override
    public void agregarCalificacion(String matricula, double calificacion) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        estudiante.getCalificaciones().agregarElemento(calificacion);
    }

    @Override
    public double calcularPromedio(String matricula) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();
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
    public boolean modificarCalificacion(String matricula, double calificacion, double calNueva) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();
        return calificaciones.modificarElemento(calificacion, calNueva);
    }

    @Override
    public void eliminarCalificacion(String matricula, int posicion) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();
        calificaciones.eliminarElemento(posicion);
    }
}
