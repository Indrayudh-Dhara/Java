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

    

    public static boolean hasCycle(){ //Floyd's Cycle Algorithm
        Node slow = head;
        Node fast = head;
        //normal linkedlist condition for odd and even
        while(fast!=null && fast.next != null){
            slow= slow.next;
            fast=fast.next.next;
            //condition for checking cycle
            if(slow==fast){
                return true;
            }
        } 
        return false;

    }
    //code not for a full cycle (i.e where the cycle is connected with head itself  1(head)->2->3->-4>->1(head))   X 
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
            if(slow==fast){
               cycle = true;
               break;
            }
        }
        if(cycle==true){
            slow=head;
            Node prev = null;
            while(slow!=fast){
                slow=slow.next;
                prev=fast;
                fast = fast.next;   
            }
            prev.next=null;
            System.out.println("Removed cycle");
            return;
        }
          System.out.println("No cycle detected");
        return;          
    }
       
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
        //asuuming all datas in LL is > 0
        Node mergedLL = new Node(-1); //intialize dummy node with garbage value everytime merge function is called 
        Node temp = mergedLL;
        while(head1!=null && head2!=null){
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
        LinkedList ll = new LinkedList();   
        
        ll.addFirst(1);
        ll.addFirst(2);
           ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        
        //creating a cycle LL
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = head.next;
        // System.out.println(hasCycle());
        // removeCycle();
        // System.out.println(hasCycle());
        //1->2->3->1
        
        // System.out.println(ll.recursiveSearch(6,0,head));
       
        // ll.findAndRemovefromStart(3);
        // System.out.println(ll.checkPalindrome());

        ll.print();
        ll.head= ll.mergeSort(ll.head);
        ll.print();

       
    }
}
