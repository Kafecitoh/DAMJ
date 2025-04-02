package ud6;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class EPO1209 {
    // Declara la lista 
List <Integer> numeros;{
 
// Crea la lista 
numeros = new ArrayList<>(); 
 
// Añade 20 números aleatorioa a la lista 
for(int i = 0; i < 20; i++){ 
    numeros.add((int)(Math.random()*100)); 
} 
 
System.out.println("\nELEMENTOS CON VALOR PAR\n"); 
 // Imprime índice y valor de los elementos con valor par         
for(int i = 0; i < numeros.size(); i++){ 
    if (numeros.get(i) % 2 == 0) { 
        System.out.println(i + ": " + numeros.get(i)); 
    } 
} 
 
System.out.println("\nELEMENTOS CON VALOR IMPAR\n"); 
// Imprime índice y valor de los elementos con valor impar 
for(int i = 0; i < numeros.size(); i++){ 
    if (numeros.get(i) % 2 != 0) { 
        System.out.println(i + ": " + numeros.get(i)); 
    } 
} 
    
}
}