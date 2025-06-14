package Queue;

public class implementationArr {

    //implementation of queue using array
    static class Queue{
        static int rear;
        static int arr[];
        static int size;

        Queue(int n){
            arr =new int[n];
            size=n;
            rear=-1;
        }

        public boolean isEmpty(){
            return rear==-1;
        }

        public void add(int data){   //O(1)
            //edge case when array is full (as array is fixed)
            if(rear==size-1){
                System.out.println("Arrray is full no place for it");
                return;
            }

            rear=rear+1;
            arr[rear]=data;
        }

        public int remove(){ //O(n)
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];

            //push everything towards the side([previous) by 1 
            for(int i = 0 ; i<rear;i++){
                arr[i]=arr[i+1];
            }
            //adjust rear as it is a specified value , unlike front which we are definined just for this
            rear=rear-1; //as everything went to the left by one this rear needs adjustment
            return front;

        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }


    }
    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        //1 2 3
    }
}
