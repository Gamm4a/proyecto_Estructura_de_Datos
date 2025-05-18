/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.Diccionario;
import Implementaciones.ListaEnlazada;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Estudiantes;

/**
 *
 * @author Camila Zubía
 */
public class FSistema {

    public ArbolBinarioBusqueda<Estudiantes> estudiantes = new ArbolBinarioBusqueda<>();

    private final ListaEnlazada<Diccionario.Entrada<String, Cursos>>[] tablaHash
            = (ListaEnlazada<Diccionario.Entrada<String, Cursos>>[]) new ListaEnlazada[10];

    public Diccionario<String, Cursos> diccionarioCursos = new Diccionario<>(tablaHash, 10);

    private FEstudiantes fEstudiantes;
    private FCursos fCursos;
    private FInscripciones fInscripciones;
    private FCalificaciones fCalificaciones;
    private FReportes fReportes;
    private FDeshacer fDeshacer;

    public FSistema() {
        fEstudiantes = new FEstudiantes(estudiantes);
        fCursos = new FCursos(diccionarioCursos);
        fInscripciones = new FInscripciones(diccionarioCursos, estudiantes);
        fCalificaciones = new FCalificaciones(estudiantes);
        fReportes = new FReportes(diccionarioCursos, estudiantes, fCalificaciones);
        fDeshacer = new FDeshacer(diccionarioCursos, estudiantes);
    }

    public FEstudiantes getFEstudiantes() {
        return fEstudiantes;
    }

    public FCursos getFCursos() {
        return fCursos;
    }

    public FInscripciones getFInscripciones() {
        return fInscripciones;
    }

    public FCalificaciones getFCalificaciones() {
        return fCalificaciones;
    }

    public FReportes getFReportes() {
        return fReportes;
    }

    public FDeshacer getfDeshacer() {
        return fDeshacer;
    }
}
