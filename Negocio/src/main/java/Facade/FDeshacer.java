/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.Diccionario;
import Implementaciones.Pila;
import Interfaz.IDeshacer;
import ObjetosNegocio.Accion;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Estudiantes;


/**
 *
 * @author Luis Rafael
 */
public class FDeshacer implements IDeshacer{
    
    private Diccionario<String, Cursos> cursos;
    private ArbolBinarioBusqueda<Estudiantes> estudiantes;
    private static Pila<Accion> pila = new Pila<>();

    /**
     * contructor que crea una instancia de la clase con estructuras compartidas
     * @param cursos
     * @param estudiantes 
     */
    public FDeshacer(Diccionario<String, Cursos> cursos, ArbolBinarioBusqueda<Estudiantes> estudiantes) {
        this.cursos = cursos;
        this.estudiantes = estudiantes;
    }
    
    /**
     * metodo para registra una accion
     * @param accion accion
     */
    public static void registrarAccion(Accion accion) {
        pila.push(accion);
    }

    /**
     * metodo para deshacer una accion
     * @return 
     */
    @Override
    public void deshacerUltimaAccion() {
        if (pila.vacia()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        Accion accion = pila.pop();
        Estudiantes estudiante = accion.getEstudiante();
        Cursos curso = accion.getCurso();
        
        switch (accion.getTipo()) {

            case REGISTRO_ESTUDIANTE -> {
                estudiantes.eliminar(estudiante);
                System.out.println("Se deshizo el registro del estudiante: " + estudiante.getNombre());
            }

            case ELIMINAR_ESTUDIANTE -> {
                estudiantes.insertar(estudiante);
                System.out.println("Se restauró el estudiante eliminado: " + estudiante.getNombre());
            }

            case INSCRIPCION -> {
                if (curso != null) {
                    curso.getInscritos().eliminar(estudiante);
                    curso.getRolEstudiantes().eliminar(estudiante);
                    System.out.println("Se deshizo la inscripción del estudiante en el curso.");
                }
            }

            case BAJA_ESTUDIANTE -> {
                if (curso != null) {
                    curso.getInscritos().agregarUltimo(estudiante);
                    System.out.println("Se revirtió la baja del estudiante en el curso.");
                }
            }

            case CALIFICACION_AGREGADA -> {
                if (estudiante != null && accion.getPosicionCalificacion() >= 0) {
                    estudiante.getCalificaciones().eliminarElemento(accion.getPosicionCalificacion());
                    System.out.println("Se deshizo la calificación agregada.");
                }
            }

            case CALIFICACION_MODIFICADA -> {
                if (estudiante != null && accion.getPosicionCalificacion() >= 0) {
                    estudiante.getCalificaciones().modificarElemento(
                            accion.getCalificacionNueva(),
                            accion.getCalificacionAnterior()
                    );
                    System.out.println("Se deshizo la modificación de calificación.");
                }
            }

            case AGREGAR_CURSO -> {
                cursos.remove(accion.getCurso().getClave());
                System.out.println("Se deshizo la creación del curso: " + accion.getCurso().getNombre());
            }

            case ELIMINAR_CURSO -> {
                cursos.put(accion.getCurso().getClave(), accion.getCurso());
                System.out.println("Se restauró el curso eliminado: " + accion.getCurso().getNombre());
            }

            default -> System.out.println("Acción no reconocida.");
        }
    }
}
