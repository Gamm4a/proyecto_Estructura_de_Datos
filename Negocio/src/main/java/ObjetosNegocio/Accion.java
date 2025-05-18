/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Implementaciones.Pila;

/**
 *
 * @author Camila Zubía
 */
public class Accion {
    /**
     * clase interna de tipos de accion
     */
    public enum Tipo {
        REGISTRO_ESTUDIANTE,
        ELIMINAR_ESTUDIANTE,
        INSCRIPCION,
        BAJA_ESTUDIANTE,
        AGREGAR_CURSO,
        ELIMINAR_CURSO,
        CALIFICACION_AGREGADA,
        CALIFICACION_MODIFICADA
    }

    private Tipo tipo;
    private Estudiantes estudianteInvolucrado;
    private Cursos cursoInvolucrado;
    private Double calificacionAnterior;
    private Double calificacionNueva;
    private int posicionCalificacion;
    
    /**
     * contructor que crea una nueva accion
     * @param tipo tipo accion
     * @param estudiante accion
     * @param curso accion
     * @param calificacionAnterior accion
     * @param calificacionNueva accion
     * @param posicion accion
     */
    public Accion(Tipo tipo, Estudiantes estudiante, Cursos curso,
            Double calificacionAnterior, Double calificacionNueva, int posicion) {
        this.tipo = tipo;
        this.estudianteInvolucrado = estudiante;
        this.cursoInvolucrado = curso;
        this.calificacionAnterior = calificacionAnterior;
        this.calificacionNueva = calificacionNueva;
        this.posicionCalificacion = posicion;
    }
    
    // getters and setters
    public Estudiantes getEstudianteInvolucrado() {
        return estudianteInvolucrado;
    }

    public void setEstudianteInvolucrado(Estudiantes estudianteInvolucrado) {
        this.estudianteInvolucrado = estudianteInvolucrado;
    }

    public Cursos getCursoInvolucrado() {
        return cursoInvolucrado;
    }

    public void setCursoInvolucrado(Cursos cursoInvolucrado) {
        this.cursoInvolucrado = cursoInvolucrado;
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public Estudiantes getEstudiante() {
        return estudianteInvolucrado;
    }

    public Cursos getCurso() {
        return cursoInvolucrado;
    }

    public Double getCalificacionAnterior() {
        return calificacionAnterior;
    }

    public Double getCalificacionNueva() {
        return calificacionNueva;
    }

    public int getPosicionCalificacion() {
        return posicionCalificacion;
    }
}
