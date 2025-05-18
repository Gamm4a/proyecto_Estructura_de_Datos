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
public class FCalificaciones implements ICalificaciones {

    private ArbolBinarioBusqueda<Estudiantes> arbol;
    private Cola<Accion> colaSolicitudes = new Cola<>();
    /**
     * constructor que crea un arbol binario de busqueda para alumnos
     * @param arbolCompartido arbol de estudiantes
     */
    public FCalificaciones(ArbolBinarioBusqueda<Estudiantes> arbolCompartido) {
        this.arbol = arbolCompartido;
    }
    
    /**
     * metodo para agregar una calificacion a un estudiante
     * @param accion accion 
     */
    @Override
    public void agregarCalificacion(Accion accion) {
        Estudiantes estudiante = accion.getEstudiante();
        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();

        calificaciones.agregarElemento(accion.getCalificacionNueva());

        int pos = calificaciones.getTam() - 1;

        Accion accionFinal = new Accion(
                Accion.Tipo.CALIFICACION_AGREGADA,
                estudiante, null, null,
                accion.getCalificacionNueva(),
                pos
        );

        FDeshacer.registrarAccion(accionFinal);
        System.out.println("Calificación agregada.");
    }
    /**
     *metodo para modificar la calificacion a un estudiante
     * @param accion accion
     * @return modificacion realizada o fallida
     */
    @Override
    public boolean modificarCalificacion(Accion accion) {
        Estudiantes estudiante = accion.getEstudiante();
        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();


        boolean ok = calificaciones.modificarElemento(accion.getCalificacionAnterior(), accion.getCalificacionNueva());

        if (ok) {
            Accion accionFinal = new Accion(
                    Accion.Tipo.CALIFICACION_MODIFICADA,
                    estudiante, null,
                    accion.getCalificacionAnterior(),
                    accion.getCalificacionNueva(),
                    -1
            );
            FDeshacer.registrarAccion(accionFinal);
            System.out.println("Calificación modificada.");
        }

        return ok;
    }
    
    /**
     * metodo para eliminar una calificacion de un estudiantes
     * @param matricula matricula del estudiante
     * @param posicion posicion de la califciacion
     */
    @Override
    public void eliminarCalificacion(String matricula, int posicion) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();

        if (posicion < 0 || posicion >= calificaciones.getTam()) {
            System.out.println("Posición inválida.");
            return;
        }

        Double calAnterior = calificaciones.obtenerElemento(posicion);
        calificaciones.eliminarElemento(posicion);

        Accion accion = new Accion(
                Accion.Tipo.CALIFICACION_AGREGADA,
                estudiante, null,
                calAnterior, null,
                posicion
        );
        FDeshacer.registrarAccion(accion);
        System.out.println("Calificación eliminada.");
    }
    
    /**
     * metodo para calcular el promedio de un estudiante
     * @param matricula matricula del estudiante
     * @return promedio calculado
     */
    @Override
    public double calcularPromedio(String matricula) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return 0.0;
        }

        ArregloCalificaciones<Double> calificaciones = estudiante.getCalificaciones();
        if (calificaciones.getTam() == 0) {
            return 0.0;
        }

        double suma = 0.0;
        for (int i = 0; i < calificaciones.getTam(); i++) {
            suma += calificaciones.obtenerElemento(i);
        }

        return suma / calificaciones.getTam();
    }
    
    /**
     * metodo ara enviar una solicitud para agregar la calificacion
     * @param matricula matricula del estudiante
     * @param calificacion calificacion a ingresar
     */
    @Override
    public void enviarSolicitudAgregarCalificaion(String matricula, double calificacion) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        Accion accion = new Accion(
                Accion.Tipo.CALIFICACION_AGREGADA,
                estudiante, null, null,
                calificacion, -1
        );

        colaSolicitudes.enqueue(accion);
        System.out.println("Solicitud de agregar calificación enviada.");
    }
    
    /**
     * metodo para enviar una solisitud de modificar la calificacion de un estudiante
     * @param matricula matricula del estudiante
     * @param calAnterior calificaciona a reemplazar
     * @param calNueva nueva calificacion
     */
    @Override
    public void enviarSolicitudModificarCalificaion(String matricula, double calAnterior, double calNueva) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        Accion accion = new Accion(
                Accion.Tipo.CALIFICACION_MODIFICADA,
                estudiante, null,
                calAnterior, calNueva,
                -1
        );
        colaSolicitudes.enqueue(accion);
        System.out.println("Solicitud de modificar calificación enviada.");
    }
    
    /**
     * metodo para procesar la solicitud
     */
    @Override
    public void procesarSolicitud() {
        
        if (colaSolicitudes.vacia()){
            System.out.println("No hay solicitudes pendientes.");
            return;
        }
        Accion accion = colaSolicitudes.dequeue();
        switch (accion.getTipo()) {
            case CALIFICACION_AGREGADA -> agregarCalificacion(accion);

            case CALIFICACION_MODIFICADA -> modificarCalificacion(accion);

            default -> System.out.println("Tipo de solicitud no reconocida.");
        }
    }
}

