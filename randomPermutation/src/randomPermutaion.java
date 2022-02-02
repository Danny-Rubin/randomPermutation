import java.util.concurrent.ThreadLocalRandom;

public class randomPermutaion {
    /**
     * Get a random integer in range
     * @param min - the min number in the range
     * @param max - the max number in the range
     * @return - a random integer number between the min number and max number inclusive.
     */
    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    //for each index i in the array, we swap its element with a random element with index j s.t j >= i.
    //assuming randomInRange takes constant time, both time and space complexities are O(n).
    //this guarantees a UNIFORM random permutation
    public static void randPermute(int min, int max){
        int n = max - min + 1;
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){ //initialize an array with the numbers from the range, in order
            arr[i] = i + min;
        }
        for(int i = 0; i < n; i++){ //transform the array into a random permutation using random swaps
            swap(arr, i, randomInRange(i, n-1));
        }
        System.out.println("random, uniform permutation:");
        for(int i : arr){
            System.out.print(i + " ");
        }
        return;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    /*
    an idea to use constant memory but without the constraint that the resulting permutation is uniformly random is as follows:
    1. pick a random number m from the range 1...n-1, n denoting the size of the requested range.
    2. using euclid's gcd algorithm check weather m and n are relatively prime - that is gcd(m, n) = 1.
    3. if they are, continue to step 4, else go to step 1.
    4. for i in 1...n : print (m*i)%n + min

    since m is coprime to n, this guarantees to result in a permutation, since m is random the permutation is guaranteed
    to be random (although not uniformly so). shifting the entire sequence by a random number from 1..n mod n would allow
    for every element in the range min...max to be first.

    time complexity here is expected O(n + f(n)) = O(n) but worst case unbounded where f(n) is O(log n * loglog n)
    (probability that a number less than n is relatively prime is n/(loglog n) and gcd is O(log n)).

    memory complexity is constant.

     */






    public static void main(String[] args) {
        randPermute(-10, 15);
        
    }

}


