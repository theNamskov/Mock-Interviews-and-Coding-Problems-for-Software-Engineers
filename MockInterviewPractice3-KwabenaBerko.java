<<<<<<< HEAD
public class MockInterviewPractice3 {

    private static class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode(int value){
            this.value = value;
            this.next = null;
        }

    }

    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        /*
            Before Reversing: 1 -> 2 -> 3 -> 4
            After Reversing: 4 -> 3 -> 2 -> 1
         */

        print(reverseList(head));

    }


    private static LinkedListNode reverseList(LinkedListNode head){
        LinkedListNode currentNode = head;
        LinkedListNode prevNode = null;
        while(currentNode != null){
            LinkedListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;

    }

    private static void print(LinkedListNode head){
        while(head != null){
            System.out.print(head.value + " -> ");
            head = head.next;
        }
    }

=======
import java.util.Arrays;

public class MockInterviewPractice4{

    public static void main(String[] args) {

        int[] myList = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesList = new int[]{1, 5, 8, 12, 14, 19};

        System.out.println(Arrays.toString(mergeLists(myList, alicesList)));

    }

    private static int[] mergeLists(int[] first, int[] second) {
        int[] mergedArr = new int[first.length + second.length];
        int mergedArrPointer = 0;
        int firstArrPointer = 0;
        int secondArrPointer = 0;

        if(first.length == 0){
            return second;
        }
        if(second.length == 0){
            return first;
        }

        while(firstArrPointer < first.length && secondArrPointer < second.length){

            if(first[firstArrPointer] < second[secondArrPointer]){
                mergedArr[mergedArrPointer] = first[firstArrPointer];
                firstArrPointer++;
            }
            else{
                mergedArr[mergedArrPointer] = second[secondArrPointer];
                secondArrPointer++;
            }

            mergedArrPointer++;
        }

        if(firstArrPointer < first.length){
            for(int i = firstArrPointer; i < first.length; i++){
                mergedArr[mergedArrPointer] = first[firstArrPointer];
                mergedArrPointer++;
            }
        }

        if(secondArrPointer < second.length){
            for(int i = secondArrPointer; i < second.length; i++){
                mergedArr[mergedArrPointer] = second[secondArrPointer];
                mergedArrPointer++;
            }
        }


        return mergedArr;
    }
>>>>>>> aa16ce79a7e6400eeec0c13c2c22f984cc67f0b9

}
