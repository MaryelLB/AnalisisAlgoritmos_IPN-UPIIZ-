/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author Usuario
 */
public class Nodo implements Comparable<Nodo>  {
    char id;
    int  distancia = Integer.MAX_VALUE;
    
    Nodo CiudadProcedencia = null;
    Nodo(char x, int d, Nodo p) { id=x; distancia=d; CiudadProcedencia=p; }
    Nodo(char x) { this(x, 0, null); }
    
    public int compareTo(Nodo temp) { 
        return this.distancia-temp.distancia;
    }
    
    public boolean equals(Object o) {
        Nodo temp = (Nodo) o;
        if(temp.id==this.id) 
          return true;
        else
        return false;
    }
    
}
