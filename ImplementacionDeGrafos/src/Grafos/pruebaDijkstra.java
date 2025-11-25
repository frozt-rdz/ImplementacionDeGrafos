/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

/**
 *
 * @author David
 */

public class pruebaDijkstra {
    public static void main(String[] args) {
        try {
            // Crear grafo de prueba
            GrafoAdcia grafo = new GrafoAdcia(10);
            
            // Agregar vértices
            grafo.nuevoVertice("A");
            grafo.nuevoVertice("B");
            grafo.nuevoVertice("C");
            grafo.nuevoVertice("D");
            grafo.nuevoVertice("E");
            
            // Agregar aristas CON PESOS REALES
            grafo.nuevaArista("A", "B", 4.0);   // A -> B con peso 4
            grafo.nuevaArista("A", "C", 2.0);   // A -> C con peso 2
            grafo.nuevaArista("B", "C", 1.0);   // B -> C con peso 1
            grafo.nuevaArista("B", "D", 5.0);   // B -> D con peso 5
            grafo.nuevaArista("C", "D", 8.0);   // C -> D con peso 8
            grafo.nuevaArista("C", "E", 10.0);  // C -> E con peso 10
            grafo.nuevaArista("D", "E", 2.0);   // D -> E con peso 2
            
            // Ejecutar Dijkstra desde "A"
            ResultadoDijkstra resultado = Dijkstra.dijkstra(grafo, "A");
            
            // Mostrar resultados completos
            resultado.imprimirResultados("A");
            
            // Consultas específicas
            System.out.println("\n Consultas=");
            System.out.println("Distancia a E: " + resultado.getDistancia("E"));
            System.out.println("Camino a E: " + resultado.getCamino("E"));
            System.out.println("¿Es D alcanzable?: " + Dijkstra.esAlcanzable(resultado, "D"));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}