package Queue;

public class implementationCircularQueue {
    static class Queue{
        int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
           arr=new int[n]; 
           size=n;
           rear=-1;
           front=-1;
        }

        public boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        public boolean isFull(){
            return (rear+1)%size==front;
        }

        public void add(int data){
            if(isEmpty()){
                return;
            }else if(isEmpty()){
                front=0;
            }
            //data added thus rear needs an updation , this we update rear in a circular form as its a circular queue
            rear=(rear+1)%size;
            arr[rear]=data;

        }

        public int remove(){
            if(isEmpty()){
                return -1;
            }
            int result=arr[front];
            if(rear==front){
                rear=front=-1;
            }else{
                //just by updating front we can remove in O(1) in circular queue
                front=(front+1)%size;
            }
            return result;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
         
    }
}
