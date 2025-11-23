/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salva
 */
public class VerticeAdy {

    public String nombre;
    public List<Integer> lad; // Lista de adyacencia (índices de vértices destino)

    public VerticeAdy(String nom) {
        this.nombre = nom;
        this.lad = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VerticeAdy vertice = (VerticeAdy) obj;
        return nombre.equals(vertice.nombre);
    }
}
