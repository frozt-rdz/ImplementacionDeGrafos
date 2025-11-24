/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

/**
 *
 * @author David
 */
public class DatoDijkstra {
    private int vertice;
    private double distancia;
    private int predecesor;
    private boolean visitado;
    
    public DatoDijkstra(int vertice) {
        this.vertice = vertice;
        this.distancia = Double.MAX_VALUE;
        this.predecesor = -1;
        this.visitado = false;
    }
    
   
    public int getVertice() { return vertice; }
    public double getDistancia() { return distancia; }
    public void setDistancia(double distancia) { this.distancia = distancia; }
    public int getPredecesor() { return predecesor; }
    public void setPredecesor(int predecesor) { this.predecesor = predecesor; }
    public boolean isVisitado() { return visitado; }
    public void setVisitado(boolean visitado) { this.visitado = visitado; }
}