package com.tp3;

import com.model.BuscadorCliqueMaxima;
import com.model.CargadorGrafo;
import com.model.Grafo;
import com.model.Vertice;
import com.model.VisualizadorGrafo;

import javax.swing.*;
import java.io.IOException;
import java.util.List;


public class App {
    
    // Método para crear un grafo de ejemplo
    private static Grafo crearGrafoEjemplo() {
        Grafo grafo = new Grafo();

        // Crear vértices
        Vertice v1 = new Vertice("1", 10);
        Vertice v2 = new Vertice("2", 20);
        Vertice v3 = new Vertice("3", 30);
        Vertice v4 = new Vertice("4", 40);
        Vertice v5 = new Vertice("5", 50);
        Vertice v6 = new Vertice("6", 60);
        Vertice v7 = new Vertice("7", 70);
        Vertice v8 = new Vertice("8", 80);
        Vertice v9 = new Vertice("9", 90);
        Vertice v10 = new Vertice("10", 100);

        // Agregar vértices al grafo
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);
        grafo.agregarVertice(v8);
        grafo.agregarVertice(v9);
        grafo.agregarVertice(v10);

        // Crear arcos (adyacencias)
        grafo.agregarArco(v1, v2);
        grafo.agregarArco(v1, v3);
        grafo.agregarArco(v2, v3);
        grafo.agregarArco(v2, v4);
        grafo.agregarArco(v3, v4);
        grafo.agregarArco(v4, v5);
        grafo.agregarArco(v5, v6);
        grafo.agregarArco(v6, v7);
        grafo.agregarArco(v7, v8);
        grafo.agregarArco(v8, v9);
        grafo.agregarArco(v9, v10);
        grafo.agregarArco(v10, v1);
        grafo.agregarArco(v3, v7);
        grafo.agregarArco(v4, v8);
        grafo.agregarArco(v5, v9);
        grafo.agregarArco(v6, v10);
        grafo.agregarArco(v2, v8);

        return grafo;
    }
    
    // main
    //public static void main(String[] args) {
    //    SwingUtilities.invokeLater(() -> {
    //        try {
    //            // Cargar el grafo desde el archivo especificado
    //            Grafo grafo = CargadorGrafo.cargarDesdeArchivo("grafo.json");
    //            BuscadorCliqueMaxima buscador = new BuscadorCliqueMaxima();
    //            // Encontrar la clique de peso máximo
    //            List<Vertice> clique = buscador.encontrarCliqueMaxima(grafo);
//
    //            System.out.println("Clique de Peso Máximo: " + clique);
    //            // Visualizar el grafo y la clique encontrada
    //            VisualizadorGrafo visualizador = new VisualizadorGrafo();
    //            visualizador.visualizar(grafo, clique);
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //    });
    //}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Grafo grafo = crearGrafoEjemplo();
            BuscadorCliqueMaxima buscador = new BuscadorCliqueMaxima();
            List<Vertice> clique = buscador.encontrarCliqueMaxima(grafo);

            System.out.println("Clique de Peso Máximo: " + clique);
            VisualizadorGrafo visualizador = new VisualizadorGrafo();
            visualizador.visualizar(grafo, clique);
        });
    }
}
