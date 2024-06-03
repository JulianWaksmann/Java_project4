package com.model;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.ext.JGraphXAdapter;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;
import java.util.Map;

public class VisualizadorGrafo {

    public void visualizar(Grafo grafo, List<Vertice> clique) {
        SimpleGraph<String, DefaultEdge> jGraphT = new SimpleGraph<>(DefaultEdge.class);

        for (Vertice vertice : grafo.getVertices()) {
            jGraphT.addVertex(vertice.getId());
        }

        for (Vertice v1 : grafo.getVertices()) {
            for (Vertice v2 : grafo.getVecinos(v1)) {
                if (!jGraphT.containsEdge(v1.getId(), v2.getId()) && !jGraphT.containsEdge(v2.getId(), v1.getId())) {
                    jGraphT.addEdge(v1.getId(), v2.getId());
                }
            }
        }

        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(jGraphT);
        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);

        // Eliminar flechas para mostrar el grafo como no dirigido
        mxGraph graph = graphComponent.getGraph();
        Map<String, Object> edgeStyle = graph.getStylesheet().getDefaultEdgeStyle();
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.NONE);

        // Usar un layout circular para centrar los nodos
        mxCircleLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        // Añadir funcionalidad de zoom
        graphComponent.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getPreciseWheelRotation() < 0) {
                    graphComponent.zoomIn();
                } else {
                    graphComponent.zoomOut();
                }
            }
        });

        // Ajustar el componente de gráfico para centrar el grafo
        graphComponent.getViewport().setOpaque(true);
        graphComponent.getViewport().setBackground(graphComponent.getBackground());
        graphComponent.setCenterZoom(true);

        // Crear un JScrollPane y agregar el componente del grafo
        JScrollPane scrollPane = new JScrollPane(graphComponent);
        scrollPane.setPreferredSize(new Dimension(800, 800));

        // Centrar la vista del grafo
        Dimension graphSize = graphComponent.getGraphControl().getSize();
        Dimension viewSize = scrollPane.getViewport().getSize();
        Point viewPosition = new Point((graphSize.width - viewSize.width) / 2, (graphSize.height - viewSize.height) / 2);
        scrollPane.getViewport().setViewPosition(viewPosition);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setTitle("Visualización del Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }
}
