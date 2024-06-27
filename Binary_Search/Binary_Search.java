package Binary_Search;

class binarySearch{

    // Binary Search for both Assending and Decending order.

     int binary_search(int []arr,int target){

        int start = 0;
        int end = arr.length-1;
        int mid;
       
        boolean isAssen = arr[start]<=arr[end];

        while (start<=end){

            mid = start + ((end-start)/2);

            if(arr[mid]==target){return mid;}

            if(isAssen){

                if(arr[mid]<target){
                    start=mid+1;
                }else{
                    end=mid-1;
                }

            }else{

                if(arr[mid]<target){
                    end=mid-1;
                }else{
                    start=mid+1;
                }

            }

        }
        
        return -1;

    }

    // return the index of Target Element But the array is in Assending Order.

    int searchInAssendingArray(int[] nums , int target , int start , int end){

        int mid;

        while (start<=end) {

            mid = start + ((end-start)/2);

            if(target>nums[mid]){
                start=mid+1;
            }
            else if(target<nums[mid]){
                end = mid-1;
            }
            else{
                return mid;
            }         
            
        }
        return -1;

    }


    /* Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 

Constraints:

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 109
Both nums1 and nums2 are sorted in non-decreasing order. */

int getCommon(int[] nums1, int[] nums2) {
        
    for (int n : nums1) {
        if(isElementExist(nums2, n)){
            return n;
        }
    }
    return -1;
}

private boolean isElementExist(int nums[],int target){

        int start = 0;
        int end = nums.length-1;
        int mid;

        while (start<=end) {

            mid = start + ((end-start)/2);

            if(target>nums[mid]){
                start=mid+1;
            }
            else if(target<nums[mid]){
                end = mid-1;
            }
            else{
                return true;
            }         
            
        }
        return false;
}

/* 1103. Distribute Candies to People
Easy
Topics
Companies
Hint
We distribute some number of candies, to a row of n = num_people people in the following way:

We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.

Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.

This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).

Return an array (of length num_people and sum candies) that represents the final distribution of candies.

 

Example 1:

Input: candies = 7, num_people = 4
Output: [1,2,3,1]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0,0].
On the third turn, ans[2] += 3, and the array is [1,2,3,0].
On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
Example 2:

Input: candies = 10, num_people = 3
Output: [5,2,3]
Explanation: 
On the first turn, ans[0] += 1, and the array is [1,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0].
On the third turn, ans[2] += 3, and the array is [1,2,3].
On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 

Constraints:

1 <= candies <= 10^9
1 <= num_people <= 1000 */

int[] distributeCandies(int candies, int num_people) {

    int []arr = new int[num_people];

    int i=0;
    int distribute=1;

    while (candies>0){

        if(i==arr.length){i=0;}

        if(distribute>candies){distribute=candies;}

        arr[i] += distribute;
        candies -= distribute;
        distribute+=1;
        i++;
        
    }

    return arr;
        
}

/* 1716. Calculate Money in Leetcode Bank
Easy
Topics
Companies
Hint
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

 

Example 1:

Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
Example 2:

Input: n = 10
Output: 37
Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
Example 3:

Input: n = 20
Output: 96
Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
 

Constraints:

1 <= n <= 1000 */

int totalMoney(int n) {

    int update=1;

    int distribute=update;

    int sum=0;
      
    for (int i = 1; i <=n ; i++) {

        sum += distribute;
        distribute++;

        if(i%7==0){
            update++;
            distribute=update;
        }
    }
    return sum;
}

/*  744. Find Smallest Letter Greater Than Target

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 

Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter. */


char nextGreatestLetter(char[] letters, char target) {
        
    int index = Charsearch(letters, target);

    if(letters[index]!=target){

        if(letters[index]>target && index>0){
        return letters[index];
    }

    else if(letters[index]<target && index<letters.length-1){
        return letters[index+1];
    }
}

    else if(target==letters[index]){
        for (int i = index+1; i < letters.length; i++) {
            if(letters[i]!=target){
                return letters[i];
            }
        }
    }

    return letters[0];

}

private int Charsearch(char []alpha, char target){
     
    int start = 0;
    int end = alpha.length-1;
    int mid=Integer.MIN_VALUE;

    while (start<=end) {

        mid = start + ((end-start)/2);

        if(target>alpha[mid]){
            start=mid+1;
        }
        else if(target<alpha[mid]){
            end = mid-1;
        }
        else{
            return mid;
        }         
        
    }
    return mid;

}

/* 162. Find Peak Element
Medium
Topics
Companies
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i. */

int findPeakElement(int[] nums) {
   
    for (int i = 1; i < nums.length; i++) {
        if(nums[i]<nums[i-1]){
            return i-1;
        }
    }
return nums.length-1;

}

/* 34. Find First and Last Position of Element in Sorted Array
Solved
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

    int []answer = new int[]{-1,-1};

    answer[0]=searchIndex(nums, target, true);
    answer[1]=searchIndex(nums, target, false);
    return answer;    
        
        }

    private int searchIndex(int []arr , int target , boolean firstIndex){

        int start = 0;
        int end = arr.length-1;
        int mid=Integer.MIN_VALUE;
        int ans=-1;

        while(start<=end){

            mid = start + ((end-start)/2);

            if(arr[mid]<target){
                start = mid +1;
                }
            else if(arr[mid]>target){
                end=mid-1;
            }

            else{
                ans=mid;
                if(firstIndex){
                end=mid-1;
                }
                else{
                    start =mid+1;
                }
            }
           
        }
        return ans;

    }

    // AMAZON Interview Question.
    // Find the Position of an element in  an infinite sorted array.(Binary Search)
    // We cannot use the arr.length or any other way to find the length of array.
    // We assume wo cannot know the size of array.

    int searchInInfiniteArray(int arr[] , int target){

        int start = 0;
        int end = 1;
        int mid = Integer.MIN_VALUE;

        while (start<=end) {

            if(arr[end]<target){
                start=end;
                end *= 2;
                
            }

            else{

            mid = start + ((end-start)/2);

            if(arr[mid]>target){
                end=mid-1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }else{
                return mid;
            }

        }
  
        }

    return -1;

    }

/* 852. Peak Index in a Mountain Array

You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

 

Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

 

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array. */

int peakIndexInMountainArray(int[] arr) {

    int start = 0;
    int end = arr.length-1;
    int mid = Integer.MIN_VALUE;

    while (start<=end){

        mid = start + ((end-start)/2);

        if(arr[mid+1]>arr[mid]){
            start=mid+1;
        }
        else if(arr[mid-1]>arr[mid]){
            end=mid-1;
        }
        else{
            return mid;
        }
        
    }

    return -1;
}

/* 
 1095. Find in Mountain Array

(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 

Constraints:

3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
 */

//  public int findInMountainArray(int target, MountainArray mountainArr) {

//     int length = mountainArr.length();

//     int peakIndex =  peakIndexInMountainArray(mountainArr);

//     int index = binary_search( mountainArr,target,0,peakIndex);

//     return index==-1 ? binary_search(mountainArr,target,peakIndex,length-1) : index;

    
// }
// int peakIndexInMountainArray(MountainArray arr) {

// int start = 0;
// int end = arr.length()-1;
// int mid = Integer.MIN_VALUE;
// int midVal;

// while (start<=end){

//     mid = start + ((end-start)/2);
//     midVal = arr.get(mid);

//     if(arr.get(mid+1)>midVal){
//         start=mid+1;
//     }
//     else if(arr.get(mid-1)>midVal){
//         end=mid-1;
//     }
//     else{
//         return mid;
//     }
    
// }

// return -1;
// }

// int binary_search(MountainArray arr,int target,int start,int end){

//     int mid;
//     int midVal;
   
//     boolean isAssen = arr.get(start)<=arr.get(end);

//     while (start<=end){

//         mid = start + ((end-start)/2);
//         midVal = arr.get(mid);

//         if( midVal==target){return mid;}

//         if(isAssen){

//             if( midVal<target){
//                 start=mid+1;
//             }else{
//                 end=mid-1;
//             }

//         }else{

//             if( midVal<target){
//                 end=mid-1;
//             }else{
//                 start=mid+1;
//             }

//         }

//     }
    
//     return -1;

// }


/* 33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

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

int search(int[] nums, int target){
    
if(nums.length==1 || nums.length==2){

    for (int i = 0; i < nums.length; i++) {
        if(nums[i]==target){return i;}
    }
    return -1;
}

int pivot = pivotElementIndex(nums);

if(pivot==-1){
    return searchInAssendingArray(nums, target, 0, nums.length-1);
}

else if(target>nums[0]){
    return searchInAssendingArray(nums, target, 0,pivot);
}
 else if(target<nums[0]){
    return searchInAssendingArray(nums, target, pivot+1,nums.length-1);
 
 }else{
    return pivot;
 }
    
    
}

private int pivotElementIndex(int []arr){

    int start=0;
    int end=arr.length-1;
    int mid=-1;

    while (start<=end){

        mid = start + ((end-start)/2);

        if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
            return mid;
        }
        else if(arr[mid]>arr[start]){
            start=mid+1;
        }else{
            end=mid-1;
        }
        
    }

    return -1;

}


/* 74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

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

    for (int[] arr : matrix) {
        if(isElementExist(arr, target)){
        return true;
       }
    }
    return false;

}

}


public class Binary_Search {

    public static void main(String[] args) {
        
          binarySearch test = new binarySearch();
        //  System.out.println(test.binary_search(new int[]{-100,-10,-7,-3,0,4,6,12,20,25,100}, 25));
        //System.out.println(test.nextGreatestLetter(new char[]{'c','d','f','j','w','y'}, 'e'));

        System.out.println(test.searchInInfiniteArray(new int[]{2,5,7,11,12,13,19,22,27,29,30,35}, 100));

    }

   
    
    
}
