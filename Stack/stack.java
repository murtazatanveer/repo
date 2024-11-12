package Stack;
import Linked_List.*;

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

  private singlyLinkedList list;

  stackLinkedList(){
    list=new singlyLinkedList();
  }

  void push(int num){

    list.addAtStart(num);

  }

  int peek(){
    return list.getDigit(0);
  }

  int pop(){
    int temp=list.getDigit(0);
    list.deleteFromStart();
    return temp;
  }

  void displayStack(){
    System.out.println("_____TOP_____\n");
    list.displayAllDigits();
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

  //   stackLinkedList stack2 = new stackLinkedList();
  //   stack2.push(10);
  //   stack2.push(20);
  //   stack2.push(30);
  //   stack2.push(40);
  //   stack2.push(50);
  //   stack2.push(60);
  //   stack2.push(70);

  //  System.out.println( stack2.pop()+"\t"+stack2.pop());
  //  System.out.println(stack2.peek());

  //  stack2.displayStack();
  }
}