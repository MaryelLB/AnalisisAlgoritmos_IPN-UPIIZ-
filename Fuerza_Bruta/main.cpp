#include "iostream"
#include<conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define max 5000

using namespace std;

int l;
int j;
int i;
int n,m;

//FUERZA BRUTA
void FuerzaBruta(char a[max],char b[max]){
	//Conversion de nuestros caracteres a int
	n=strlen(a);
    m=strlen(b); 
    int contador=0;
     //Recorrido que hara sobre la cadena para encontrar el patron
     for(i=0;i<=n-m;i++){
       int  l=i; 
	   int j=0;
        while(a[l]==b[j] &&  j<=m) {
            l++; 
			j++;
			 }
        if(j>m-1){	
			//Checa la posicion en la que lo ha encontrado			
    		cout<<"El patron a buscar se ha encontrado en : "<<i+1<<endl; //Determinara la pocision en que se encuentre el patron
    		contador++;	
			}							
	 }	
	 //Imprime el numero de veces que se ha encontrado el patron
	  cout<<"\n Se han encontrado: "<<contador<<" patrones"<<endl;	
}	 

int main(){
	
int i,j,P;
float t,ini,fin;
char cadena[max],patron[max];
int opcion;

do{
cout<<"\n FUERZA BRUTA"<<endl;
cout<<"Ingrese la cadena: "<<endl;
cin>>cadena;
cout<<endl<<"Ingrese patron a encontrar: "<<endl;
cin>>patron;
FuerzaBruta(cadena,patron);
cout<<"\n Deseas ingresar una nueva cadena: "<<endl;
cin>>opcion;
system("cls");

}while(opcion!=2);

}
