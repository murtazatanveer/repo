import java.util.Arrays;

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

    int []result = new int[2];

    if(arr==null || arr.length==0){
        result[0]=-1;
        result[1]=-1;
        return result;
    }

    for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr[i].length; j++) {

             if(target==arr[i][j]){
                result[0]=i;
                result[1]=j;
                return result;
                }          
        }       
    }
 
    result[0]=-1;
    result[1]=-1;
    return result;
    
}


}


public class Linear_Search {

    public static void main(String [] args){

         linerSearch test = new linerSearch();

        // int []arr = {101,12,67,23,90,45,9,63};

        // System.out.println(test.givenElementIndex(arr, 23));

        // System.out.println(test.givenElementIndex(arr, 29));

        // System.out.println(test.isElementExist(arr, 50));

        // System.out.println(test.isElementExist(arr, 90));

        // System.out.println(test.indexOfMaxElement(arr));

        // String s = "Murtaza";

        // System.out.println(test.isCharExist(s, 't'));

        // System.out.println(test.isCharExist(s, 'o'));

        // int [][]arr2d = {{10,80,30},{50,70,19},{10,65,45}};

        // System.out.println(Arrays.toString(test.elementIndex(arr2d, 65)));
        // System.out.println(Arrays.toString(test.elementIndex(arr2d, 20)));
        
       
    }
    
}
