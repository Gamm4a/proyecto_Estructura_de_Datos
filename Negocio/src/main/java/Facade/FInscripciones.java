/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Interfaz.IInscripciones;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Estudiantes;
import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.Diccionario;
import ObjetosNegocio.Accion;


/**
 * clase fachada de IInscripciones
 * 
 * @author Luis Rafael
 */
public class FInscripciones implements IInscripciones {

    private final Diccionario<String, Cursos> cursos;
    private final ArbolBinarioBusqueda<Estudiantes> estudiantes;
    
    /**
     * constructor que crea la fachada de la inscripcion
     * 
     * @param cursos cursos involucrados
     * @param estudiantes estudiantes involucrados
     */
    public FInscripciones(Diccionario<String, Cursos> cursos, ArbolBinarioBusqueda<Estudiantes> estudiantes) {
        this.cursos = cursos;
        this.estudiantes = estudiantes;
    }
    
    /**
     * metodo para incribir a un estudiante a un curso
     * 
     * @param matricula matricula del estudiante
     * @param clave clave del curso
     */
    @Override
    public void inscribirEstudianteEnCurso(String matricula, String clave) {
        Cursos curso = cursos.get(clave);
        Estudiantes estudiante = estudiantes.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (curso == null || estudiante == null) {
            System.out.println("Curso o estudiante no encontrado.");
            return;
        }

        if (curso.getInscritos().getTamaño() >= Cursos.getMAX_INSCRITOS()) {
            curso.getListaEspera().agregar(estudiante);
            System.out.println("Curso lleno. Estudiante agregado a la lista de espera.");
        } else {
            curso.getInscritos().agregarUltimo(estudiante);
            curso.getRolEstudiantes().agregar(estudiante);
            System.out.println("Estudiante inscrito correctamente.");
        }

        Accion accion = new Accion(Accion.Tipo.INSCRIPCION, estudiante, curso, null, null, -1);
        FDeshacer.registrarAccion(accion);
    }
    
    /**
     * metodo para eliminar el estudiante de un curso
     * 
     * @param matricula matricula del estudiante
     * @param clave clave del cursos
     */
    @Override
    public void eliminarEstudianteDeCurso(String matricula, String clave) {
        Cursos curso = cursos.get(clave);
        Estudiantes estudiante = estudiantes.buscarPorAtributo(e -> e.getMatricula(), matricula);


        if (curso == null || estudiante == null) {
            System.out.println("Curso o estudiante no encontrado.");
            return;
        }

        curso.getInscritos().eliminar(estudiante);
        curso.getRolEstudiantes().eliminar(estudiante);

        if (!curso.getListaEspera().estaVacia()) {
            Estudiantes siguiente = curso.getListaEspera().getInicio().getDato();
            curso.getInscritos().agregarUltimo(siguiente);
            curso.getListaEspera().eliminarPrimero();
        }

        Accion accion = new Accion(Accion.Tipo.BAJA_ESTUDIANTE, estudiante, curso, null, null, -1);
        FDeshacer.registrarAccion(accion);

        System.out.println("Estudiante eliminado del curso.");
    }
    
    /**
     * metodo para mostrar alumnos incritos
     * 
     * @param clave 
     * @return  
     */
    @Override
    public String mostrarInscritos(String clave) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            return curso.getInscritos().imprimir();
        } else {
            System.out.println("Curso no encontrado.");
            return null;
        }
    }
    
    /**
     * metodo para mostrarla Lista de Espera
     * 
     * @param clave clave del curso
     * @param cantidad cantidad a imprimir
     * @return 
     */
    @Override
    public String mostrarListaEspera(String clave, int cantidad) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            return curso.getListaEspera().imprimirCant(cantidad);
        } else {
            System.out.println("Curso no encontrado.");
            return null;
        }
    }
    
    /**
     * metodo para recorre la lista de espera hacia delante
     * 
     * @param clave clave del curso
     * @return 
     */
    @Override
    public String recorrerListaEsperaAdelante(String clave) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            return curso.getListaEspera().imprimir();
        } else {
            System.out.println("Curso no encontrado.");
            return null;
        }
    }
    
    /**
     * metodo para recorre la lista de espera hacia delante
     *
     * @param clave
     * @return   * @param clave clave del curso
     */
    @Override
    public String recorrerListaEsperaAtras(String clave) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            return curso.getListaEspera().imprimirReversa();
        } else {
            System.out.println("Curso no encontrado.");
            return null;
        }
    }
}
