/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author David
 */
public class Dijkstra {
     public static ResultadoDijkstra dijkstra(GrafoAdcia grafo, String origen) throws Exception {
        int numVertices = grafo.numeroDeVertices();
        int origenIdx = grafo.numVertice(origen);
        
        if (origenIdx < 0) {
            throw new Exception("Vértice origen '" + origen + "' no existe");
        }
        
        // Arreglos q se usan para almacenar resultados
        double[] distancias = new double[numVertices];
        int[] predecesores = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];
        
   
        Arrays.fill(distancias, Double.MAX_VALUE);
        Arrays.fill(predecesores, -1);
        distancias[origenIdx] = 0;
        
        // Cola de prioridad 
        PriorityQueue<NodoDijkstra> pq = new PriorityQueue<>();
        pq.offer(new NodoDijkstra(origenIdx, 0));
        
        while (!pq.isEmpty()) {
            NodoDijkstra actual = pq.poll();
            int u = actual.getVertice();
            
            if (visitados[u]) continue;
            visitados[u] = true;
            
 
            for (Integer vecinoIdx : grafo.tablAdc[u].lad) {
                if (!visitados[vecinoIdx]) {
                    double peso = 1.0; 
                    double nuevaDistancia = distancias[u] + peso;
                    
                    if (nuevaDistancia < distancias[vecinoIdx]) {
                        distancias[vecinoIdx] = nuevaDistancia;
                        predecesores[vecinoIdx] = u;
                        pq.offer(new NodoDijkstra(vecinoIdx, nuevaDistancia));
                    }
                }
            }
        }
        
        return new ResultadoDijkstra(distancias, predecesores, grafo);
    }
    

    public static ResultadoDijkstra dijkstraConPesos(GrafoAdcia grafo, String origen, 
                                                   List<ArcoPanel> arcosConPeso) throws Exception {
        int numVertices = grafo.numeroDeVertices();
        int origenIdx = grafo.numVertice(origen);
        
        if (origenIdx < 0) {
            throw new Exception("Vértice origen '" + origen + "' no existe");
        }
        
      
        Map<String, Double> mapaPesos = new HashMap<>();
        for (ArcoPanel arco : arcosConPeso) {
            String key = arco.getInicio().getNombre() + "->" + arco.getFin().getNombre();
            mapaPesos.put(key, (double) arco.getPeso());
        }
        
      
        double[] distancias = new double[numVertices];
        int[] predecesores = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];
        
        Arrays.fill(distancias, Double.MAX_VALUE);
        Arrays.fill(predecesores, -1);
        distancias[origenIdx] = 0;
        
        PriorityQueue<NodoDijkstra> pq = new PriorityQueue<>();
        pq.offer(new NodoDijkstra(origenIdx, 0));
        
        while (!pq.isEmpty()) {
            NodoDijkstra actual = pq.poll();
            int u = actual.getVertice();
            
            if (visitados[u]) continue;
            visitados[u] = true;
            
           
            for (Integer vecinoIdx : grafo.tablAdc[u].lad) {
                if (!visitados[vecinoIdx]) {
                    String nombreU = grafo.tablAdc[u].nombre;
                    String nombreV = grafo.tablAdc[vecinoIdx].nombre;
                    String key = nombreU + "->" + nombreV;
                    
                    double peso = mapaPesos.getOrDefault(key, 1.0);
                    double nuevaDistancia = distancias[u] + peso;
                    
                    if (nuevaDistancia < distancias[vecinoIdx]) {
                        distancias[vecinoIdx] = nuevaDistancia;
                        predecesores[vecinoIdx] = u;
                        pq.offer(new NodoDijkstra(vecinoIdx, nuevaDistancia));
                    }
                }
            }
        }
        
        return new ResultadoDijkstra(distancias, predecesores, grafo);
    }
    

    public static boolean esAlcanzable(ResultadoDijkstra resultado, String destino) throws Exception {
        double distancia = resultado.getDistancia(destino);
        return distancia != Double.MAX_VALUE;
    }
    
}
