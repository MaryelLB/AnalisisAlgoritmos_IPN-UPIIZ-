/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class TSP {
char[]  LetrasCiudades;  
    int[][] Matriz;  
    String  rutaCorta;                           
    int longitudCorta = Integer.MAX_VALUE;   
    List<Nodo>  Caminos=null;                        
 
    TSP(String serieNodos) {
        LetrasCiudades = serieNodos.toCharArray();
        Matriz = new int[LetrasCiudades.length][LetrasCiudades.length];
    }
   
   
    public void agregarRutas(char in, char fi, int dist) {
       
        int n1 = posicionNodos(in);
        int n2 = posicionNodos(fi);
        Matriz[n1][n2]=dist;
        Matriz[n2][n1]=dist;
        
    }
      public String encontrarRuta(char in, char fi) {
        
        encontrarRutaMinima(in);
       
        Nodo tmp = new Nodo(fi);
        if(!Caminos.contains(tmp)) {
            System.out.println("La ciudad es inalcanzable");
            return "";
        }
        tmp = Caminos.get(Caminos.indexOf(tmp));
        int distancia = tmp.distancia;  
        Stack<Nodo> pila = new Stack<Nodo>();
        while(tmp != null) {
            pila.add(tmp);
            tmp = tmp.CiudadProcedencia;
        }
        String ruta = "";
        while(!pila.isEmpty()) ruta+=(pila.pop().id + " ");
        return distancia + ": " + ruta;
    }
 
   
    public void encontrarRutaMinima(char inicio) {
        Queue<Nodo>   cola = new PriorityQueue<Nodo>(); 
        Nodo            ni = new Nodo(inicio);          
         
        Caminos = new LinkedList<Nodo>();
        cola.add(ni);                   
        while(!cola.isEmpty()) {        
            Nodo tmp = cola.poll();     
            Caminos.add(tmp);           
            int p = posicionNodos(tmp.id);   
            for(int j=0; j<Matriz[p].length; j++) {  
                if(Matriz[p][j]==0) 
                    continue;        
                if(Terminacion(j)) 
                    continue;      
                Nodo nod = new Nodo(LetrasCiudades[j],tmp.distancia+Matriz[p][j],tmp);
        
                if(!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                for(Nodo x: cola) {
                    if(x.id==nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); 
                        cola.add(nod);  
                        break;          
                    }
                }
            }
        }
    }
      public void MinimaDistancia(char in, char fi) {
        int p1 = posicionNodos(in);
        int p2 = posicionNodos(fi);
        
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
       private void recorrerRutas(int noI, int noF, Stack<Integer> resul) {
      
        if(noI==noF) {
            int respuesta = evaluar(resul);
            if(respuesta < longitudCorta) {
                longitudCorta = respuesta;
                rutaCorta     = "";
                for(int x: resul) rutaCorta+=(LetrasCiudades[x]+" ");
            }
            return;
        }
        
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<Matriz.length;i++) {
            if(Matriz[noI][i]!=0 && !resul.contains(i))lista.add(i);
        }
      
        for(int nodo: lista) {
            resul.push(nodo);
            recorrerRutas(nodo, noF, resul);
            resul.pop();
        }
    }
       
    public int evaluar(Stack<Integer> resultado) {
        int  resp = 0;
        int solucion=0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=Matriz[r[i]][r[i-1]];
        solucion=Matriz[r[i]][r[i-1]]+resp;
        return solucion;
    }
 
    private int posicionNodos(char nodo) {
        for(int i=0; i<Matriz.length; i++) {
            if(LetrasCiudades[i]==nodo) return i;
        }
        return -1;
    }
  
    public boolean Terminacion(int p) {
        Nodo tmp = new Nodo(LetrasCiudades[p]);
        return Caminos.contains(tmp);
    }
 
    public static void main(String[] args) {
       TSP f = new TSP("abcdefg");
        f.agregarRutas('a','b', 3);
        f.agregarRutas('a','c', 9);
        f.agregarRutas('b','c',2);
        
        f.agregarRutas('b','d', 7);
        f.agregarRutas('b','e', 1);
        f.agregarRutas('c','d', 7);
        
        f.agregarRutas('c','e', 1);
        f.agregarRutas('e','d', 5);
        f.agregarRutas('e','f', 9);
        
        f.agregarRutas('d', 'f', 2);
        f.agregarRutas('d', 'g', 8);
        f.agregarRutas('f', 'g', 4);
     
       
        String resp = f.encontrarRuta('a', 'g');
        System.out.println(resp);
    }
}

