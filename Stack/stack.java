package Stack;


class stackArray{

   int []arr;

   int top=-1;

  stackArray(int size){
    
    arr=new int[size];
  }

  void push(int num){

    if (isStackFull()) {
      System.out.println("Stack is Full");
      return;
    }

    arr[++top]=num;
  }

  int peek(){

    if (isEmpty()) {
      System.out.println("Stack is Empty");
      return 0;
    }

    return arr[top];
  }

  int pop(){

    if (isEmpty()) {
      System.out.println("Stack is Empty");
      return 0;
    }

    int temp = arr[top];
    arr[top--]=0;
    return temp;
  }

  boolean isEmpty(){
    return (top==-1);
  }

  boolean isStackFull(){
    return (top==(arr.length-1));
  }

  void displayStack(){

    if (isEmpty()) {
      System.out.println("Stack is Empty");
      return;
    } 

    System.out.println("_____TOP_____\n");
    for(int i=top;i>=0;i--){
      System.out.println(arr[i]);
    }
    System.out.println("\n____Bottom___");
  }

}




class stackLinkedList{

  class node{

    int data;
    node next;

    node(int data){
      this.data=data;
    }

    node(){
      data=0;
    }

  }

  node top;

  stackLinkedList(){
    top=null;
  }

  void push(int num){

  node newNode = new node(num);
  newNode.next=top;
  top=newNode;

  }

  node peek(){
    return top;
  }

  node pop(){
    
    if (isEmpty()) {
      System.out.println("Empty Stack");
      return null;
    }

    node temp = top;
    top=top.next;
    temp.next=null;
    return temp;

  }

  boolean isEmpty(){
    if (top==null) {
      return true;
    }
    return false;
  }

  void displayStack(){

    if (isEmpty()) {
      System.out.println("Empty Stack");
      return;
    }

    System.out.println("_____TOP_____\n");

    node move = top;

    while (move!=null) {
      System.out.println("     "+move.data);
      move=move.next;
    }

    System.out.println("\n____Bottom___");
  }

}

public class stack {
  public static void main(String[] args) {

    // dynamicStackArray stack = new dynamicStackArray(1);
    // stack.push(10);
    // stack.push(20);
    // stack.push(30);
    // stack.push(40);
    // stack.push(60);
    // stack.push(70);

    // stack.pop();
    // stack.pop();

    // stack.displayStack();

//     stackLinkedList stack2 = new stackLinkedList();
//     stack2.push(10);
//     stack2.push(20);
//     stack2.push(30);
//     stack2.push(40);
//     stack2.push(50);
//     stack2.push(60);
//     stack2.push(70);

//   stack2.push(stack2.pop().data+stack2.pop().data+stack2.peek().data);
//   System.out.println(stack2.peek());
// stack2.push(stack2.pop().data+stack2.pop().data);

//    stack2.displayStack();
  }
}