/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import java.util.LinkedList;

/**
 *
 * @author Camila Zubía
 * @param <K> llave de la entrada
 * @param <V> valor de la entrada
 */
public class Diccionario<K, V> {
    /**
     * Representa un par clave-valor dentro del diccionario.
     * @param <K> clave de la entrada (final). 
     * @param <V> valor asociado.
     */
    public class Entrada<K, V> {

        private final K llave;
        private V valor;

        public Entrada(K llave, V valor) {
            this.llave = llave;
            this.valor = valor;
        }
        
        @Override
        public String toString() {
            return llave + ": " + valor;
        }
    }

    private final LinkedList<Entrada<K, V>> tablaHash[];
    private int nEntradas;
    private final int tamTablaHash;

    /**
     * Inicializa el diccionario con una tabla hash externa y un tamaño dado.
     * @param tablaHash arreglo de listas enlazadas.
     * @param tamTablaHash tamaño de la tabla hash.
     */
    public Diccionario(LinkedList<Entrada<K, V>>[] tablaHash, int tamTablaHash) {
        this.tablaHash = tablaHash;
        this.tamTablaHash = tamTablaHash;
    }
    
    /**
     * Calcula el índice hash correspondiente para una clave.
     * @param llave llave de la entrada
     * @return clave
     */
    private int getIndexHashTable(K llave) {
        return Math.abs(llave.hashCode()) % tamTablaHash;
    }
    
    /**
     * Devuelve el valor asociado a una clave si existe.
     * @param llave llave de la entrada
     * @return entrada
     */
    public V get(K llave) {
        int indice = getIndexHashTable(llave);
        LinkedList<Entrada<K, V>> balde = tablaHash[indice];
        if (balde == null) {
            return null;
        }
        return get(balde, llave, 0);
    }
    
    /**
     * 
     * @param balde balde de la entrada
     * @param llave llave de la entrada
     * @param i tamaño
     * @return nuevo valor
     */
    private V get(LinkedList<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            return entrada.valor;
        }
        return get(balde, llave, i + 1);
    }
    
    /**
     * Verifica si la clave existe en el diccionario
     * @param llave llave de la entrada
     * @return existencia de el diccionario
     */
    public boolean contains(K llave) {
        int indice = getIndexHashTable(llave);
        LinkedList<Entrada<K, V>> balde = tablaHash[indice];
        if (balde == null) {
            return false;
        }
        return contains(balde, llave, 0);
    }

    private boolean contains(LinkedList<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return false;
        }
        if (balde.get(i).llave.equals(llave)) {
            return true;
        }
        return contains(balde, llave, i + 1);
    }
    
    /**
     * Elimina todas las entradas del diccionario y libera memoria.
     */
    public void clear() {
        clear(0);
        nEntradas = 0;
    }
    
    
    private void clear(int i) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            tablaHash[i].clear();
            tablaHash[i] = null;
        }
        clear(i + 1);
    }
    
    /**
     * Devuelve una lista con todas las claves almacenadas.
     * @return lista de claves almacenadas
     */
    public LinkedList<K> keys() {
        LinkedList<K> resultado = new LinkedList<>();
        keys(0, resultado);
        return resultado;
    }
    
    /**
     * Devuelve una lista con todas las claves almacenadas.
     * @param i
     * @param resultado 
     */
    private void keys(int i, LinkedList<K> resultado) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            keysInBucket(tablaHash[i], 0, resultado);
        }
        keys(i + 1, resultado);
    }
    
    /**
     * Devuelve una lista con todas las claves almacenadas.
     * @param balde
     * @param j
     * @param resultado 
     */
    private void keysInBucket(LinkedList<Entrada<K, V>> balde, int j, LinkedList<K> resultado) {
        if (j >= balde.size()) {
            return;
        }
        resultado.add(balde.get(j).llave);
        keysInBucket(balde, j + 1, resultado);
    }
    
    /**
     * Devuelve una lista con todos los valores almacenados.
     * @return lista de los valores almacenados
     */
    public LinkedList<V> values() {
        LinkedList<V> resultado = new LinkedList<>();
        values(0, resultado);
        return resultado;
    }
    
    /**
     * Devuelve una lista con todos los valores almacenados.
     * @param i
     * @param resultado 
     */
    private void values(int i, LinkedList<V> resultado) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            valuesInBucket(tablaHash[i], 0, resultado);
        }
        values(i + 1, resultado);
    }
    
    /**
     * Devuelve una lista con todos los valores almacenados.
     * @param balde
     * @param j
     * @param resultado 
     */
    private void valuesInBucket(LinkedList<Entrada<K, V>> balde, int j, LinkedList<V> resultado) {
        if (j >= balde.size()) {
            return;
        }
        resultado.add(balde.get(j).valor);
        valuesInBucket(balde, j + 1, resultado);
    }
    
    /**
     * Inserta una nueva entrada o actualiza el valor si la clave ya existe.
     * @param llave llave de la entrada
     * @param valor valor de la entrada
     * @return Valor anterior si existía, null si fue una nueva entrada.
     */
    public V put(K llave, V valor) {
        int indice = getIndexHashTable(llave);
        if (tablaHash[indice] == null) {
            tablaHash[indice] = new LinkedList<>();
        }
        return put(tablaHash[indice], llave, valor, 0);
    }
    
    /**
     * Inserta una nueva entrada o actualiza el valor si la clave ya existe.
     * @param balde
     * @param llave
     * @param valor
     * @param i
     * @return 
     */
    private V put(LinkedList<Entrada<K, V>> balde, K llave, V valor, int i) {
        if (i >= balde.size()) {
            balde.add(new Entrada<>(llave, valor));
            nEntradas++;
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            V valorAnterior = entrada.valor;
            entrada.valor = valor;
            return valorAnterior;
        }
        return put(balde, llave, valor, i + 1);
    }

    /**
     * Elimina una entrada del diccionario basada en su clave.
     * @param llave llave de la entrada
     * @return Valor asociado eliminado, o null si no existía.
     */
    public V remove(K llave) {
        int indice = getIndexHashTable(llave);
        if (tablaHash[indice] == null) {
            return null;
        }
        return remove(tablaHash[indice], llave, 0);
    }
    
    /**
     * Elimina una entrada del diccionario basada en su clave.
     * @param balde
     * @param llave
     * @param i
     * @return 
     */
    private V remove(LinkedList<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            V valor = entrada.valor;
            balde.remove(i);
            nEntradas--;
            return valor;
        }
        return remove(balde, llave, i + 1);
    }
    
    /**
     * Devuelve la cantidad de entradas actuales en el diccionario.
     * @return 
     */
    public int size() {
        return nEntradas;
    }
    
    /**
     * Verifica si el diccionario está vacío.
     * @return 
     */
    public boolean empty() {
        return nEntradas == 0;
    }
}
