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


}



public class Binary_Search {

    public static void main(String[] args) {
        
        //  binarySearch test = new binarySearch();
        //  System.out.println(test.binary_search(new int[]{-100,-10,-7,-3,0,4,6,12,20,25,100}, 25));
    }
    
}
