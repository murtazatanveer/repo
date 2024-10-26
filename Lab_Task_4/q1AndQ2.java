package Lab_Task_4;


class node {

    int digit;
    node next;
    
    public node(int digit){
        this.digit=digit;
        next=null;
    }
    
    public node(){
        next=null;
    }
        
    }
    
    
     class singlyLinkedList{
    
        node head;
    
        public singlyLinkedList(){
            head=null;
        }

        //Question No 1 : 1.	Write a program to delete all the nodes having certain value from a singly linked list.

        void delete(int val){
    
            if (head==null) {
                System.out.println("Error : Empty List");
                
            }          
    
            else if(head.digit==val){
                head=head.next;
            }
    
    
            else{
    
        node curr = head;
        node prev = head;
    
        while(curr!=null){
            
            if(curr.digit==val){
                prev.next=curr.next;
                curr=null;
                break;
            }
            
            prev=curr;
            curr=curr.next;
        }
        
      }
    
    } 

     //Question No 2 : 2.	Write a program to print singly linked list in reverse order.

    void displayAllDigits(){
    
        if (head==null) {
            System.out.println("Error : Empty List");
            return;
        }
        
        singlyLinkedList temp = new singlyLinkedList();

            node move=head;

            System.out.print("\nAll Digits are : ");

            while (move!=null) {
                temp.addAtStart(move.digit);
                move=move.next;               
        }

        move=temp.head;
        
        while (move!=null) {
            System.out.print(move.digit+"\t");
            move=move.next;               
    }
        

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
    
}