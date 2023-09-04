import java.util.Scanner;

public class heapsort {
    //Implementation of HeapSort
    private static void applyHeap(int[] vetor, int n, int i){
        int source = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        //Compare the root with the children
        if (left < n && vetor[left] > vetor[source]){
            source = left;
        }
        if (right < n && vetor[right] > vetor[source]){
            source = right;
        }
        //Stores changed values ​​and applies recursion
        if (source != i){
            int aux = vetor[i];
            vetor[i] = vetor[source];
            vetor[source] = aux;
            
            applyHeap(vetor, n, source);
        }
    }

    public static void main(String[] args) {

        //desired vector size
        //int[] vetor = new int[10];

        /*Fills a vector with random values
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int) Math.floor(Math.random() * vetor.length);
        }
        */

        /*
        //Add values ​​to array manually
            Scanner sc2 = new Scanner(System.in);
            for(int i = 0; i < vetor.length; i++){
            vetor[i] = sc2.nextInt();
        }
        sc2.close();
        */
        
        //Imprime o vetor desordenado
        System.out.println("\ndisordered");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }
        
        //Application of HeapSort
        int n = vetor.length;
        
        for(int i = n / 2 - 1; i >= 0; i--){ //Applies only up to half of the array (as much needed)
            applyHeap(vetor, n, i);
        }
        
        //Prints the pre-sorted vector
        System.out.println("\n\npre-sorted");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }
        
        //Applies the HeapSort again, in order to guarantee the order and pass the highest values ​​to the end of the array
        for(int j = n-1; j > 0; j--){
            int aux = vetor[0];
            vetor[0] = vetor[j];
            vetor[j] = aux;
            
            applyHeap(vetor, j, 0);
        }
        
        //Prints the sorted vector
        System.out.println("\n\nsorted!");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }
    }
}