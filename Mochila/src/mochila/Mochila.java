/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

/**
 *
 * @author Usuario
 */
public class Mochila {

 public void MochilaChida(int cap, int LI[],int n, int peso[]){
        int Mochila[][] = new int[n+1][cap+1];
        for(int temp=0;temp<=n;temp++){
            for(int ps=0;ps<=cap;ps++){
                if(temp==0 || ps==0){
                    Mochila[temp][ps] = 0;
                }else if(peso[temp-1]<=ps){
                     Mochila[temp][ps] = obtenerCantidadMayor(
                             LI[temp-1]+Mochila[temp-1][ps-peso[temp-1]],
                             Mochila[temp-1][ps]);
                }else{ 
                    Mochila[temp][ps] = Mochila[temp-1][ps];
                }
               System.out.print(Mochila[temp][ps]);
               if(ps!=Mochila[temp].length-1){
                   System.out.print(" ");
               }
            }
             System.out.print("\n");
        }
    System.out.println();
    System.out.println("Total: " +Mochila[n][cap]);
    while(n!=0){
        if(Mochila[n][cap]!=Mochila[n-1][cap]){
           System.out.println("Articulos: "+n+", Peso = "+peso[n-1]+", Valor = "+LI[n-1]);
            cap=cap-peso[n-1];
        }
              n--;
        }
    }
    
      private int obtenerCantidadMayor(int i, int f){
       if(i > f){
        return i;
        }else{
         return f;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
         int L[] = new int[]{70,100,120};
    int peso[] = new int[]{10,20,30};
    Mochila nw = new Mochila();
    
        nw.MochilaChida(50,L,L.length,peso);
    }
    
}
