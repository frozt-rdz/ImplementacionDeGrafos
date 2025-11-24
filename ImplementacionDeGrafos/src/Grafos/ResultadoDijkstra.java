/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

/**
 *
 * @author David
 */
import java.util.*;

public class ResultadoDijkstra {
    private double[] distancias;
    private int[] predecesores;
    private GrafoAdcia grafo;
    
    public ResultadoDijkstra(double[] distancias, int[] predecesores, GrafoAdcia grafo) {
        this.distancias = distancias;
        this.predecesores = predecesores;
        this.grafo = grafo;
    }
    
    public double getDistancia(String destino) throws Exception {
        int idx = grafo.numVertice(destino);
        if (idx < 0) throw new Exception("Vértice no existe");
        return distancias[idx];
    }
    
    public List<String> getCamino(String destino) throws Exception {
        int destinoIdx = grafo.numVertice(destino);
        if (destinoIdx < 0) throw new Exception("Vértice destino no existe");
        
        if (predecesores[destinoIdx] == -1 && distancias[destinoIdx] == Double.MAX_VALUE) {
            return new ArrayList<>(); 
        }
        
        List<String> camino = new ArrayList<>();
        Stack<Integer> pila = new Stack<>();
        int actual = destinoIdx;
        
        
        while (actual != -1) {
            pila.push(actual);
            actual = predecesores[actual];
        }
        
       
        while (!pila.isEmpty()) {
            camino.add(grafo.tablAdc[pila.pop()].nombre);
        }
        
        return camino;
    }
    
    public void imprimirResultados(String origen) throws Exception {
        System.out.println("Resultado '" + origen + "' ===");
        for (int i = 0; i < distancias.length; i++) {
            String nombreVertice = grafo.tablAdc[i].nombre;
            double distancia = distancias[i];
            List<String> camino = getCamino(nombreVertice);
            
            System.out.print("Hacia " + nombreVertice + ": ");
            if (distancia == Double.MAX_VALUE) {
                System.out.println("No alcanzable");
            } else {
                System.out.println("Distancia = " + distancia + ", Camino = " + camino);
            }
        }
    }
}