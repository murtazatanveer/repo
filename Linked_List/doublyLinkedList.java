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

 void delete(int index){

    int size = size();

    if(index<0 || index>=size){
        System.out.println("Error : Linked List Index Out of Bounds");
        return;
    }

    node move;
  
    if(index>(int)((size-1)/2)){

         move=tail;

         if (index==(size-1)){
            tail=tail.prev;
            tail.next.prev=null;
            tail.next=null;
            return;
        }
 
        for(int i=size-1;i>index;i--){
            move=move.prev;
        }

        move.prev.next=move.next;
        move.next.prev=move.prev;
        move.next=null;
        move.prev=null;
        move=null;

    }

    else{

        move=head;

        if (index==0){
            head=head.next;
            head.prev.next=null;
            head.prev=null;
            return;
        }

        for(int i=0;i<index;i++){
            
            move=move.next;
        }

        move.prev.next=move.next;
        move.next.prev=move.prev;
        move.prev=null;
        move.next=null;
        move=null;           

    }

 }

void deleteAtStart(){

    if(head==null || tail==null){
        System.out.println("Error : Empty List");
        return;
    }

    node temp=head;
    temp=temp.next;
    head.next=null;
    temp.prev=null;
    head=temp;

}

void deleteAtEnd(){

    if(head==null || tail==null){
        System.out.println("Error : Empty List");
        return;
    }

    node temp = tail;
    temp=temp.prev;
    tail.prev=null;
    temp.next=null;
    tail=temp;

}
   
}



public class doublyLinkedList {

    public static void main(String[] args) {
    
        List list = new List();

       list.addAnElement(10);
        list.addAnElement(15);
        list.addAnElement(25);
        list.addAnElement(20);
    //    list.addAnElement(50);
    //    list.addAtStart(100);
    //    list.displayAllNumbers();
    //    list.delete(1);
    //    list.deleteAtEnd();
    //    list.deleteAtStart();
    //    System.out.println("Size : "+list.size());
       
    //    list.deleteAtStart();
  
    //    list .displayAllNumbers();
       
    //    System.out.println("Size : "+list.size());

    //    list.deleteAtEnd();
       //list.addAnElement(-99);
       list.displayAllNumbers();

 }
}
