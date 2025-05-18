/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
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
     * dato: el valor almacenado.
     * sig: referencia al siguiente nodo.
     * ant: referencia al nodo anterior.
     * @param <T> tipo generico del nodo
     */
    public static class Nodo<T> {

        private T dato;
        private Nodo<T> sig;
        private Nodo<T> ant;

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
     * @return 
     */
    public Nodo<T> getInicio() {
        return inicio;
    }
    
    /**
     * Agrega un nuevo nodo al final de la lista.
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
     * Imprime todos los elementos de la lista en orden desde el inicio. Si la
     * lista está vacía, se indica con un mensaje.
     */
    public void imprimir() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = inicio;
        do {
            System.out.println(actual.dato);
            actual = actual.sig;
        } while (actual != inicio);
    }

    /**
     * Imprime todos los elementos de la lista en orden inverso desde el inicio.
     * Si la lista está vacía, se indica con un mensaje.
     */
    public void imprimirReversa() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = inicio;
        do {
            System.out.println(actual.dato);
            actual = actual.ant;
        } while (actual != inicio);
    }

    /**
     * Imprime una cantidad específica de elementos comenzando desde el inicio.
     * Si la lista está vacía o la cantidad es inválida, se muestra un mensaje.
     *
     * @param cantidad Número de elementos a imprimir.
     */
    public void imprimirCant(int cantidad) {
        if (inicio == null || cantidad <= 0) {
            System.out.println("Lista vacía o cantidad inválida.");
            return;
        }

        Nodo<T> actual = inicio;
        int contador = 0;

        do {
            System.out.println(actual.dato);
            actual = actual.sig;
            contador++;
        } while (contador < cantidad && actual != inicio);
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
     * @return
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }
}
