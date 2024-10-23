package Linked_List;


public class exe {

    public static void main(String[] args) {
        
        linkedList arr = new linkedList();

        arr.addAnElement(80);
        arr.addAnElement(13);
        arr.addAnElement(19);
        arr.addAnElement(25);
        arr.addAnElement(50);
        arr.addAnElement(75);
        
        arr.displayAllDigits();
        arr.deleteFromEnd();
         arr.insertAfterIndex(2, -88);
        arr.displayAllDigits();

         arr.addDigitAtIndex(2, 21);
        arr.displayAllDigits();

        arr.delete(0);
        arr.addDigitAtIndex(0, 222);
        arr.displayAllDigits();

        System.out.println(arr.getDigit(2));
        System.out.println("Size : "+arr.size());
    }
    
}
