package Lab_Task_4;

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

 class doublyLinkedList {
    
 private node head;
 private node tail;

 // Question No 3 : Write a program to insert new node in doubly linked list.  insertion can be at start, in the middle of list and at the end of list. Same case for deletion

 void addAnElement(int digit){ //Method to add an element at the end

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

//Question No 4 : Write a program to search an element in doubly linked list.
node searchElement(int val){

    if(head==null || tail==null){
        System.out.println("Error : Empty List");
        return null;
    }

    node move=head;
    

    while (move!=null) {
        if(move.digit==val){
            return move;
        }
        move=move.next;
    }
    
    return null; // return null means value not found in list

}
   
}


