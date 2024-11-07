package Linked_List;

public class leetCode {
    
    /* 
     19. Remove Nth Node From End of List
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
     */

     private class ListNode {
             int val;
             ListNode next;
           ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

      ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        int size=size(head);

        if (size==1) {
            head=null;
            return head;
        }

        else if(size==n){
            head=head.next;
            return head;
        }

        ListNode move =head;

        for (int i = 1; i < (size-n); i++) {
            move=move.next;
        }

        move.next=move.next.next;
        
        return head;


     }

     private int size(ListNode head){
    
        if (head==null) {
            return 0;
        }
        
        ListNode move = head;
        int count=0;

        while (move!=null) {
            move=move.next;
            count++;
        }
        return count;

    }

    /*
     Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
     */

     public ListNode rotateRight(ListNode head, int k) {
        
        int size =size(head);

        if(head==null || size==1){
            return head;
        }
        k%=size;
        ListNode move;

        for (int i = 1; i <=k; i++) {

            move=head;

            for(int j=1;j<size-1;j++){
                move=move.next;
               }

            move.next.next=head;
            head=move.next;
            move.next=null;
        }
        return head;

    }


}
