/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Camila Zubía
 * @param <T>
 */
public class ListaEnlazada<T> {

    private NodoSimple<T> p;
    
    public ListaEnlazada(){
        
    }

    public ListaEnlazada(T dato) {
        this.p = new NodoSimple<>(dato);
    }

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

    public void clear() {
        p = null;
    }

    public int size() {
        int count = 0;
        NodoSimple<T> actual = p;
        while (actual != null) {
            count++;
            actual = actual.getSig();
        }
        return count;
    }
}
