package Grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Briana Brito Mtz
 */
public class GrafoMatriz {

    int numVerts;
    static int MaxVerts = 20;
    public Vertice[] verts;
    public int[][] matAd;
    private static final int CLAVE = -1;

    public GrafoMatriz(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = 0; // asumimos la existencia de pesos NO NEGATVIOS
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
        for (; (i < numVerts) && !encontrado;) { // O.o 
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
    
    public void nuevoArco(String a, String b, int peso) throws Exception { //Añade el arco
        int va, vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if( va < 0 || vb < 0) throw new Exception ("El vertice no existe");
        matAd[va][vb] = peso;
    }
    
    public void nuevoArco(int va, int vb) throws Exception{ 
        if(va < 0 || vb < 0) throw new Exception ("El vertice no existe");

        if (va  < 0 || vb < 0) {
            throw new Exception("El vértice no existe");
        }
        matAd[va][vb] = 1;
    }
    
        public void nuevoArco(int va, int vb,int peso) throws Exception{ 
        if(va < 0 || vb < 0) throw new Exception ("El vertice no existe");

        if (va  < 0 || vb < 0) {
            throw new Exception("El vértice no existe");
        }
        matAd[va][vb] = peso;
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
        v = numVertice(org); //Indice del vertice origen, 0 en este caso, se supone
        if (v < 0) {
            throw new Exception("Vertice origen no existe");
        }
        Queue<Integer> cola = new LinkedList<>();//Vamos a utilizar una cola
        m = new int[numeroDeVertices()]; //Nuestro arreglo depende del numero de vertices de nuestro grafo
        for (int i = 0; i < numeroDeVertices(); i++) {
            m[i] = CLAVE;//Establecemos "distancias" como -1, vertice no visitado
        }
        m[v] = 0; //para m[0] = 0, distancia del origen a el mismo, es 0 
        cola.add(v); //añadimos el vertice A o el cero (indice numerico) a la lista
        while (!cola.isEmpty()) {//En algun momento saldremos del for y la cola estara vacia (no hay mas vertices)
            w = cola.remove();//trabajamos con el vertice que saquemos de la cola, iniciamos con el origen
            System.out.println("vertice " + verts[w].nombre + " (" + m[w] + ") visitado");//Imprimimos el vertice y la informacion de la distancia
            for (int u = 0; u < numeroDeVertices(); u++) {//Para cada vertice del grafo
                if ((matAd[w][u] == 1) && (m[u] == CLAVE)) {//Existe un arco y ademas el vertice no ha sido visitado, entonces
                    m[u] = m[w] + 1;//Distancia a 1 mas que el predecesor
                    cola.add(u);//añadimos el vertice a la cola
                }
            }
        }
        
        
        
        return m;//Hacemos el return de m con las distancias
    }
    
    public int[] recorrerProf(String org) throws Exception {
        int v, w;
        Stack<Integer> pila = new Stack<>();
        int[] m;
        
        m = new int[numeroDeVertices()];
        
        v = numVertice(org);
        if (v < 0) {
            throw new Exception("Vertice origen no existe");
        }
        
        for (int i = 0; i < numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }
        
        m[v] = 0; 
        pila.push(v);
        
        while (!pila.isEmpty()) {
            w = pila.pop();
            System.out.println("Vertice " + verts[w].nombre + " visitado");
            
            for (int u = 0; u < numeroDeVertices(); u++) {
                if ((matAd[w][u] >= 1) && (m[u] == CLAVE)) {
                    m[u] = m[w] + 1; 
                    pila.push(u);
                }
            }
        }
        return m;
    }
    
    public ArrayList<String> getAnchura(String org) throws Exception {
        int w, v;
        int[] m; 
        
        ArrayList<String> ruta = new ArrayList<>();

        v = numVertice(org);
        if (v < 0) throw new Exception("Vertice origen no existe");
        
        Queue<Integer> cola = new LinkedList<>();
        m = new int[numeroDeVertices()];
        
        for (int i = 0; i < numeroDeVertices(); i++) m[i] = CLAVE;
        
        m[v] = 0;
        cola.add(v);
        
        while (!cola.isEmpty()) {
            w = cola.remove();
            
            ruta.add(verts[w].nombre); 
            
            for (int u = 0; u < numeroDeVertices(); u++) {
                if ((matAd[w][u] != 0) && (m[u] == CLAVE)) {
                    m[u] = m[w] + 1;
                    cola.add(u);
                }
            }
        }
        return ruta; 
    }

    public ArrayList<String> getProfundidad(String org) throws Exception {
        int v, w;
        Stack<Integer> pila = new Stack<>();
        int[] m;
        ArrayList<String> ruta = new ArrayList<>();

        m = new int[numeroDeVertices()];
        v = numVertice(org);
        if (v<0) throw new Exception("Vertice origen no existe");

        for (int i=0;i<numeroDeVertices();i++) m[i] = CLAVE;

        m[v] = 0;
        pila.push(v);

        while (!pila.isEmpty()) {
            w = pila.pop();
            ruta.add(verts[w].nombre);
            for (int u=0;u<numeroDeVertices();u++) {
                if ((matAd[w][u] != 0) && (m[u] == CLAVE)) {
                    m[u] = m[w] + 1;
                    pila.push(u);
                }
            }
        }
        return ruta;
    }
    
    // devolver arreglo en donde la iesima posicion indica el id del grupo al que pertenece el nodo i:)
    public int[] encontrarComponentes() {
        int[] grupos = new int[numVerts];
        boolean[] visitados = new boolean[numVerts];
        
        // todos en ningun grupo y sin visitar
        for(int i=0; i<numVerts; i++) {
            grupos[i] = -1;
            visitados[i] = false;
        }

        int idGrupo = 0; // contador para los grupos
        // O(numVerts)
        // tomemos en cuenta que numVerts es valor que sirve como "limite", por lo tanto no es tan optimo
        // la forma de hacer este metodo mas optimo es usar una lista de adyacencia
        for(int i=0; i<numVerts; i++){
            if(!visitados[i]){
                // Si encontramos un nodo no visitado, es una NUEVA ISLA 
                // hacer bfs para marcar isla
                marcarIsla(i, idGrupo, grupos, visitados);
                idGrupo++;
            }
        }
        return grupos;
    }

    private void marcarIsla(int nodoInicio, int idGrupo, int[] grupos, boolean[] vis) {
        // bfs:p
        Queue<Integer> cola = new LinkedList<>();
        cola.add(nodoInicio);
        vis[nodoInicio] = true;
        grupos[nodoInicio] = idGrupo;
        while(!cola.isEmpty()){
            int actual = cola.remove();
            // checamos vecinos
            for(int u=0; u<numVerts; u++){
                boolean conectado = (matAd[actual][u] != 0 || matAd[u][actual] != 0);
                if(conectado && !vis[u]){
                    vis[u] = true;
                    grupos[u] = idGrupo;
                    cola.add(u);
                }
            }
        }
    }
    
    public void mostrarMatriz(){
        int i,j,mx=MaxVerts;
        for(i=0;i<mx;i++){
            for(j=0;j<mx;j++){
                System.out.print(matAd[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public void limpiarGrafo(){
        int i,j,mx=MaxVerts;
        for(i=0;i<mx;i++) for(j=0;j<mx;j++) matAd[i][j]=0;
    }
    
}
