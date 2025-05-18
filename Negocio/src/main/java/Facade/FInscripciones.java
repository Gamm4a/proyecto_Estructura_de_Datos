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
import static ObjetosNegocio.Accion.Tipo.*;

/**
 *
 * @author Luis Rafael
 */
public class FInscripciones implements IInscripciones {

    private Diccionario<String, Cursos> cursos;
    private ArbolBinarioBusqueda<Estudiantes> estudiantes;

    public FInscripciones(Diccionario<String, Cursos> cursos, ArbolBinarioBusqueda<Estudiantes> estudiantes) {
        this.cursos = cursos;
        this.estudiantes = estudiantes;
    }

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

        Accion accion = new Accion(Accion.Tipo.INSCRIPCION, estudiante, curso, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }

    @Override
    public void eliminarEstudianteDeCurso(String matricula, String clave) {
        Cursos curso = cursos.get(clave);
        Estudiantes estudiante = estudiantes.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (curso == null || estudiante == null) {
            System.out.println("Curso o estudiante no encontrado.");
            return;
        }

        curso.getInscritos().eliminar(estudiante);

        if (!curso.getListaEspera().estaVacia()) {
            Estudiantes siguiente = curso.getListaEspera().getInicio().getDato();
            curso.getInscritos().agregarUltimo(siguiente);
            curso.getListaEspera().eliminarPrimero();
        }

        Accion accion = new Accion(Accion.Tipo.BAJA_ESTUDIANTE, estudiante, curso, null, null, 0);
        FDeshacer.registrarAccion(accion);

        System.out.println("Estudiante eliminado del curso.");
    }

    @Override
    public void mostrarInscritos(String clave) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            curso.getInscritos().imprimir();
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    @Override
    public void mostrarListaEspera(String clave, int cantidad) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            curso.getListaEspera().imprimirCant(cantidad);
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    @Override
    public void recorrerListaEsperaAdelante(String clave) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            curso.getListaEspera().imprimir();
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    @Override
    public void recorrerListaEsperaAtras(String clave) {
        Cursos curso = cursos.get(clave);
        if (curso != null) {
            curso.getListaEspera().imprimirReversa();
        } else {
            System.out.println("Curso no encontrado.");
        }
    }
}
