package LinkedList;

public class DoubleLL {

    public class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
            
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;

    }

    public  void print(){
        Node temp = head;
        System.out.print(null+ "<->");
        while(temp!=null){
            System.out.print(temp.data + "<->");
            temp=temp.next;
        }
        System.out.print("" +null);
        System.out.println();
    }

    public int removeFirst(){
        //edge cases
        if(head==null){
            System.out.println("Nothing to remove , LL is empty");
            return -1;
        }else if(head.next==null){
            int data = head.data;
            head=tail=null;
            size--;
            return data;
            
        }
        int data = head.data;
        size--;
        
        head=head.next;
        head.prev=null;
        return data;
    } 

    public int removeLast(){
        if(head==null){
            System.out.println("Nothing to remove , LL is empty");
            return -1;
        }else if(head.next==null){
            size--;
            int data = head.data;
            head=tail=null;
            return data;
            
        }

        int data=tail.data;
        size--;
        tail=tail.prev;
        tail.next=null;
        return data;
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            curr=next;
            prev=curr;
        }
        head=prev;
    }
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        dll.reverse();
        dll.print();
        
        
        
    }
}
