package Queue;

class queueLinkedList{

    private node front;
    private node rear;

     class node  {

        int data;
        node next;

        node(int data){
            this.data=data;
        }

    }

    queueLinkedList(){
        front=null;
        rear=null;
    }
    
    void enQueue(int num){

        node newNum = new node(num);

        if (front==null && rear==null) {
            front=newNum;
            rear=newNum;
            return;
        }

        rear.next=newNum;
        rear=rear.next;

    }

    int deQueue(){
        
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }
        
        node temp;

        if (front==rear) {
            temp=front;
            front=null;
            rear=null;
            return temp.data;
        }
        
        temp=front;
        front=front.next;
        return temp.data;

    }

    boolean isEmpty(){
        return front==null && rear==null ? true : false; 
    }

    void displayQueue(){

        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }

        node temp=front;

        System.out.print("Queue : ");
        while (temp!=null) {
            System.out.print(temp.data+" --> ");
            temp=temp.next;
        }

        System.out.print("END\n"); 
    }

}



public class queue {
    public static void main(String[] args) {
        
       queueLinkedList queue = new queueLinkedList();
       queue.enQueue(10);
       queue.enQueue(20);
       queue.enQueue(30);
       queue.enQueue(40);
       queue.enQueue(50);
       queue.displayQueue();
       queue.deQueue();
       queue.deQueue();

       queue.displayQueue();


    }
}
