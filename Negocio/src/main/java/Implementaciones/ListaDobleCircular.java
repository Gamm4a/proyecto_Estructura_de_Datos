/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * clase de implementacion de una lista doblemente enlazada circular
 * 
 * @author Camila Zubía
 * @param <T> Tipo genérico del elemento que se almacenará en una lista doblemente enlazada circular
 */
public class ListaDobleCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamaño;
    
    /**
     * Representa un nodo de la lista con:
     * 
     * dato: el valor almacenado.
     * sig: referencia al siguiente nodo.
     * ant: referencia al nodo anterior.
     * @param <T> tipo generico del nodo
     */
    public static class Nodo<T> {

        private T dato;
        private Nodo<T> sig;
        private Nodo<T> ant;
        
        //getters y setters 
        public Nodo(T dato) {
            this.dato = dato;
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

        public Nodo<T> getAnt() {
            return ant;
        }

        public void setAnt(Nodo<T> ant) {
            this.ant = ant;
        }
        
        
    }

    /**
     * regresa el primer nodo de la lista.
     * 
     * @return inicio
     */
    public Nodo<T> getInicio() {
        return inicio;
    }
    
    /**
     * Agrega un nuevo nodo al final de la lista.
     * 
     * @param dato valor que contiene el nodo
     */
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
        } else {
            nuevo.ant = fin;
            nuevo.sig = inicio;
            fin.sig = nuevo;
            inicio.ant = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }
    
    /**
     * elimina un nodo al final de la lista.
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
            inicio.ant = fin;
            fin.sig = inicio;
        }
        tamaño--;
    }

    /**
     * Imprime todos los elementos de la lista en orden desde el inicio.Si la
     * lista está vacía, se indica con un mensaje.
     * @return 
     */
    public String imprimir() {
        if (inicio == null) {
            return "La lista está vacía.";
        }

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = inicio;
        do {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.getSig();
        } while (actual != inicio);
        sb.append("(inicio)");

        return sb.toString();
    }

    /**
     * Imprime todos los elementos de la lista en orden inverso desde el inicio.
     * Si la lista está vacía, se indica con un mensaje.
     * @return
     */
    public String imprimirReversa() {
        if (inicio == null) {
            return "La lista está vacía.";
        }

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = fin;
        do {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.getAnt();
        } while (actual != fin);
        sb.append("(fin)");

        return sb.toString();
    }

    /**
     * Imprime una cantidad específica de elementos comenzando desde el inicio.
     * Si la lista está vacía o la cantidad es inválida, se muestra un mensaje.
     *
     * @param cantidad Número de elementos a imprimir.
     * @return 
     */
    public String imprimirCant(int cantidad) {
        if (inicio == null || cantidad <= 0) {
            return "Lista vacía o cantidad inválida.";
        }

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = inicio;
        int contador = 0;

        do {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.getSig();
            contador++;
        } while (contador < cantidad && actual != inicio);

        sb.append("...");

        return sb.toString();
    }

    /**
     * Devuelve el tamaño actual de la lista.
     *
     * @return El número de elementos en la lista.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Indica si la lista está vacía.
     *
     * @return esta vacia
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }
}
