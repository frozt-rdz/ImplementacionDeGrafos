/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

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
 public void nuevaArista(String origen, String destino) throws Exception {//inicia 
        nuevaArista(origen, destino, 1.0); 
    }
   public void nuevaArista(String origen, String destino, double peso) throws Exception {
        int vo = numVertice(origen);
        int vd = numVertice(destino);
        if (vo < 0 || vd < 0) {
            throw new Exception("Uno o ambos vértices no existen");
        }
    /*public void nuevaArista(String origen, String destino) throws Exception {
        int vo = numVertice(origen);
        int vd = numVertice(destino);
        if (vo < 0 || vd < 0) {
            throw new Exception("Uno o ambos vértices no existen");
        }
        if (!tablAdc[vo].lad.contains(vd)) {
            tablAdc[vo].lad.add(vd);
        }
    }
*/
    for (Arco arco : tablAdc[vo].lad) {
            if (arco.getDestino() == vd) {
                arco.peso = peso; 
                return;
            }
        }
        tablAdc[vo].lad.add(new Arco(vd, peso));
    }
    public List<Arco> getAristasAdyacentes(int vertice) {
        if (vertice < 0 || vertice >= numVerts) {
            return new ArrayList<>();
        }
        return tablAdc[vertice].lad;
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
   public double getPesoArista(int origen, int destino) {
        for (Arco arco : tablAdc[origen].lad) {
            if (arco.getDestino() == destino) {
                return arco.peso;
            }
        }
        return Double.MAX_VALUE; // No existe la arista
    }
    public boolean adyacente(String origen, String destino) throws Exception {
        int vo = numVertice(origen);
        int vd = numVertice(destino);

        if (vo < 0 || vd < 0) {
            throw new Exception("Uno o ambos vértices no existen");
        }

        return tablAdc[vo].lad.contains(vd);
    }//fin agrego david por si esta mal

    public void borrarVertice(String nombre) throws Exception {
        int v = numVertice(nombre);
        if (v < 0) {
            throw new Exception("El vertice no existe");
        }
        for (int i = 0; i < numVerts; i++) {
            if (i != v) {
                Integer verticeEliminar = v;
                tablAdc[i].lad.remove(verticeEliminar);
                List<Arco> nuevaLista = new ArrayList<>();//List<Integer> 
                for (Arco arco : tablAdc[i].lad) {//(Integer integer)
                    if (arco.getDestino()!=v){//adyacente > v)
                        nuevaLista.add(new Arco(arco.getDestino()-1,arco.peso));//nuevaLista.add(adyacente-1)
                    } else {
                        nuevaLista.add(new Arco(arco.getDestino(),arco.peso));
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
           
    while (!pila.isEmpty()) {
        w = pila.pop();
        System.out.println("Vertice " + g.tablAdc[w].nombre + " visitado");
        
        // CORRECCIÓN: Usar Iterator<Arco> en lugar de Iterator<Integer>
        Iterator<Arco> it = g.tablAdc[w].lad.iterator();
        while (it.hasNext()) {
            Arco arco = it.next();
            int k = arco.getDestino();  // Obtener el destino del arco
            if (m[k] == CLAVE) {
                pila.push(k);
                m[k] = m[w] + 1;
            }
        }
    }
       /*while (!pila.isEmpty()) {
            Integer cw;
            //cw = (Integer) pila.pop();
            w = pila.pop();
            System.out.println("Vertice " + g.tablAdc[w].nombre + " visitado");
            //Iterator<Integer> iterador = new Iterator<>(g.tablAdc[w].lad);
            Iterator<Integer> it = g.tablAdc[w].lad.iterator();
            while (it.hasNext()) {
                int k = it.next();
                if (m[k] == CLAVE) {
                    pila.push(k);
                    m[k] = m[w] + 1;

                }
            }
        }*/
        return m;
    }
    
}
