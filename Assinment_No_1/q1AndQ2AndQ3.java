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

 class doublyLinkedList {
    
 private node head;
 private node tail;


//Question No 3 : Write a program to find if doubly linked list is palindrome or not?

boolean isListPalindrome(){

    if (head == null || tail == null) {
        System.out.println("Empty List");
        return false; // returs false if list is empty
    }

    node move = head;

    while (move!=null) {
        if(!isNumPalindrome(move.digit)){
            break;
        }
        move=move.next;
    }

    return (move==null);

}

boolean isNumPalindrome(int num){ // returns true if given number is palindrome otherwise return false.

    int rev=Integer.MIN_VALUE;

    int temp=num;


    while (num>0) {

        rev = ((rev*10) + (num%10));
        num /= 10;
    }

    if (rev==temp) {
        return true;
    }

    return false;

}

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



int size(){ // returns the size of list.

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



// Question No 2 : Write a program to find the middle node of doubly Linked List.

node middleNode(){

    if (head == null || tail == null) {
        System.out.println("Empty List");
        return null; // returs null if list is empty
    }

    int size = size();

    if (size%2==0){
        return null; // returns null, if list has no middle node
    }

    int middle = (int)(size/2)+1;

    node move = head;

    for(int i=1;i<middle;i++){
        move=move.next;
    }

return move;

}



//Question No 1:   Write a program to swap two nodes in the doubly Linked List.

void swapNodes(int num1, int num2) {

    if (head == null || tail == null) {
        System.out.println("Empty List");
        return;
    }

    node n1 = findNode(num1);
    node n2 = findNode(num2);

    if (n1 == null || n2 == null) {
        System.out.println(num1 + " or " + num2 + " is not in the list");
        return;
    }

    if (n1 == n2) {
        System.out.println("Both nodes are the same, no swap needed.");
        return;
    }

   
    if (n1.prev != null) {
        n1.prev.next = n2;
    } else {
        head = n2; // n1 was head
    }

    if (n2.prev != null) {
        n2.prev.next = n1;
    } else {
        head = n1; 
    }

    if (n1.next != null) {
        n1.next.prev = n2;
    } else {
        tail = n2; 
    }

    if (n2.next != null) {
        n2.next.prev = n1;
    } else {
        tail = n1; 
    }

    
    node temp1 = n1.prev;
    n1.prev = n2.prev;
    n2.prev = temp1;

    
    node temp2 = n1.next;
    n1.next = n2.next;
    n2.next = temp2;

    System.out.println("Nodes Swapped Successfully");
}

 private node findNode(int val){

    node move = head;

    while (move!=null) {

        if (move.digit==val) {
            return move;
        }

        move=move.next;
    }

    return move; //move is null, if value is not founded in the list.

 }

 
}

public class q1AndQ2AndQ3 {

    public static void main(String[] args) {
        
        doublyLinkedList list = new doublyLinkedList();

      list.addAnElement(101);
        list.addAnElement(202);
        list.addAnElement(33);
        list.addAnElement(234432);
       list.addAnElement(5);

       System.out.println(list.isListPalindrome());
              
    }
    
}
