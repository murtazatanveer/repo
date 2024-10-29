package Assinment_No_1;

class node{

    int digit;
    node next;
    node prev;

   public node(int val){
       digit=val;
    }

    node(){
        digit=Integer.MIN_VALUE;
    }
}

class circularLinkedList{

    node head;

    // Question No 4 :	Write a program to rotate a circular doubly linked list to make a given node as head.

    void rotate(int rotations){

        if (head==null) {
            System.out.println("Empty List");
            return;
        }

       rotations = rotations<0 ? Math.abs(rotations):rotations;

        if(head.prev==null || head.next==null){
            System.out.println("List is rotated "+rotations+" times.");
            return;
        }

        for (int i = 1; i <= rotations; i++) {
            head=head.next;
        }

        System.out.println("List is rotated "+rotations+" times.");

    }

    void addAnElement(int digit){

         node newNode = new node(digit);

        if (head==null) {
            head=newNode;
            return;
        }

        if (head.prev==null || head.next==null) {
            head.prev=newNode;
            head.next=newNode;
            newNode.prev=head;
            newNode.next=head;
            return;
        }

        newNode.prev=head.prev;
        newNode.next=head;
        newNode.prev.next=newNode;
        head.prev=newNode;

    }

    void displayAlldigits(){

        if (head==null) {
            System.out.println("Empty List");
            return;
        }

        System.out.print("All Digits are : ");

        if (head.prev==null || head.next==null) {
            System.out.print(head.digit);
            return;
        }
       
        node move=head;

        while (move.next!=head) {
            System.out.print(move.digit+"\t");
            move=move.next;
        }

        System.out.print(move.digit);


    }

    // int size(){

    //     if (head==null) {
    //         return 0;
    //     }

    //     if(head.prev==null || head.next==null){
    //         return 1;
    //     }

    //     node move = head;
    //     int count=1;

    //     while (move.next!=head){
    //         count++;
    //         move=move.next;
    //     }

    //     return count;

    // }
        
    
}


public class q4 {
    public static void main(String[] args) {
        
        circularLinkedList list = new circularLinkedList();

        list.addAnElement(10);
        list.addAnElement(20);
        list.addAnElement(30);
        list.addAnElement(40);

        list.rotate(2);
        list.displayAlldigits();

        System.out.println("\n");
        
        list.rotate(3);
        list.displayAlldigits();

    }
}
