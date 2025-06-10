package LinkedList;
import java.util.LinkedList;
import java.util.List;

import Divide_And_Conquer.mergeSort;
import LinkedList.LinkedList.Node;

public class mergeSortLL {
    
    private static Node getMid(Node head){
        Node slow = head ;
        Node fast = head.next; //not fast=head as we wanna return the last element of the first half not the first element of the last half
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;//mid
    }

    private static Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1); //intialize with garbage value everytime merge function is called 
        Node temp = mergedLL;
        while(head1!=null || head2!=null){
            //check which one is smaller and add to temp;
            if(head1.data<=head2.data){
                //add head1 to temp
                temp.next=head1;
                //go to the next node in gead1
                head1=head1.next;
            }else{
                //same thing
                temp.next=head2;
                head2=head2.next;
            }
            //go to the next node of temp for further additon of new nodes
            temp=temp.next;
        }

        //leftovers

        //left leftovers
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        //right left overs
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergedLL.next; //as mergedLL is garbage 
    }

    public static Node mergeSort(Node head){
        //base case (one or empty)
        if(head==null || head.next == null){
            return head;
        }
        //find mid (the mid which is the last element of the first half)
        Node mid = getMid(head);

        //assigning head to the right half
        Node righthead = mid.next;
        //partition logic
        mid.next=null;
        //recusively left
        Node newLeft= mergeSort(head);
        //recursively right
        Node newRight = mergeSort(righthead);
        //merge left and right
        return merge(newLeft,newRight);
    }

    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(List.of(1,2,3,4,5));
        System.out.println(ll);
        mergeSort();
        
    }
    
}
