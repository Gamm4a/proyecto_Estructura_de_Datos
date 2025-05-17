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
public class Cola<T> extends ListaEnlazada<T> {
    
    private NodoSimple<T> p;

    public Cola() {
    }
    
        /**
     * metodo que agrega un nodo al final de la cola
     *
     * @param o
     */
    public void enqueue(T o){
        NodoSimple<T> nuevo = new NodoSimple<>(o);
        if (p == null) {
            p = nuevo;
            return;
        }
        NodoSimple<T> a = p;
        while (a.getSig() != null) {
            a = a.getSig();
        }
        a.setSig(nuevo);
    }

    /**
     * metodo que remueve el primer nodo de la cola y te regresa su valor
     *
     * @return
     */
    public T dequeue(){
        if (p == null) {
            throw new IllegalStateException("La cola está vacía");
        }
        NodoSimple<T> a = p;
        p = p.getSig();
        return a.getDato();
    }

    /**
     * metodo que regresa el primer valor de la cola
     *
     * @return
     */
    public T peek() {
        if (p == null) {
            throw new IllegalStateException("La cola está vacía");
        }
        return p.getDato();
    }

    /**
     * metodo que te indica si la cola esta vacia o no
     *
     * @return
     */
    public boolean vacia() {
        return p == null;
    }
}
