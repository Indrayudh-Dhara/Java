package Heaps;

public class heapSort {

        // insert() → Adds a single element to the HEAP and maintains the heap property by bubbling up (O(log n)).

        // heapify() → Converts an entire unsorted array into a valid heap by sinking down (O(n) for whole array).

 

        public static void heapify(int arr[],int i , int size){
            int maxIdx = i;
            int left = 2*i+1;
            int right = 2*i+2;

            
            if(left<size && arr[left]>arr[maxIdx]){
                maxIdx=left;
            }

            if(right<size&& arr[right]>arr[maxIdx]){
                maxIdx=right;
            }
            if(maxIdx!=i){
                //swap
                int temp = arr[maxIdx];
                arr[maxIdx]=arr[i];
                arr[i]=temp;
             
                //call for the swapped root (minIdx)
                heapify(arr,maxIdx , size);
            }
        }

       


        public static void heapsort(int arr[]){ //O(nlogn)
            int n = arr.length;
            //calling heapify(Max) for all the non leaf nodes , to make the unsorted array a max heap first
            for(int i =(n/2) -1 ; i>=0 ; i--){
                heapify(arr ,i , n);
            }

            //now heap is a maxHeap

            //now the swapping ,  eliminating last and heapifying after every swap happens till we get a ascending sort
            for(int i = 0 ; i<n ; i++){
                int temp = arr[0];
               arr[0]=arr[n-1-i];
               arr[n-1-i]=temp;
                //heapify without the last element which was just swapped
                heapify(arr ,0 , n-1-i);
            }
            //now the heap is sorted is ascending order
        }
    

    public static void main(String[] args) {
       
        int arr[] = {1,2,4,5,3};
        heapsort(arr);
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
