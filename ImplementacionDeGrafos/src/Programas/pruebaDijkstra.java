/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programas;

import Grafos.Dijkstra;
import Grafos.GrafoAdcia;
import Grafos.ResultadoDijkstra;

/**
 *
 * @author David
 */
public class pruebaDijkstra {
     public static void main(String[] args) {
        try {
         
            GrafoAdcia grafo = new GrafoAdcia(10);
            
          
            grafo.nuevoVertice("A");
            grafo.nuevoVertice("B");
            grafo.nuevoVertice("C");
            grafo.nuevoVertice("D");
            grafo.nuevoVertice("E");
            
     
            grafo.nuevaArista("A", "B");
            grafo.nuevaArista("A", "C");
            grafo.nuevaArista("B", "D");
            grafo.nuevaArista("C", "D");
            grafo.nuevaArista("D", "E");
            
        
            ResultadoDijkstra resultado = Dijkstra.dijkstra(grafo, "A");
            
            
            resultado.imprimirResultados("A");
            
            System.out.println("\nConsultas ");
            System.out.println("Distancia a E: " + resultado.getDistancia("E"));
            System.out.println("Camino a E: " + resultado.getCamino("E"));
            System.out.println("¿Es D alcanzable?: " + Dijkstra.esAlcanzable(resultado, "D"));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
