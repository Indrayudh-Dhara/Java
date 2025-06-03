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

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();   
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        
        System.out.println(ll.recursiveSearch(6,0,head));
    
    }
}
