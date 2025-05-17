/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import java.util.NoSuchElementException;

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
        T dato;
        Nodo<T> izq, der;
        int altura;
        
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
     * Busca un elemento dentro del árbol. Si el elemento no existe, lanza una excepción.
     * @param dato elemento a buscar.
     * @return El elemento encontrado.
     */
    public T buscar(T dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato a buscar no puede ser null.");
        }
        return buscar(raiz, dato);
    }
    
    /**
     * Búsqueda recursiva del dato en el subárbol.
     * @param nodo nodo actual en la búsqued
     * @param dato valor a buscar.
     * @return Dato encontrado si existe.
     */
    private T buscar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            throw new NoSuchElementException("Dato no encontrado en el árbol.");
        }

        int comparacion = dato.compareTo(nodo.dato);
        if (comparacion == 0) {
            return nodo.dato;
        } else if (comparacion < 0) {
            return buscar(nodo.izq, dato);
        } else {
            return buscar(nodo.der, dato);
        }
    }  
}
