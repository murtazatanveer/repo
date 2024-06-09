package Binary_Search;

class binarySearch{

    // Binary Search for both Assending and Decending order.

    int binary_search(int []arr,int target){

        int start=0;
        int mid;
        int end=arr.length-1;

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

    // return the index of Target Element But the array is in Assending Orderz.

    int search(int[] nums, int target){
     
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

public int getCommon(int[] nums1, int[] nums2) {
        
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


}



public class Binary_Search {

    public static void main(String[] args) {
        
        //  binarySearch test = new binarySearch();
        //  System.out.println(test.binary_search(new int[]{-100,-10,-7,-3,0,4,6,12,20,25,100}, 25));
    }
    
}
