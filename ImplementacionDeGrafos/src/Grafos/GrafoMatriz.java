package Grafos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Briana Brito Mtz
 */
public class GrafoMatriz {

    int numVerts;
    static int MaxVerts = 20;
    Vertice[] verts;
    int[][] matAd;
    private static final int CLAVE = -1;

    public GrafoMatriz(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = 0;
            }
        }
        numVerts = 0;
    }

    public void nuevoVertice(String nom) { //Añade un nuevo vertice
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    public int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }

        return (i < numVerts) ? i : -1;
    }

    public void nuevoArco(String a, String b) throws Exception { //Añade el arco
        int va, vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if( va < 0 || vb < 0) throw new Exception ("El vertice no existe");
        matAd[va][vb] = 1;
    }
    
    public void nuevoArco(int va, int vb) throws Exception{ 
        if(va < 0 || vb < 0) throw new Exception ("El vertice no existe");

        if (va  < 0 || vb < 0) {
            throw new Exception("El vértice no existe");
        }
        matAd[va][vb] = 1;
    }

    public void borrarArco(String a, String b) throws Exception {
        int v1 = numVertice(a);
        int v2 = numVertice(b);
        if (v1 < 0 || v2 < 0) {
            throw new Exception("El vértice no existe");
        }
        //Arco ab = new Arco(v2);
        //verts[v1].lad.remove(ab);
        matAd[v1][v2] = 0;
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public int[] recorrerAnchura(String org) throws Exception {
        int w, v;
        int[] m;
        v = numVertice(org);
        if (v < 0) {
            throw new Exception("Vertice origen no existe");
        }
        Queue<Integer> cola = new LinkedList<>();
        m = new int[numeroDeVertices()];
        for (int i = 0; i < numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }
        m[v] = 0;
        cola.add(v);
        while (!cola.isEmpty()) {
            w = cola.remove();
            System.out.println("vertice " + verts[w].nombre + " (" + m[w] + ") visitado");
            for (int u = 0; u < numeroDeVertices(); u++) {
                if ((matAd[w][u] == 1) && (m[u] == CLAVE)) {
                    m[u] = m[w] + 1;
                    cola.add(u);
                }
            }
        }
        return m;
    }
}
