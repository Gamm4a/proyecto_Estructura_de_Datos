/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Camila Zubía
 * @param <T> Tipo genérico del elemento que se almacenará en el arbolAVL
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {
    
    /**
     * Elimina un nodo con el valor especificado del árbol. Luego de la eliminación, se actualizan las alturas y se balancea el árbol si es necesario.
     * @param dato el valor a eliminar.
     */
    public void eliminar(T dato) {
        raiz = eliminar(raiz, dato);
    }
    
    /**
     * Método recursivo que elimina el nodo con el valor especificado, actualiza la altura y rebalancea el árbol.
     * @param nodon raíz actual del subárbol.
     * @param dato valor a eliminar.
     * @return Nodo actualizado tras eliminación y balanceo.
     */
    private Nodo<T> eliminar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dato.compareTo(nodo.dato);
        if (comparacion < 0) {
            nodo.izq = eliminar(nodo.izq, dato);
        } else if (comparacion > 0) {
            nodo.der = eliminar(nodo.der, dato);
        } else {
            if (nodo.izq == null || nodo.der == null) {
                nodo = (nodo.izq != null) ? nodo.izq : nodo.der;
            } else {
                Nodo<T> sucesor = findMin(nodo.der);
                nodo.dato = sucesor.dato;
                nodo.der = eliminar(nodo.der, sucesor.dato);
            }
        }

        if (nodo == null) {
            return null;
        }

        actualizarAltura(nodo);
        return balancear(nodo);
    }
    
    /**
     * Encuentra el nodo con el valor mínimo dentro del subárbol.
     * @param nodo raíz del subárbol.
     * @return Nodo con el menor valor (más a la izquierda).
     */
    private Nodo<T> findMin(Nodo<T> nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }
    
    /**
     * Actualiza la altura del nodo en función de las alturas de sus hijos.
     * @param nodo nodo al que se desea actualizar la altura.
     */
    private void actualizarAltura(Nodo<T> nodo) {
        int alturaIzq = (nodo.izq != null) ? nodo.izq.altura : 0;
        int alturaDer = (nodo.der != null) ? nodo.der.altura : 0;
        nodo.altura = 1 + Math.max(alturaIzq, alturaDer);
    }
    
    /**
     * Calcula el factor de balanceo del nodo, es decir, la diferencia de alturas entre subárbol izquierdo y derecho.
     * @param nodo para el cual se calcula el factor.
     * @return Entero que representa el balance del nod
     */
    private int getBalanceFactor(Nodo<T> nodo) {
        int alturaIzq = (nodo.izq != null) ? nodo.izq.altura : 0;
        int alturaDer = (nodo.der != null) ? nodo.der.altura : 0;
        return alturaIzq - alturaDer;
    }
    
    /**
     * Aplica rotaciones necesarias para balancear el nodo si el factor de balance es mayor que 1 o menor que -1.
     * @param nodo nodo a balancear.
     * @return Nodo balanceado.
     */
    private Nodo<T> balancear(Nodo<T> nodo) {
        int balance = getBalanceFactor(nodo);

        if (balance > 1 && getBalanceFactor(nodo.izq) < 0) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }

        if (balance > 1) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && getBalanceFactor(nodo.der) > 0) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        if (balance < -1) {
            return rotarIzquierda(nodo);
        }

        return nodo;
    }
    
    /**
     * Realiza una rotación simple a la derecha para balancear el subárbol desbalanceado a la izquierda.
     * @param y raíz del subárbol desbalanceado.
     * @return Nueva raíz tras la rotación.
     */
    private Nodo<T> rotarDerecha(Nodo<T> y) {
        Nodo<T> x = y.izq;
        Nodo<T> T2 = x.der;

        x.der = y;
        y.izq = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }
    
    /**
     * Realiza una rotación simple a la izquierda para balancear el subárbol desbalanceado a la derecha.
     * @param x raíz del subárbol desbalanceado.
     * @return Nueva raíz tras la rotación.
     */
    private Nodo<T> rotarIzquierda(Nodo<T> x) {
        Nodo<T> y = x.der;
        Nodo<T> T2 = y.izq;

        y.izq = x;
        x.der = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }
}
