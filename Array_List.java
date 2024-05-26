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

    void display(){System.out.println(arr);}


}

class B{}

public class Array_List {
    public static void main(String[] args) {

        A ob = new A();
        ob.addEvenNumbers();
        ob.display();
       System.out.println(ob.arr.size());// Finding Size
        
    }
    
}
