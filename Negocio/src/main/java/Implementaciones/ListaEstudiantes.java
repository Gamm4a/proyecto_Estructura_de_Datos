/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Camila Zubía
 * @param <T> tipo generico de elemento almacenado en una lista
 */
public class ListaEstudiantes<T> {

    private Nodo<T> p;
    private int tamaño;

    private static class Nodo<T> {

        private T dato;
        Nodo<T> sig;

        public Nodo(T dato) {
            this.dato = dato;
            this.sig = null;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public Nodo<T> getSig() {
            return sig;
        }

        public void setSig(Nodo<T> sig) {
            this.sig = sig;
        }
    }
    
    /**
     * crea el inicio de la lista
     * @param dato valor del nodo
     */
    public ListaEstudiantes(T dato) {
        this.p = new Nodo<>(dato);
        this.tamaño = 1;
    }
    
    /**
     * agregar un nodo al final de la lista 
     * @param dato valor del nodo
     */
    public void agregarUltimo(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = p;
        while (actual.sig != null) {
            actual = actual.sig;
        }
        actual.sig = nuevo;
        tamaño++;
    }
    /**
     * imprime los nodos de la lista
     */
    public void imprimir() {
        Nodo<T> actual = p;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.sig;
        }
        System.out.println("null");
    }
    
    /**
     * regrese el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getTamaño() {
        return tamaño;
    }
}
