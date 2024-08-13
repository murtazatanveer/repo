import java.util.Arrays;

class selectionSort{
    
    void sort(int []arr){

        int maxindex=Integer.MIN_VALUE;

        for (int i = arr.length-1; i >= 0; i--) {

            maxindex = maxIndex(arr,i);

            int temp = arr[i];
            arr[i]=arr[maxindex];
            arr[maxindex]=temp;

        }

    }

    private int maxIndex(int []arr ,int end){

        int max = 0;

        for (int i = 1; i <= end; i++) {
            if(arr[i]>arr[max]){
                max=i;
            }
        }

        return max;
    }

}

public class Selection_Sort {

    public static void main(String[] args) {

        selectionSort ob = new selectionSort();

        int []arr = {99,-10,50,200,10,75,50,200,-99,10,75};
        ob.sort(arr);

        System.out.println(Arrays.toString(arr));
        
    }
    
}
