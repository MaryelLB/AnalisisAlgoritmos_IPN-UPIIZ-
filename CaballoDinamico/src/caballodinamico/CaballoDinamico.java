/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caballodinamico;

/**
 *
 * @author Usuario
 */
public class CaballoDinamico {
    private int[][] tableroA = new int[9][9];
    private boolean exito;
    private int[][] movimientos = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private int Finicial, Cinicial;
    
    public CaballoDinamico(int f, int c){
       
        if ((f < 1) || (f > 8)|| (c < 1) || (c > 8)){
                 
          System.out.print("Coordenadas fuera de lugar");
        }
        Finicial = f;
        Cinicial = c;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                tableroA[i][j] = 0;
            }
        }
        tableroA[Finicial][Cinicial] = 1;
     
    }
    public void resoluciondelProblema() {
        SaltoDelCaballo(Finicial, Cinicial, 2);
       
    }
    private void SaltoDelCaballo(int x, int y, int i) {
        int Fx, Fy;
        int k;
        k = 0; 
        do {
            k++;
            Fx = x + movimientos[k - 1][0];
            Fy = y + movimientos[k - 1][1];
            if ((Fx >= 1) && (Fx <= 8) && (Fy >= 1) && (Fy <= 8)  && (tableroA[Fx][Fy] == 0)) {
                tableroA[Fx][Fy] = i;
                if (i < 8 * 8) {
                    SaltoDelCaballo(Fx, Fy, i + 1);
                    if (!exito) {
                        tableroA[Fx][Fy] = 0; 
                    }
                } else {
                    exito = true; 
                }
            }
        } while ((k < 8) && !exito);
    }
    void mostrarTablero() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                System.out.print(tableroA[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
  
            CaballoDinamico ml = new CaballoDinamico(4,4);
                                 ml.resoluciondelProblema();
                                 ml.mostrarTablero();
          
        }
}
