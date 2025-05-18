/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Camila Zubía
 * @param <T> Tipo de dato almacenado en el nodo.
 */
public class ListaEnlazada<T> {

    private NodoSimple<T> p;

    /**
     * Constructor por defecto. Inicializa una lista vacía.
     */
    public ListaEnlazada(){
        
    }

    /**
     * Clase interna que representa un nodo simple de la lista. 
     * dato: un valor almacenado
     * sig: referencia al siguiente nodo
     *
     * @param <T> Tipo de dato almacenado en el nodo.
     */
    public class NodoSimple<T> {

        private T dato;
        private NodoSimple<T> sig;

        public NodoSimple(T dato) {
            this.dato = dato;
            this.sig = null;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public NodoSimple<T> getSig() {
            return sig;
        }

        public void setSig(NodoSimple<T> sig) {
            this.sig = sig;
        }
    }

    /**
     * Establece un nuevo dato en la posición especificada. Si el índice es
     * inválido o excede el tamaño de la lista, no se realiza ninguna
     * modificación.
     *
     * @param o El nuevo dato a establecer.
     * @param i El índice de la posición donde se colocará el dato.
     */
    public void set(T o, int i) {
        if (i < 0) {
            return;
        }

        NodoSimple<T> nodo = p;
        for (int j = 0; j < i; j++) {
            if (nodo == null) {
                return;
            }
            nodo = nodo.getSig();
        }
        if (nodo != null) {
            nodo.setDato(o);
        }
    }

    /**
     * Obtiene el dato almacenado en la posición especificada.
     *
     * @param i Índice del elemento a obtener.
     * @return El dato en la posición indicada, nulo si es invalido.
     */
    public T get(int i) {
        if (i < 0) {
            return null;
        }

        NodoSimple<T> nodo = p;
        for (int j = 0; j < i; j++) {
            if (nodo == null) {
                return null;
            }
            nodo = nodo.getSig();
        }
        return nodo != null ? nodo.getDato() : null;
    }

    /**
     * Agrega un nuevo elemento a la lista.
     * @param o elemento que se va a agregar.
     */
    public void add(T o) {
        NodoSimple<T> nuevo = new NodoSimple<>(o);
        if (p == null) {
            p = nuevo;
        } else {
            NodoSimple<T> actual = p;
            while (actual.getSig() != null) {
                actual = actual.getSig();
            }
            actual.setSig(nuevo);
        }
    }

    /**
     * Remueve un elemento de la lista dependiendo de su posicion.
     * @param i posicion del elemento que se quiere agregar.
     */
    public void remove(int i) {
        if (i < 0 || p == null) {
            return;
        }

        if (i == 0) {
            p = p.getSig();
            return;
        }

        NodoSimple<T> anterior = p;
        for (int j = 0; j < i - 1; j++) {
            if (anterior.getSig() == null) {
                return; // índice fuera de rango
            }
            anterior = anterior.getSig();
        }

        NodoSimple<T> nodoAEliminar = anterior.getSig();
        if (nodoAEliminar != null) {
            anterior.setSig(nodoAEliminar.getSig());
        }
    }

    /**
     * Remueve un elemento de la lista, la primera aparicion.
     * @param o elemento a eliminar.
     * @return 
     */
    public boolean remove(T o) {
        if (p == null) {
            return false;
        }

        if (o.equals(p.getDato())) {
            p = p.getSig();
            return true;
        }

        NodoSimple<T> actual = p;
        while (actual.getSig() != null) {
            if (o.equals(actual.getSig().getDato())) {
                actual.setSig(actual.getSig().getSig());
                return true;
            }
            actual = actual.getSig();
        }
        return false;
    }

    /**
     * Regresa el indice de un elemento.
     * @param o elemento del cual se busca el indice.
     * @return 
     */
    public int indexOf(T o) {
        NodoSimple<T> actual = p;
        int index = 0;
        while (actual != null) {
            if (o.equals(actual.getDato())) {
                return index;
            }
            actual = actual.getSig();
            index++;
        }
        return -1;
    }

    /**
     * Vacia la lista.
     */
    public void clear() {
        p = null;
    }

    /**
     * Regresa el tamaño de la lista.
     * @return 
     */
    public int size() {
        int count = 0;
        NodoSimple<T> actual = p;
        while (actual != null) {
            count++;
            actual = actual.getSig();
        }
        return count;
    }

    /**
     * imprime los valores de la lista.
     */
    public void imprimir() {
        NodoSimple<T> actual = p;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.sig;
        }
        System.out.println("null");
    }
}
