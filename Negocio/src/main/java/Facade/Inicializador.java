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
 * clase que inizializa las estructuras
 * @author Camila Zubía
 */
public class Inicializador {

    public ArbolBinarioBusqueda<Estudiantes> estudiantes;

    public Diccionario<String, Cursos> diccionarioCursos;

    private FEstudiantes fEstudiantes;
    private FCursos fCursos;
    private FInscripciones fInscripciones;
    private FCalificaciones fCalificaciones;
    private FReportes fReportes;
    private FDeshacer fDeshacer;
    
    /**
     * constructor que crea el inicializador
     */
    public Inicializador() {
        estudiantes = new ArbolBinarioBusqueda<>();
        
        ListaEnlazada<Diccionario.Entrada<String, Cursos>>[] tablaHash
            = (ListaEnlazada<Diccionario.Entrada<String, Cursos>>[]) new ListaEnlazada[10];
        
        diccionarioCursos = new Diccionario<>(tablaHash, 10);
        
        fEstudiantes = new FEstudiantes(estudiantes);
        fCursos = new FCursos(diccionarioCursos);
        fInscripciones = new FInscripciones(diccionarioCursos, estudiantes);
        fCalificaciones = new FCalificaciones(estudiantes);
        fReportes = new FReportes(diccionarioCursos, estudiantes, fCalificaciones);
        fDeshacer = new FDeshacer(diccionarioCursos, estudiantes);
    }
    
    //gettes de las fachadas
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
