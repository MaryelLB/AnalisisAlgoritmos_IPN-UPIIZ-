#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define d 256

//RABIN KARP
void buscar(char pat[], char txt[], int q)
{
	//Conversion de nuestros caracteres a INT
    int M = strlen(pat);
    int N = strlen(txt);
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;
    int contador=0;

    for (i = 0; i < M - 1; i++){
        h = (h * d) % q;
    }
    for (i = 0; i < M; i++) {
        p = (d * p + pat[i]) % q;
        t = (d * t + txt[i]) % q;
    }
    //Verificacion y obtencion de los valores que conforman a la cadena donde se encontrara el patron
    for (i = 0; i <= N - M; i++) {
        if (p == t) {
            for (j = 0; j < M; j++) {
                if (txt[i + j] != pat[j])
                    break;
            }
            //Si es verdadero el contador aumentara y nos mostrara la posicion en que se encuentre
            if (j == M)
                printf("se ha encontrado en la posicion :%d \n", i);
                contador++;
        }
        if (i < N - M) {
            t = (d * (t - txt[i] * h) + txt[i + M]) % q;

            if (t < 0)
                t = (t + q);
        }
    }
    //Impresion del contador
     printf("\n numeros repeticion :%d \n", contador);

}

int main()
{
    char txt[] = "holacaradebolabola";
    char pat[] = "bola";
    int q = 101;
    printf("RABIN KARP");
    printf("\nCadena ingresada: ");
    printf(txt);
    printf("\nPatron a encontrar: ");
    printf(pat);
    printf("\n");  
    buscar(pat, txt, q);
    return 0;
}
