/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Camila Zubía
 * @param <T> tipo generico del elemento almacenado en la lista enlaada circular
 */
public class ListaEnlazadaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamaño;
    /**
     * clase generica del nodo de la lista enlazada
     * @param <T> tipo generico del nodo
     */
    private static class Nodo<T> {

        private T dato;
        private Nodo<T> sig;

        public Nodo(T dato) {
            this.dato = dato;
        }
    }
    
    /**
     * agregar un nodo en la lista
     * @param dato valor del nodo
     */
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            nuevo.sig = inicio;
        } else {
            fin.sig= nuevo;
            fin = nuevo;
            fin.sig = inicio;
        }
        tamaño++;
    }
    /**
     * elimina el primer nodo de la lista
     */
    public void eliminarPrimero() {
        if (inicio == null) {
            return;
        }

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.sig;
            fin.sig = inicio;
        }
        tamaño--;
    }
}
