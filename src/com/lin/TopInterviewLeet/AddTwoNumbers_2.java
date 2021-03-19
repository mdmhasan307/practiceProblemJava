package com.lin.TopInterviewLeet;
/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

import java.util.LinkedList;

public class AddTwoNumbers_2 {


    public static void main(String[] args){

        ListNode l11=new ListNode(2);
        ListNode l12=new ListNode(4);
        ListNode l13=new ListNode(3);
        l11.next=l12;
        l12.next=l13;
        ListNode l21=new ListNode(5);
        ListNode l22=new ListNode(6);
        ListNode l23=new ListNode(4);
        l21.next=l22;
        l22.next=l23;
        ListNode output=addTwoNumbers(l11,l21);
        while (l11!=null){
            System.out.print(l11.val+" ");
            l11=l11.next;
        }
        System.out.println();
        while (l21!=null){
            System.out.print(l21.val+" ");
            l21=l21.next;
        }
        System.out.println();
        while (output!=null){
            System.out.print(output.val+" ");
            output=output.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result=new ListNode(0);
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode p3=result;
        int sum=0, digit=0, carry=0;
        while(p1!=null||p2!=null || carry!=0){
            sum=0;
            if(p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            sum+=carry;
            digit=sum%10;
            carry=sum/10;
            p3.next=new ListNode(digit);
            p3=p3.next;
        }

        return result.next;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
