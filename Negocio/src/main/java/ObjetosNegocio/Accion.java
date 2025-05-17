/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

/**
 *
 * @author Camila Zubía
 */
public class Accion {

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

    public Accion(Tipo tipo, Estudiantes estudiante, Cursos curso,
            Double calificacionAnterior, Double calificacionNueva, int posicion) {
        this.tipo = tipo;
        this.estudianteInvolucrado = estudiante;
        this.cursoInvolucrado = curso;
        this.calificacionAnterior = calificacionAnterior;
        this.calificacionNueva = calificacionNueva;
        this.posicionCalificacion = posicion;
    }

    public Estudiantes getEstudianteInvolucrado() {
        return estudianteInvolucrado;
    }

    public void setEstudianteInvolucrado(Estudiantes estudianteInvolucrado) {
        this.estudianteInvolucrado = estudianteInvolucrado;
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
