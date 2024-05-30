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

/*  Given an array nums of integers, return how many of them contain an even number of digits.

 

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits. */

int findNumbers(int[] nums) {

    int count=0;

    for (int i = 0; i < nums.length; i++) {
        if(isNumHasEvenDigits(nums[i])){
            count++;
        }
    }
    return count;
}


private boolean isNumHasEvenDigits(int num){

    if(num==0){return false;}

    num = num < 0 ? (num * -1) : num;

    int count=0;

    while (num>0){
        num /= 10;
        count++;       
    }

    return count % 2 == 0;

}

/*  You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17 */

 int maximumWealth(int[][] accounts){

    if(accounts.length==1){return sumofElements(accounts[0]);}

    int max = sumofElements(accounts[0]);

    for (int i = 1; i < accounts.length; i++) {

        if(sumofElements(accounts[i])>max){
            max = sumofElements(accounts[i]);
        }
        
    }

    return max;

}

private int sumofElements(int []arr){

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

/* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4 */

 int searchInsert(int[] nums, int target) {

    int i; 

    for (i= 0; i < nums.length; i++) {

        if(target==nums[i]){
            return i;
        }

        if(target < nums[i]){
            return i;
        }
        
    }

    return i;      
}


/*  You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10 */

public int singleNonDuplicate(int[] nums) {

    if(nums.length==1){return nums[0];}

    if(nums[0]!=nums[1]){
        return nums[0];
    }

    if(nums[nums.length-1]!=nums[nums.length-2]){
        return nums[nums.length-1];
    }

    for (int i = 1; i < nums.length-1; i++) {

        if( (nums[i]!=nums[i+1] ) && (nums[i]!=nums[i-1]) ){
            return nums[i];
        }
        
    }

    return Integer.MAX_VALUE;
        
}

/*  Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 

Constraints:

1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6 */

  int[] runningSum(int[] nums) {

    int []arr = new int[nums.length];

    int sum=0;

     for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            arr[i]=sum;

     }

     return arr;
        
    }

    /*  You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 
Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104 */

boolean searchMatrix(int[][] matrix, int target) {

    if(matrix.length==1){

        for (int i = 0; i < matrix[0].length; i++) {

            if(matrix[0][i]>target){return false;}

            if(target==matrix[0][i]){return true;}
            
        }
    }

    if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[(matrix.length-1)].length-1]){return false;}


    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {

             if(matrix[i][j]>target){return false;}

            if(matrix[i][j]==target){return true;}
            
        }
               
    }
    return false;
        
    }

    /*  Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
 */

     boolean searchMatrix2(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }

        if(matrix.length==1){

            for (int i = 0; i < matrix[0].length; i++) {
    
                if(matrix[0][i]>target){return false;}
    
                if(target==matrix[0][i]){return true;}
                
            }
        }
    
        if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[(matrix.length-1)].length-1]){return false;}
    
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
    
                 if(matrix[i][j]>target){break;}
    
                if(matrix[i][j]==target){return true;}
                
            }
                   
        }
        return false;

    }

    /*  There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104 */

int search(int[] nums, int target) {

    if(nums==null || nums.length<1){return -1;}

    for(int i = 0;i<nums.length;i++){
        if(target==nums[i]){return i;}
    }

    return -1;
        
}

/* 34. Find First and Last Position of Element in Sorted Array
Medium
Topics
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */

int[] searchRange(int[] nums, int target) {

    if(nums==null | nums.length<1){return new int[]{-1,-1};}

    else{

    for (int i = 0; i < nums.length && nums[i]<=target; i++) {

        if(target==nums[i]){
            
            return new int[]{i,similarNums(nums,i,target)};
        }
        
    }

}

    return new int[]{-1,-1};
        
}

private int similarNums(int nums[],int index,int target){
    

    for (int i = index+1; i < nums.length && nums[i]<=target; i++) {
        
        if(nums[i]==target){index ++;}               
    }
    return index;

}


/*  41. First Missing Positive
Hard
Topics
Companies
Hint
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1 */

public int firstMissingPositive(int[] nums) {

    int check=1;

    while(true){

        if(contains(nums,check)){
            check++;
        }
        else{
            return check;
        }
    }
        
}

private boolean contains(int []arr,int check){

    for (int i = 0; i < arr.length; i++) {
        if(check==arr[i]){
            return true;
        }
    }
    return false;
}

// private int maxNum(int arr[]){

//     int max = arr[0];
    
//     for (int i = 1; i < arr.length; i++){

//         if(max<arr[i]){
//             max=arr[i];
//         }
       
//     }

//     return max;
// }

// private int minNum(int arr[]){

//     int min = arr[0];
    
//     for (int i = 1; i < arr.length; i++){

//         if(min>arr[i]){
//             min=arr[i];
//         }
       
//     }

//     return min;
// }

}


public class Linear_Search {

    public static void main(String [] args){

         //linerSearch test = new linerSearch();

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

        // int []arrTest1 = {2,3,4,7,11};
        
        // System.out.println(test.findKthPositive(arrTest1, 5));

        // int []arrTest2 = {1,2,3,4};

        // System.out.println(test.findKthPositive(arrTest2, 2));

        // int []arrTest3 = {1,3,5,6};

        // System.out.println(test.searchInsert(arrTest3, 5));
        // System.out.println(test.searchInsert(arrTest3, 2));
        // System.out.println(test.searchInsert(arrTest3, 7));

       
    }
    
}
