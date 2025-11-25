/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Programas;

import Grafos.GrafoMatriz;

/**
 *
 * @author salva
 */
public class pruebaR2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            GrafoMatriz grafo = new GrafoMatriz(4);
            grafo.nuevoVertice("A");
            grafo.nuevoVertice("B");
            grafo.nuevoVertice("C");
            grafo.nuevoVertice("D");
            grafo.nuevoArco("A", "B");
            grafo.nuevoArco("A", "C");
            grafo.nuevoArco("B", "D");
            System.out.println("Matriz de adyacencia:");
            for (int i = 0; i < grafo.numeroDeVertices(); i++) {
                for (int j = 0; j < grafo.numeroDeVertices(); j++) {
                    System.out.print(grafo.matAd[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Recorrido en anchura desde A:");
            int[] distancias = grafo.recorrerAnchura("A");
            System.out.println("\nDistancias desde A:");
            for (int i = 0; i < distancias.length; i++) {
                System.out.println(grafo.verts[i].nombre + ": " + distancias[i]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
