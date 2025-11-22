package clases;
import java.util.LinkedList;

/**
 *
 * @author Briana Brito Mtz
 */
public class Vertice {
    String nombre;
    int numvertice;
    LinkedList<Object> lad;
    
    public Vertice(String x){
        nombre = x;
        numvertice = -1;
        lad = new LinkedList();
    }
    
    public String nomVertice(){ //identificador del vertice
        return nombre;
    }
    
    public boolean equals(Vertice n){ //true, si dos vertices son iguales
        return nombre.equals(n.nombre);
    }
    
    public void asigVert(int n){ // establece el num de vertices
        numvertice = n;
    }
    
    public String toString(){ //caracteristicas del vertice
        return nombre + " (" + numvertice + ")";
    }
}


