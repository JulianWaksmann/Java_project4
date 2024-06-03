package com.model;

import java.util.*;

public class Grafo {
    private final Map<Vertice, List<Vertice>> listaAdyacencia;

    // Constructor para inicializar el grafo con una lista de adyacencia vacía
    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    // Método para agregar un vértice al grafo
    public void agregarVertice(Vertice vertice) {
        listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    // Método para agregar un arco entre dos vértices
    public void agregarArco(Vertice v1, Vertice v2) {
        listaAdyacencia.get(v1).add(v2);
        listaAdyacencia.get(v2).add(v1);
    }

    // Método para obtener los vecinos de un vértice
    public List<Vertice> getVecinos(Vertice vertice) {
        return listaAdyacencia.get(vertice);
    }

    // Método para obtener todos los vértices del grafo
    public Set<Vertice> getVertices() {
        return listaAdyacencia.keySet();
    }
}
