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

/**
 *
 * @author Luis Rafael
 */
public class FInscripciones implements IInscripciones{

    private Diccionario<String, Cursos> cursos;
    private ArbolBinarioBusqueda<Estudiantes> estudiantes;

    @Override
    public void inscribirEstudianteEnCurso(String matricula, String clave) {
        Cursos cursoInscribir = cursos.get(clave);
        Estudiantes estudiante = estudiantes.buscarPorAtributo(e -> e.getMatricula(), matricula);
        if(cursoInscribir.getInscritos().getTamaño() >= Cursos.getMAX_INSCRITOS()){
            cursoInscribir.getListaEspera().agregar(estudiante);
        }
        cursoInscribir.getInscritos().agregarUltimo(estudiante);
        cursoInscribir.getRolEstudiantes().agregar(estudiante);
    }

    @Override
    public void eliminarEstudianteDeCurso(String matricula, String clave) {
        Cursos cursoEliminar = cursos.get(clave);
        Estudiantes estudiante = estudiantes.buscarPorAtributo(e -> e.getMatricula(), matricula);
        cursoEliminar.getInscritos().eliminar(estudiante);
        if (!cursoEliminar.getListaEspera().estaVacia()) {
            Estudiantes est = cursoEliminar.getListaEspera().getInicio().getDato();
            cursoEliminar.getInscritos().agregarUltimo(est);
        }
    }

    @Override
    public void mostrarInscritos(String clave) {
        Cursos cursoMostrar = cursos.get(clave);
        cursoMostrar.getInscritos().imprimir();
    }
    
    @Override
    public void mostrarListaEspera(String clave, int cantidad) {
        Cursos cursoMostrarEspera = cursos.get(clave);
        cursoMostrarEspera.getListaEspera().imprimirCant(cantidad);
    }

    @Override
    public void recorrerListaEsperaAdelante(String clave) {
        Cursos cursoMostrarEspera = cursos.get(clave);
        cursoMostrarEspera.getListaEspera().imprimir();
    }

    @Override
    public void recorrerListaEsperaAtras(String clave) {
        Cursos cursoMostrarEspera = cursos.get(clave);
        cursoMostrarEspera.getListaEspera().imprimirReversa();
    }
}
