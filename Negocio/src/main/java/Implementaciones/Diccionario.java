/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Camila Zubía
 * @param <K>
 * @param <V>
 */
public class Diccionario<K, V> {
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

    private final ListaEnlazada<Entrada<K, V>> tablaHash[];
    private int nEntradas;
    private final int tamTablaHash;

    public Diccionario(ListaEnlazada<Entrada<K, V>>[] tablaHash, int tamTablaHash) {
        this.tablaHash = tablaHash;
        this.tamTablaHash = tamTablaHash;
    }

    private int getIndexHashTable(K llave) {
        return Math.abs(llave.hashCode()) % tamTablaHash;
    }

    public V get(K llave) {
        int indice = getIndexHashTable(llave);
        ListaEnlazada<Entrada<K, V>> balde = tablaHash[indice];
        if (balde == null) {
            return null;
        }
        return get(balde, llave, 0);
    }

    private V get(ListaEnlazada<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            return entrada.valor;
        }
        return get(balde, llave, i + 1);
    }

    public boolean contains(K llave) {
        int indice = getIndexHashTable(llave);
        ListaEnlazada<Entrada<K, V>> balde = tablaHash[indice];
        if (balde == null) {
            return false;
        }
        return contains(balde, llave, 0);
    }

    private boolean contains(ListaEnlazada<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return false;
        }
        if (balde.get(i).llave.equals(llave)) {
            return true;
        }
        return contains(balde, llave, i + 1);
    }

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

    public ListaEnlazada<K> keys() {
        ListaEnlazada<K> resultado = new ListaEnlazada<>();
        keys(0, resultado);
        return resultado;
    }

    private void keys(int i, ListaEnlazada<K> resultado) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            keysInBucket(tablaHash[i], 0, resultado);
        }
        keys(i + 1, resultado);
    }

    private void keysInBucket(ListaEnlazada<Entrada<K, V>> balde, int j, ListaEnlazada<K> resultado) {
        if (j >= balde.size()) {
            return;
        }
        resultado.add(balde.get(j).llave);
        keysInBucket(balde, j + 1, resultado);
    }

    public ListaEnlazada<V> values() {
        ListaEnlazada<V> resultado = new ListaEnlazada<>();
        values(0, resultado);
        return resultado;
    }

    private void values(int i, ListaEnlazada<V> resultado) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            valuesInBucket(tablaHash[i], 0, resultado);
        }
        values(i + 1, resultado);
    }

    private void valuesInBucket(ListaEnlazada<Entrada<K, V>> balde, int j, ListaEnlazada<V> resultado) {
        if (j >= balde.size()) {
            return;
        }
        resultado.add(balde.get(j).valor);
        valuesInBucket(balde, j + 1, resultado);
    }

    public V put(K llave, V valor) {
        int indice = getIndexHashTable(llave);
        if (tablaHash[indice] == null) {
            tablaHash[indice] = new ListaEnlazada<>();
        }
        return put(tablaHash[indice], llave, valor, 0);
    }

    private V put(ListaEnlazada<Entrada<K, V>> balde, K llave, V valor, int i) {
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

    public V remove(K llave) {
        int indice = getIndexHashTable(llave);
        if (tablaHash[indice] == null) {
            return null;
        }
        return remove(tablaHash[indice], llave, 0);
    }

    private V remove(ListaEnlazada<Entrada<K, V>> balde, K llave, int i) {
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

    public int size() {
        return nEntradas;
    }

    public boolean empty() {
        return nEntradas == 0;
    }
    
    public void imprimir() {
        imprimir(0);
    }

    private void imprimir(int i) {
        if (i >= tablaHash.length) {
            return;
        }
        ListaEnlazada<Entrada<K, V>> balde = tablaHash[i];
        if (balde != null) {
            imprimirBalde(balde, 0);
        }
        imprimir(i + 1);
    }

    private void imprimirBalde(ListaEnlazada<Entrada<K, V>> balde, int j) {
        if (j >= balde.size()) {
            return;
        }
        System.out.println(balde.get(j));
        imprimirBalde(balde, j + 1);
    }
}
