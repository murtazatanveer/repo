package Arrays;
import java.util.Scanner;
import java.util.Arrays;

class array{
    int arr[]=new int[5];
    Scanner inp = new Scanner(System.in);

    void input(){
        System.out.print("Enter 5 Numbers with Spaces : ");
        for(int i=0;i<arr.length;i++){arr[i]=inp.nextInt();}
    }

    void toString_(){
        String str = Arrays.toString(arr);
        System.out.println(str);
    }

    }

public class To_String_Method {
public static void main(String[] args) {

    array ob = new array();
    ob.input();
    ob.toString_();
    
}
    
}
