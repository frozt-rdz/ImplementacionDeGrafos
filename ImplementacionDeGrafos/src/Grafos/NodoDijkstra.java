/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

/**
 *
 * @author David
 */
public class NodoDijkstra implements Comparable<NodoDijkstra> {
    private int vertice;
    private double distancia;
    
    public NodoDijkstra(int vertice, double distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }
    
    public int getVertice() { return vertice; }
    public double getDistancia() { return distancia; }
    
    @Override
    public int compareTo(NodoDijkstra otro) {
        return Double.compare(this.distancia, otro.distancia);
    }
}