/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grafos;

/**
 *
 * @author salva
 */
public class pruebaR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            GrafoAdcia grafo = new GrafoAdcia(5);
            grafo.nuevoVertice("A");
            grafo.nuevoVertice("B");
            grafo.nuevoVertice("C");
            grafo.nuevoVertice("D");
            grafo.nuevaArista("A", "B");
            grafo.nuevaArista("A", "C");
            grafo.nuevaArista("B", "D");
            grafo.nuevaArista("C", "D");
            System.out.println("Grafo creado con " + grafo.numeroDeVertices() + " vertices");
            System.out.println("\nRECORRIDO EN PROFUNDIDAD DESDE A");
            int[] resultado = GrafoAdcia.recorrerProf(grafo, "A");
            System.out.println("\nRecorrido completado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
