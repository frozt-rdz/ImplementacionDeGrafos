/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Grafos.VerticeAdy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Briana Brito Mtz
 */
public class GrafoAdcia {

    int numVerts;
    static int maxVerts = 20;
    VerticeAdy[] tablAdc;
    private static final int CLAVE = -1;

    public GrafoAdcia(int mx) {
        tablAdc = new VerticeAdy[mx];
        numVerts = 0;
        maxVerts = mx;
    }

    public void nuevoVertice(String nom) {
        if (numVertice(nom) >= 0) {
            System.out.println("El vertice ya existe");
            return;
        }
        if (numVerts >= maxVerts) {
            System.out.println("No se pueden agregar mas vertices");
            return;
        }
        VerticeAdy nuevo = new VerticeAdy(nom);
        tablAdc[numVerts] = nuevo;
        numVerts++;
    }

    public int numVertice(String nombre) {
        for (int i = 0; i < numVerts; i++) {
            if (tablAdc[i].nombre.equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public void nuevaArista(String origen, String destino) throws Exception {
        int vo = numVertice(origen);
        int vd = numVertice(destino);
        if (vo < 0 || vd < 0) {
            throw new Exception("Uno o ambos vértices no existen");
        }
        if (!tablAdc[vo].lad.contains(vd)) {
            tablAdc[vo].lad.add(vd);
        }
    }

    public void borrarArco(String origen, String destino) throws Exception {
        int vo = numVertice(origen);
        int vd = numVertice(destino);

        if (vo < 0 || vd < 0) {
            throw new Exception("Uno o ambos vértices no existen");
        }
        Integer destinoInt = vd;
        tablAdc[vo].lad.remove(destinoInt);
    }

    public boolean adyacente(String origen, String destino) throws Exception {
        int vo = numVertice(origen);
        int vd = numVertice(destino);

        if (vo < 0 || vd < 0) {
            throw new Exception("Uno o ambos vértices no existen");
        }

        return tablAdc[vo].lad.contains(vd);
    }

    public void borrarVertice(String nombre) throws Exception {
        int v = numVertice(nombre);
        if (v < 0) {
            throw new Exception("El vertice no existe");
        }
        for (int i = 0; i < numVerts; i++) {
            if (i != v) {
                Integer verticeEliminar = v;
                tablAdc[i].lad.remove(verticeEliminar);
                List<Integer> nuevaLista = new ArrayList<>();
                for (Integer adyacente : tablAdc[i].lad) {
                    if (adyacente > v) {
                        nuevaLista.add(adyacente - 1);
                    } else {
                        nuevaLista.add(adyacente);
                    }
                }
                tablAdc[i].lad = nuevaLista;
            }
        }

        for (int i = v; i < numVerts - 1; i++) {
            tablAdc[i] = tablAdc[i + 1];
        }

        tablAdc[numVerts - 1] = null;
        numVerts--;
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public static int[] recorrerProf(GrafoAdcia g, String org) throws Exception {
        int v, w;
        Stack<Integer> pila = new Stack<>();
        int[] m;
        m = new int[g.numeroDeVertices()];
        v = g.numVertice(org);
        if (v < 0) {
            throw new Exception("Vertice no existe");
        }
        for (int i = 0; i < g.numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }
        m[v] = 0;
        pila.push(v);
        while(!pila.isEmpty()){
            Integer cw;
            //cw = (Integer) pila.pop();
            w = pila.pop();
            System.out.println("Vertice "+g.tablAdc[w].nombre+" visitado");
            //Iterator<Integer> iterador = new Iterator<>(g.tablAdc[w].lad);
            Iterator<Integer> it = g.tablAdc[w].lad.iterator();
            while(it.hasNext()){
                int k =it.next();
                if(m[k] == CLAVE){
                    pila.push(k);
                    m[k] = m[w] + 1;
                    
                }
            }
        }
        return m;
    }
}
