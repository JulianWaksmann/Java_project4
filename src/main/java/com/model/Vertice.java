package com.model;

public class Vertice {
    private final String id;
    private final int peso;

    // Constructor para inicializar un vértice con un identificador y un peso
    public Vertice(String id, int peso) {
        this.id = id;
        this.peso = peso;
    }

    // Método para obtener el identificador del vértice
    public String getId() {
        return id;
    }

    // Método para obtener el peso del vértice
    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return id + " (Peso: " + peso + ")";
    }
}