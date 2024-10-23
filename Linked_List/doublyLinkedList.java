package Linked_List;

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

 class List {
    
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

    System.out.print("\nAll digits are : ");

    node move = head;

    while (move!=null){
        System.out.print(move.digit+"\t");
        move=move.next;        
    }

    System.out.println();

 }

 void addAtStart(int digit){

    node newDigit = new node(digit);

    if (head==null||tail==null) {
        head=newDigit;
        tail=newDigit;
        return;
    }

    head.prev=newDigit;
    newDigit.next=head;
    head=newDigit;
 }

 int size(){

    if (head==null || tail==null) {
        return 0;
    }

    node move = head;
    int count=0;

    while (move!=null) {
        count++;
        move=move.next;       
    }

    return count;
 }
   
}

public class doublyLinkedList {

    public static void main(String[] args) {
    
        List list = new List();

       list.addAnElement(10);
       list.addAnElement(15);
       list.addAnElement(25);
       list.addAnElement(20);
       list.addAnElement(50);
       list.addAtStart(100);

       System.out.println("Size : "+list.size());

       list .displayAllNumbers();
 }
}
