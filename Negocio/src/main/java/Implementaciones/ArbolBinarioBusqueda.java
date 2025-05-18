/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 *
 * @author Camila Zubía
 * @param <T> Tipo genérico del elemento que se almacenará en el arbol binario de busqueda
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> {
    
    /**
     * Clase interna que representa un nodo dentro del árbol.
     * @param <T> Tipo genérico del elemento que se almacenará en los nodos
     */
    public static class Nodo<T>{
        public T dato;
        public Nodo<T> izq, der;
        public int altura;
        
        /**
         * Crea un nuevo nodo con el dato dado e inicializa sus hijos como null y su altura como 1.
         * @param dato valor almacenado en el nodo.
         */
        public Nodo(T dato) {
            this.dato = dato;
            this.izq = null;
            this.der = null;
            this.altura = 1;
        }
    }
    
    /**
     * Raíz del árbol binario de búsqueda.
     */
    public Nodo<T> raiz;
    
    /**
     * Inserta un nuevo valor en el árbol respetando las reglas de orden de un ABB.
     * @param dato el valor a insertar.
     */
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }
    
    /**
     * Inserta recursivamente un nuevo nodo en el lugar correspondiente del subárbol.
     * @param nodo nodo actual del subárbol.
     * @param dato dato a insertar.
     * @return Nodo actualizado con el nuevo dato insertado.
     */
    private Nodo<T> insertar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }
        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izq = insertar(nodo.izq, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.der = insertar(nodo.der, dato);
        }
        return nodo;
    }
    
    /**
     * Sirve como base para ser sobrescrito en subclases
     * @param dato 
     */
    public void eliminar(T dato){
        raiz = eliminar(raiz, dato);
    }
    
    /**
     * Se planea que este método implemente la lógica de eliminación, devolviendo el árbol actualizado tras eliminar un nodo.
     * @param nodo nodo actual del subárbol.
     * @param dato dato a insertar.
     * @return 
     */
    private Nodo<T> eliminar(Nodo<T> nodo, T dato){   
        return null;   
    }
    
    /**
     * Busca un elemento dentro del árbol.Si el elemento no existe, lanza una excepción.
     * @param extractor
     * @param valorBuscado
     * @return El elemento encontrado.
     */
    public T buscarPorAtributo(Function<T, Comparable> extractor, Comparable valorBuscado) {
        return buscarPorAtributo(raiz, extractor, valorBuscado);
    }
    
    /**
     * Búsqueda recursiva del dato en el subárbol.
     * @param nodo nodo actual en la búsqued
     * @param dato valor a buscar.
     * @return Dato encontrado si existe.
     */
    private T buscarPorAtributo(Nodo<T> nodo, Function<T, Comparable> extractor, Comparable valorBuscado) {
        if (nodo == null) {
            throw new NoSuchElementException("Atributo no encontrado en el árbol.");
        }

        Comparable valorNodo = extractor.apply(nodo.dato);
        int cmp = valorBuscado.compareTo(valorNodo);

        if (cmp == 0) {
            return nodo.dato;
        } else if (cmp < 0) {
            return buscarPorAtributo(nodo.izq, extractor, valorBuscado);
        } else {
            return buscarPorAtributo(nodo.der, extractor, valorBuscado);
        }
    }   
}
