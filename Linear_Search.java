import java.util.Arrays;
import java.util.ArrayList;

class linerSearch{

int givenElementIndex(int []arr,int target){

    if(arr.length==0||arr==null){return -1;}

    for(int i=0;i<arr.length;i++){
        if(target==arr[i]){
            return i;
        }
    }

    return -1;// Returns -1 if element doesnot exist in arr or arr is empty or null.
}

boolean isElementExist(int []arr , int target){

    if(arr.length==0||arr==null){return false;}

    for (int i = 0; i < arr.length; i++) {
        if(target==arr[i]){return true;}
        
    }
    return false;

}

int indexOfMaxElement(int []arr){

    if(arr.length==0||arr==null){return -1;}

    int index=0;
    int max=arr[0];

    for (int i = 0; i < arr.length; i++) {
        if(arr[i]>max){
            max=arr[i];
            index=i;
        }
    }
    return index;

}

boolean isCharExist(String str,char ch){

    if(str==null || str.length()==0){return false;}

    for (int i = 0; i < str.length(); i++) {

        if(ch==str.charAt(i)){return true;}
        
    }

    return false;

}

// Linear search in 2D arrays

int [] elementIndex(int [][] arr,int target){


    if(arr==null || arr.length==0){
        return new int[]{-1,-1};
    }

    for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr[i].length; j++) {

             if(target==arr[i][j]){return new int[]{i,j};}          
        }       
    }
 
    return new int[]{-1,-1};
    
}

int numsWithEvenDigits(int [] arr){

    int count=0;

    for (int i = 0; i < arr.length; i++) {
        if(isNumHasEvenDigits(arr[i])){
            count++;
        }
    }
    return count;
}


boolean isNumHasEvenDigits(int num){

    if(num==0){return false;}

    num = num < 0 ? (num * -1) : num;

    int count=0;

    while (num>0){
        num /= 10;
        count++;       
    }

    return count % 2 == 0;

}

int maxWealth(int [][] arr){

    int max = sumofElements(arr[0]);

    for (int i = 1; i < arr.length; i++) {

        if(sumofElements(arr[i])>max){
            max = sumofElements(arr[i]);
        }
        
    }

    return max;

}

int sumofElements(int []arr){

    if(arr==null || arr.length==0){return 0;}

    int sum=0;

    for (int i = 0; i < arr.length; i++) {sum += arr[i];}

    return sum;
}

/* Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9. */

// Solution

int findKthPositive(int[] arr, int k) {
   
    ArrayList<Integer> arrCopy = new ArrayList<>(1);
    
    boolean isExist=false;
    
    for (int i = 1;k>arrCopy.size(); i++) {
      
        for (int j = 0; j < arr.length; j++) {

        if(arr[j]>i){
            break;
        }
            
        if(arr[j]==i){
            isExist=true;
            break;}    
        
    }
    if(!isExist){arrCopy.add(i);}
    isExist=false;
    
}

return arrCopy.get(k-1);
    
}

}


public class Linear_Search {

    public static void main(String [] args){

         linerSearch test = new linerSearch();

         //int []arr = {101,134,67,4,90,163,1111,63,10101,555,-99,0};

        // System.out.println(test.givenElementIndex(arr, 23));

        // System.out.println(test.givenElementIndex(arr, 29));

        // System.out.println(test.isElementExist(arr, 50));

        // System.out.println(test.isElementExist(arr, 90));

        // System.out.println(test.indexOfMaxElement(arr));

        // String s = "Murtaza";

        // System.out.println(test.isCharExist(s, 't'));

        // System.out.println(test.isCharExist(s, 'o'));

        //int [][]arr2d = {{10,80,30},{50,70,19},{10,65,45},{100,50,-10}};

        // System.out.println(Arrays.toString(test.elementIndex(arr2d, 65)));
        // System.out.println(Arrays.toString(test.elementIndex(arr2d, 20)));
        
        // System.out.println(test.numsWithEvenDigits(arr));

        //System.out.println(test.maxWealth(arr2d));

        int []arrTest1 = {2,3,4,7,11};
        
        System.out.println(test.findKthPositive(arrTest1, 5));

        int []arrTest2 = {1,2,3,4};

        System.out.println(test.findKthPositive(arrTest2, 2));

       
    }
    
}
