import java.util.ArrayList;
import java.util.Arrays;


public class Util {

    public static ArrayList<Integer> generatePrimes(int length) {
        ArrayList<Integer> primeList = new ArrayList();
        primeList.add(2);
        for(int i=3;i<=length;i=i+2){
            boolean isPrime = true;
            for(int j=0;primeList.get(j)<=Math.sqrt(i) && isPrime;j++){
                isPrime = (i%primeList.get(j)) != 0;
            }
            if(isPrime)primeList.add(i);
        }
        return primeList;
    }

    public static int[] generateSievesPrimes(int length) {
        int[] primes = new int[length+1];
        Arrays.fill(primes,1);
        primes[0] = 0;
        primes[1] = 0;
        for(int i=2;i<=length/2;i++){
            primes[i*2] = 0;
        }
        for(int i=3;i<=Math.sqrt(length);i=i+2){
            if(primes[i] == 0) continue;
            for(int j=2;j*i <= length;j++){
                primes[i*j] = 0;
            }
        }
        return primes;
    }

    public  static void main(String[] args){


       ArrayList<Integer> primeList = generatePrimes(1000000);
       int[] primeMap = generateSievesPrimes(1000000);
       for ( int p : primeList){
           if(primeMap[p] == 0){
               System.out.println(p);
           }
       }
    }


}