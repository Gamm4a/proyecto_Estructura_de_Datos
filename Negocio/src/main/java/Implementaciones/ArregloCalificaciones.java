/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * clase de implementacion de un arreglo dinamico de calificaciones
 * 
 * @author Camila Zubía
 * @param <T> Tipo genérico del elemento que se almacenará en el arreglo.
 */
public class ArregloCalificaciones<T> {
    private int tam;
    private T[] arreglo;

    /**
     * Crea una nueva instancia de ArregloCalificaciones con una capacidad inicial especificada.
     * @param tamInicial capacidad inicial del arreglo.
     */
    public ArregloCalificaciones(int tamInicial) {
        this.tam = 0;
        this.arreglo = (T[]) new Object[tamInicial];
    }
    
    /**
     * Devuelve la cantidad de elementos almacenados actualmente en el arreglo.
     * @return Número de elementos presentes.
     */
    public int getTam() {
        return tam;
    }
    
    /**
     * Agrega un nuevo elemento al arreglo. Si el arreglo ha alcanzado su capacidad máxima, se redimensiona al doble de su tamaño actual.
     * @param elemento elemento que se desea agregar.
     */
    public void agregarElemento(T elemento) {
        if (arreglo.length == tam) {
            T[] nuevoArreglo = (T[]) new Object[arreglo.length * 2];
            for (int i = 0; i < arreglo.length; i++) {
                nuevoArreglo[i] = arreglo[i];
            }
            arreglo = nuevoArreglo;
        }
        arreglo[tam] = elemento;
        tam++;
    }
    
    /**
     * Elimina el elemento en la posición especificada. Desplaza los elementos posteriores hacia la izquierda.
     * @param pos posición del elemento a eliminar.
     */
    public void eliminarElemento(int pos) {
        if (pos < 0 || pos >= tam) {
            System.out.println("posicion no existe");
            return;
        }
        for (int i = pos; i < tam - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
        arreglo[tam - 1] = null;
        tam--;
    }
    
    /**
     * Busca el primer elemento igual al valor especificado y lo reemplaza por un nuevo valor.
     * @param elemento elemento existente que se desea modificar.
     * @param nuevo nuevo valor a asignar.
     * @return modificacion de un elemento
     */
    public boolean modificarElemento(T elemento, T nuevo) {
        for (int i = 0; i < getTam(); i++) {
            T actual = obtenerElemento(i);
            if (actual != null && actual.equals(elemento)) {
                arreglo[i] = nuevo;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Devuelve el elemento almacenado en la posición indicada.
     * @param index índice del elemento a obtener.
     * @return Elemento en la posición indicada.
     */
    public T obtenerElemento(int index) {
        if (index < 0 || index >= tam) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return arreglo[index];
    }

    /**
     * Imprime en consola todos los elementos almacenados actualmente en el arregl
     */
    public void imprimir() {
        for (int i = 0; i < tam; i++) {
            System.out.println(arreglo[i]);
        }
    }
}
