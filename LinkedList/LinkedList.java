package LinkedList;

public class LinkedList {

    //blueprint(hence class) of each node 
    public static class Node{

        int data ; 
        //as it stores the address of the next Node itself thus the type has to be Node
        Node next ;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //automatically initialized as zero
    public static Node head ;
    public static Node tail;
    public static int size;

    //we make methods for every operation we do with linkedlist 
    //No need for static keyword in those methods as we are calling it through LinkedList so it can call both static and non static inside static main


    public void addFirst(int data){
        //create new Node to be added
        Node newNode = new Node(data);
        size++;
        //case for empty LL
        if(head==null){
            head = tail = newNode;
            return ;
        }
        //point it to the head
        newNode.next=head;
        //change head to itself
        head = newNode;


    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return ;
        }
        tail.next=newNode;
        tail=newNode;
    }

    //add node at an index
    public void add(int index , int data){
        if(index==0){
            addFirst(data);
            return;
        }
        //creating the new node to be added
        Node newNode = new Node(data);
        size++;
        //index tracker
        int i=0;
        //temp node to traverse
        Node temp = head;
        while (i<index-1) {
            temp=temp.next;
            i++;
        }
        //i now at previous element
        //assigning the next of newNode to the current next of temp this new Node comes between the temp and the curr next of temp
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst(){
        if(head==null){
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
            
        }
        int val = head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(head==null){
            return Integer.MAX_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;

        }
       
        Node temp = head;
        for(int i=0 ; i<=size-2 ; i++){
            temp=temp.next;
        }
        int val = tail.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
        
    }



    //print LL
    public void print(){
        Node temp = head;
        while(temp!=null){
        System.out.print(temp.data+"->");
        temp=temp.next;
        }
        System.out.println("null");
    }

    public  int iterativeSearch(int key){
        Node temp = head;
        for(int i = 0 ; i<size ; i++){
            if(temp.data==key){
                return i;
            }else{
                temp=temp.next;
            }
            
        }
        return -1;

    }

    public  int recursiveSearch(int key , int i , Node temp){
        
        //base case
        if(temp==null){
            return -1;
        }
        if(temp.data==key){
            return i;
        }
       
        return recursiveSearch(key, i+1 , temp.next);
        
    };

    public void reverse(){   //O(n)
        //nothing before head so prev =null while initializing
        Node prev=null;
        //head gets stored to tail then tail gets stored to curr , it changes the tail for the reverse as well as initialize the curr for traversing
        Node curr=tail=head;
        
        Node next;
        while(curr!= null){
            //creates the next node for every iteration
             next = curr.next;
             //reversing process , changes curr.next to link the previous node 
             curr.next=prev;
             //changes the previous to the nextone(curr)
             prev=curr;
             //changes the curr to the next one (next)
             curr=next;

            }
            //after everything is done curr is on null so head is prev
            head=prev;
    }

    //12345 index3-4 remove 4 so we need previous index , ie index i=1
    public void findAndRemovefromStart(int index){
        if(index==0){
            removeFirst();
            return;
        }else if(index==size-1){
            removeLast();
            return;
        }else if(index>size){
            System.out.println("Index greater than size");
            return;
        }
        Node temp=head;
       
        //iterate to the previous index  element 
        for(int i= 0 ; i<=index-2; i++){
            temp=temp.next;
        }
      
        //at this point temp has the previous index element and temp2 has the index element
        temp.next=temp.next.next;
        size--; 
    }
    //slow and fast approach , slow increases by one and fast by 2 . So when fast is at the end slow is at the middle(half of fast)
    public Node findMiddle(Node head){

        Node slow = head;
        Node fast = head;
        //fast null when even & fast.next null when odd
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        
        }
        return slow;
    }
    public boolean checkPalindrome(){
        //edge cases
        if(head==null || head.next==null){
            return true;
        }
        //find middle
        Node midNode = findMiddle(head);
        //reverse 3 parameters 4 works
        Node prev = null;
        //starting from midNode thus reversing only the second half
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // here we assign the left and right(new starting point of the currently reversed portion) (2 Pointer Approach)
        Node right = prev;
        Node left = head;
        //check left and right
        while(right!=null){
            if(right.data!=left.data){
                return false;
            }
            //changing the two pointers
            right=right.next;
            left=left.next;
        }

        return true;
    }
        
    

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();   
        
        ll.addLast(1);
        ll.addLast(2);
           ll.addLast(2);
        ll.addLast(1);
        
        // System.out.println(ll.recursiveSearch(6,0,head));
       
        // ll.findAndRemovefromStart(3);
        System.out.println(ll.checkPalindrome());

       
    }
}
