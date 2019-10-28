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
public class CaballoDinamico1 {
    final int Filas;
    final int Columnas;
    int[][] tablero;
    int contador;
 
    public CaballoDinamico1(int f, int c) {
        Filas = f;
        Columnas = c;
        tablero= new int[f][c];
    }
 
    public void mostrarTablero() {
        for(int i=0; i<tablero.length; i++) {
            for(int j=0; j<tablero[i].length; j++) {
                System.out.printf("  %2d  |", tablero[i][j]);
            }
            System.out.println();
            for(int j=0; j<tablero[i].length; j++) System.out.print("------+");
            System.out.println();
        }
    }
 
    public boolean resolverProblema(int f, int c, int num) {
            contador++;
            tablero[f][c] = num;
            if(num==Filas*Columnas) return true;
            int[][] posibles = buscarPosibles(f, c);
            for(int i=0; i<posibles.length; i++) {
                if(resolverProblema(posibles[i][0], posibles[i][1], num+1)) return true;
            }
            tablero[f][c]=0;
            return false;
    }
 
    int[][] buscarPosibles(int f, int c) {
        int[][] resp = new int[8][2];
        int     pos  = 0;
        if(esValido(f-2,c-1)){ resp[pos][0]=f-2; resp[pos++][1]=c-1; }
        if(esValido(f-2,c+1)){ resp[pos][0]=f-2; resp[pos++][1]=c+1; }
        if(esValido(f-1,c-2)){ resp[pos][0]=f-1; resp[pos++][1]=c-2; }
        if(esValido(f-1,c+2)){ resp[pos][0]=f-1; resp[pos++][1]=c+2; }
        if(esValido(f+2,c-1)){ resp[pos][0]=f+2; resp[pos++][1]=c-1; }
        if(esValido(f+2,c+1)){ resp[pos][0]=f+2; resp[pos++][1]=c+1; }
        if(esValido(f+1,c-2)){ resp[pos][0]=f+1; resp[pos++][1]=c-2; }
        if(esValido(f+1,c+2)){ resp[pos][0]=f+1; resp[pos++][1]=c+2; }
        int[][] tmp = new int[pos][2];
        for(int i=0; i<pos; i++) { tmp[i][0] = resp[i][0]; tmp[i][1]=resp[i][1]; }
        return tmp;
    }
 
    boolean esValido(int f, int c) {
        if(f<0 || f>Filas-1 || c<0 || c>Columnas-1) return false;
        if(tablero[f][c]!=0) return false;
        return true;
    }
 
    public static void main(String[] args) {
        CaballoDinamico1 pc = new CaballoDinamico1(8,8);
        pc.resolverProblema(1,1,1);
        pc.mostrarTablero();
       
    }
    
}
