package Arrays;
import java.util.ArrayList;

class A{

    ArrayList<Integer> arr = new ArrayList<Integer>(10);

    void addEvenNumbers(){

        int even=0;

        for (int i = 0; i < 25; i++) {
            arr.add(even);
            even+=2;          
        }

    }

    void arrayListFunctions(){

        System.out.println(arr.size()); // Finding size

        System.out.println(arr.get(10));// Returning Value at index.

      System.out.println(arr.contains(44));// Check if input value Exist.

        //arr.remove(0); // Removing Value from input Index.

      
        arr.set(0, 99); // Setting Value at index.

        // int arr[3][5];

    }

    void display(){System.out.println(arr);}

    void twoDimensionArrayList(){

        ArrayList<ArrayList<Integer>> arr2D = new ArrayList<>(10);
      
            for (int j = 0; j < 3; j++) {

                arr2D.add(new ArrayList<>());
                
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {

                    arr2D.get(i).add((int)(Math.random()*50));
                    
                }
            }
            
        System.out.println(arr2D);       

    }


}


public class Array_List {
    public static void main(String[] args) {

        A ob = new A();
        ob.addEvenNumbers();
        ob.arrayListFunctions();
        ob.display();

        ob.twoDimensionArrayList();

       
                
    }
    
}
