import java.util.*;

public class MockInterviewPractice6 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveAlgorithm(10).toArray()));
        System.out.println(Arrays.toString(sieveAlgorithm(20).toArray()));
        System.out.println(Arrays.toString(sieveAlgorithm(30).toArray()));
    }

    public static List<Integer> sieveAlgorithm(int number){
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> notCurrentMultiples = new LinkedList<>();
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= number; i++){
            numbers.add(i);
        }

        while(!numbers.isEmpty()){
           int prime = numbers.remove();
           primes.add(prime);
           while(!numbers.isEmpty()){
               int currentNumber = numbers.remove();
               if(currentNumber % prime != 0){
                   notCurrentMultiples.add(currentNumber);
               }
           }
           Queue<Integer> tempQueue = numbers;
           numbers = notCurrentMultiples;
           notCurrentMultiples = tempQueue;
        }

        return primes;
    }

}
