package com.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class CargadorGrafo {

    // Método para cargar el grafo desde un archivo JSON
    public static Grafo cargarDesdeArchivo(String nombreArchivo) throws IOException {
        Grafo grafo = new Grafo();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode nodoRaiz = mapper.readTree(new File(nombreArchivo));

        // Cargar los vértices del archivo JSON
        JsonNode nodosVertices = nodoRaiz.get("vertices");
        Iterator<JsonNode> iteradorVertices = nodosVertices.elements();
        while (iteradorVertices.hasNext()) {
            JsonNode nodoVertice = iteradorVertices.next();
            Vertice vertice = new Vertice(nodoVertice.get("id").asText(), nodoVertice.get("peso").asInt());
            grafo.agregarVertice(vertice);
        }

        // Cargar los arcos del archivo JSON
        JsonNode nodosArcos = nodoRaiz.get("arcos");
        Iterator<JsonNode> iteradorArcos = nodosArcos.elements();
        while (iteradorArcos.hasNext()) {
            JsonNode nodoArco = iteradorArcos.next();
            Vertice v1 = obtenerVerticePorId(grafo, nodoArco.get("v1").asText());
            Vertice v2 = obtenerVerticePorId(grafo, nodoArco.get("v2").asText());
            grafo.agregarArco(v1, v2);
        }

        return grafo;
    }

    // Método para obtener un vértice por su ID
    private static Vertice obtenerVerticePorId(Grafo grafo, String id) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getId().equals(id)) {
                return vertice;
            }
        }
        throw new IllegalArgumentException("Vértice con id " + id + " no encontrado.");
    }
}
