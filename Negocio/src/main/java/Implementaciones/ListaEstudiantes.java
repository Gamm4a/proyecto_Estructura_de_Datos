/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * implementacion de una lista enlazada de tipo Estudiante
 * @author Camila Zubía
 * @param <T> tipo generico de elemento almacenado en una lista
 */
public class ListaEstudiantes<T> {

    private Nodo<T> p;
    private int tamaño;

    /**
     * clase generica de un nodo de lista enlazada simple.
     * @param <T> ipo generico de elemento almacenado en un nodo
     */
    public static class Nodo<T> {

        private T dato;
        Nodo<T> sig;
        /**
         * constructor que crea un nodo
         * @param dato dato
         */
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
     */
    public ListaEstudiantes() {
        this.p = null;
        this.tamaño = 0;
    }
    
    /**
     * agregar un nodo al final de la lista 
     * 
     * @param dato valor del nodo
     */
    public void agregarUltimo(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (p == null) {
            p = nuevo;
        } else {
            Nodo<T> actual = p;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = nuevo;
        }
        tamaño++;
    }

    /**
    * eliminar un nodo de la lista 
     * @param dato
    */
    public void eliminar(T dato) {
        if (p == null) {
            return;
        }else if (p.getDato().equals(dato)) {
            p = p.getSig();
            tamaño--;
            return;
        }

        Nodo<T> actual = p;
        Nodo<T> anterior = null;

        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSig();
        }

        if (actual != null) {
            anterior.setSig(actual.getSig());
            tamaño--;
        }
    }
    
    /**
     * imprime los nodos de la lista
     * @return 
     */
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = p;
        while (actual != null) {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.sig;
        }
        sb.append("null");
        return sb.toString();
    }
    
    /**
     * regrese el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getTamaño() {
        return tamaño;
    }
}
