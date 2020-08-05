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


}
