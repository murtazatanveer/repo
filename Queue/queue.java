package Queue;
import Linked_List.*;

class queueArray{

    int end;
    int front;
    int []arr;

    queueArray(int size){
        arr=new int[size];
        front=0;
        end=0;
    }

    void enQueue(int num){

        
        
    }

    int deQueue(){

    }

    void displayQueue(){
  
    }

    int size(){
        
    }

    boolean isEmpty(){      
                  
    }

    boolean isQueueFull(){
       
    }

    

}

class queueLinkedList{

    singlyLinkedList list;


    queueLinkedList(){
        list=new singlyLinkedList();
    }
    
    void enQueue(int num){
        list.addAnElement(num);
    }

    int deQueue(){
        
        int temp=list.getDigitFromStart();
        list.deleteFromStart();
        return temp;
        
    }

    void displayQueue(){

        System.out.print("\nFront ");
        list.displayAllDigits();
        System.out.println(" Rear\n\n");
    }

}

public class queue {
    public static void main(String[] args) {
        
        // queueArray que = new queueArray(5);

        // que.enQueue(10);
        // que.enQueue(20);
        // que.enQueue(30);
        // que.enQueue(40);
        // que.enQueue(50);
        
        // que.deQueue();
        // que.deQueue();
        // // que.deQueue();
        // // que.deQueue();
        // // que.deQueue();

       
        
        //  que.enQueue(66);
        //  que.enQueue(76);
        //  que.enQueue(86);


        // que.displayQueue();
        

    }
}
