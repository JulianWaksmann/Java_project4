package com.model;

import java.util.*;

public class BuscadorCliqueMaxima {

    // Método principal que encuentra la clique de mayor peso
    public List<Vertice> encontrarCliqueMaxima(Grafo grafo) {
        // Obtener y ordenar los vértices por peso en orden descendente
        List<Vertice> vertices = new ArrayList<>(grafo.getVertices());
        vertices.sort((v1, v2) -> Integer.compare(v2.getPeso(), v1.getPeso()));
        
        List<Vertice> cliqueMaxima = new ArrayList<>();
        // Intentar agregar cada vértice a la clique si cumple las condiciones
        for (Vertice vertice : vertices) {
            if (puedeAgregarAClique(vertice, cliqueMaxima, grafo)) {
                cliqueMaxima.add(vertice);
            }
        }
        
        return cliqueMaxima;
    }

    // Verificar si un vértice puede ser agregado a la clique
    private boolean puedeAgregarAClique(Vertice vertice, List<Vertice> clique, Grafo grafo) {
        for (Vertice v : clique) {
            // Si el vértice no es vecino de algún vértice en la clique, no se puede agregar
            if (!grafo.getVecinos(v).contains(vertice)) {
                return false;
            }
        }
        return true;
    }
}
