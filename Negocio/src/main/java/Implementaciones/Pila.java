/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * clase de implementacion de una pila
 * @author Camila Zubía
 * @param <T> tipo generico de elemento almacenado en una pila
 */
public class Pila<T> extends ListaEnlazada<T>{

    private NodoSimple<T> tope;

    public Pila() {
    }

    /**
     * Agrega un elemento al tope de la pila (inicio de la lista).
     * @param o
     */
    public void push(T o) {
        NodoSimple<T> nuevo = new NodoSimple<>(o);
        nuevo.setSig(tope);
        tope = nuevo;
    }

    /**
     * Elimina y devuelve el elemento en el tope de la pila.
     * @return 
     */
    public T pop() {
        if (tope == null) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = tope.getDato();
        tope = tope.getSig();
        return dato;
    }

    /**
     * Devuelve el valor del nodo al tope de la pila sin eliminarlo.
     * @return 
     */
    public T peek() {
        if (tope == null) {
            throw new IllegalStateException("La pila está vacía");
        }
        return tope.getDato();
    }

    /**
     * Indica si la pila está vacía.
     * @return 
     */
    public boolean vacia() {
        return tope == null;
    }

    @Override
    public String toString() {
        return "Pila{" + "tope=" + tope + '}';
    }
}
