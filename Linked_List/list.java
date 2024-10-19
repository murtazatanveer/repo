package Linked_List;

class node {

int digit;
node next;

node(int digit){
    this.digit=digit;
    next=null;
}

node(){
    next=null;
}
    
}


class linkedList{

    node head;

    linkedList(){
        head=null;
    }

    void addAnElement(int digit){

        node newDigit = new node(digit);

        if (head==null) {
            head=newDigit;
            return;
        }

            node move = head;

            while (move.next!=null){
                move=move.next;
            }

        move.next=newDigit;
     
    }

    void displayAllDigits(){

        if (head==null) {
            System.out.println("Error : Empty List");
            return;
        }
        

            node move=head;

            System.out.print("\nAll Digits are : ");

            while (move!=null) {
                System.out.print(move.digit+"\t");
                move=move.next;               
        }
        System.out.println("\n");
    }

    void addAtStart(int digit){
        node newdigit = new node(digit);

        if (head==null) {
            head=newdigit;
            return;
        }
            newdigit.next=head;
            head=newdigit;
        
    }

    

    int size(){

        if (head==null) {
            return 0;
        }
        
        node move = head;
        int count=0;

        while (move!=null) {
            move=move.next;
            count++;
        }
        return count;

    }

    void delete(int index){

        if (head==null) {
            System.out.println("Error : Empty List");
            
        }

        else if (index<0 || index>=size()){
            System.out.println("Error : Linked list index out of bounds");
            
        }

        else if(index==0){
            head=head.next;
        }


        else{

    node curr = head;
    node prev = head;

    int count=-1;

    while(curr!=null){
        count++;
        if(count==index){
            prev.next=curr.next;
            curr=null;
            break;
        }
        
        prev=curr;
        curr=curr.next;
    }
    
  } 

}

    void addAtIndex(int index,int digit){

        if (head==null) {
            System.out.println("Error : Empty List");
            return;
        }

        else if (index<0 || index>=size()){
            System.out.println("Error : Linked list index out of bounds");
            
        }

        else{

        node move=head;
        int count=-1;

        while (move!=null) {
            count++;
            if(count==index){
                move.digit=digit;
                break;
            }
            move=move.next;
        }

     }
    }

}

public class list {

    public static void main(String[] args) {
        
        linkedList arr = new linkedList();

        arr.addAnElement(10);
        arr.addAnElement(20);
        arr.addAnElement(30);
        arr.addAnElement(40);
        
        arr.displayAllDigits();

        arr.addAtIndex(2, 777);
        arr.delete(0);
        arr.addAtIndex(0, 222);
        arr.displayAllDigits();

        System.out.println("Size : "+arr.size());
    }
    
}
