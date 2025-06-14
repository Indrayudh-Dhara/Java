package Queue;

//O(1) for every method

public class QueueLL {
    static class Node{
        int data ;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;

        public boolean isEmpty(){
            return head==null && tail==null;
        }
        //FIFO thus add means tail changes
        public void add(int data){
            Node newNode = new Node(data);
            if(head==null){    
                head=tail=newNode;  
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        //remove means head changes
        public int remove(){
            if(isEmpty()){
                return -1;
            }
            if(head==tail){
                int data=head.data;
                tail=head=null;
                return data;                
            }
            int data=head.data;
            head=head.next;
            return data;
        }

        public int peek(){
            if(isEmpty()){
                return -1;

            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(); // no fixed size needed anymore 
    }
}
