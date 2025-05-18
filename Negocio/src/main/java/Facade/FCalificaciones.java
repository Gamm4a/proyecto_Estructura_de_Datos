/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.ArregloCalificaciones;
import Interfaz.ICalificaciones;
import ObjetosNegocio.Estudiantes;
import ObjetosNegocio.Accion;
import static ObjetosNegocio.Accion.Tipo.*;
import Implementaciones.Cola;

/**
 *
 * @author Luis Rafael
 */
public class FCalificaciones implements ICalificaciones{

    private ArbolBinarioBusqueda<Estudiantes> arbol;
    private Cola<Accion> cola = new Cola();

    @Override
    public void agregarCalificacion(Accion accion) {
        Estudiantes estudiante = accion.getEstudiante();
        estudiante.getCalificaciones().agregarElemento(accion.getCalificacionNueva());
        FDeshacer.registrarAccion(accion);
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
    public boolean modificarCalificacion(Accion accion) {
        Estudiantes estudiante = accion.getEstudiante();

        FDeshacer.registrarAccion(accion);

        return estudiante.getCalificaciones().modificarElemento(accion.getCalificacionAnterior(), accion.getCalificacionNueva());
    } 

    @Override
    public void eliminarCalificacion(String matricula, int posicion) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();
        calificaciones.eliminarElemento(posicion);
    }

    @Override
    public void enviarSolicitudAgregarCalificaion(String matricula, double calificacion) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        Accion accion = new Accion(CALIFICACION_AGREGADA, estudiante, null, null, calificacion, 0);
        cola.add(accion);
    }

    @Override
    public void enviarSolicitudModificarCalificaion(String matricula, double calificacion, double calNueva) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        Accion accion = new Accion(CALIFICACION_MODIFICADA, estudiante, null, calificacion, calNueva, 0);
        cola.add(accion);
    }

    @Override
    public void procesarSolicitud() {
        if (cola.dequeue().getTipo().equals(CALIFICACION_AGREGADA)) {
            agregarCalificacion(cola.dequeue());
        }
        if (cola.dequeue().getTipo().equals(CALIFICACION_MODIFICADA)) {
            modificarCalificacion(cola.dequeue());
        }
    }
}
