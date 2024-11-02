package Lab_Assignment_1;

class node{

    node next;
    node prev;

    int digit;

    node(){
        next=null;
        prev=null;
        digit=Integer.MIN_VALUE;
    }

    node(int digit){
        this.digit=digit;
    }

}

class doublyLinkedList{

    private node head;
    private node tail;

    void addAnElement(int digit){

        node newDigit = new node(digit);
    
        if (head==null || tail==null) {
            head=newDigit;
            tail=newDigit;
            return;
        }
    
        tail.next=newDigit;
        newDigit.prev=tail;
        tail=newDigit;    
    
     }

    
     void displayAllNumbers(){

        if (head==null || tail==null) {
            System.out.println("Error : Empty List");
            return;
        }
    
        
    
        node move = head;
    
        while (move!=null){
            System.out.print(move.digit+"\t");
            move=move.next;        
        }
    
        System.out.println();
    
     }

     /*2.	Take one sorted doubly linked list.
      The number of nodes in the list must be 15. Now dived the list in two parts based on condition that number is prime number or not.
       Print both lists. */
     void divideList(){

        if (head==null || tail==null) {
            System.out.println("Empty List");
            return;
        }

        doublyLinkedList primeNums = new doublyLinkedList();
        doublyLinkedList otherNums = new doublyLinkedList();

        node move=head;

       while (move!=null) {

        if (isNumPrime(move.digit)) {

            primeNums.addAnElement(move.digit);

        }else{

            otherNums.addAnElement(move.digit);

        }
        move=move.next;

       }

       System.out.print("Prime Numbers are : ");
       primeNums.displayAllNumbers();


       System.out.print("\n\nOther Numbers are : ");
       otherNums.displayAllNumbers();


     }

     private boolean isNumPrime(int num){

        num = num<0 ? Math.abs(num): num;
        
        int count=0;

        for (int i = 1; i <= num; i++) {
            if (num%i==0) {
                count++;
            }
        }

        if (count==2) {
            return true;
        }

        return false;

     }


}

public class Q2 {
    public static void main(String[] args) {
        
        doublyLinkedList list = new doublyLinkedList();
        
        int digit=1;

        for (int i = 1; i < 15; i++) {
            list.addAnElement(digit);
            digit+=2; // Storing first 15 odd numbers in list;
        }

        list.divideList();
    }
}
