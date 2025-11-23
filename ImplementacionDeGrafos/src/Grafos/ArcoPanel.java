/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;
/**
 *
 * @author crist
 */
public class ArcoPanel extends Arco {
    int INF = 100000000;
    VerticePanel inicio;
    VerticePanel fin;
    int peso;

    public ArcoPanel(VerticePanel inicio, VerticePanel fin) {
        this.inicio = inicio;
        this.fin = fin;
        peso = INF;
    }

    public ArcoPanel(VerticePanel inicio, VerticePanel fin, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        this.peso = peso;
    }

    public VerticePanel getInicio() {
        return inicio;
    }

    public void setInicio(VerticePanel inicio) {
        this.inicio = inicio;
    }

    public VerticePanel getFin() {
        return fin;
    }

    public void setFin(VerticePanel fin) {
        this.fin = fin;
    }
    
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }


    
    
}
