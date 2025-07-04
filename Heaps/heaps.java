package Heaps;

import java.util.ArrayList;

public class heaps {

    static class MinHeap{
        ArrayList<Integer> heap = new ArrayList<>();

        private void heapify(int i){ //takes root as the argument
            int minIdx = i ;// assumption that the root is the minimum
            int left =2*i +1;
            int right = 2*i+2;

            if(left<heap.size() && heap.get(left)<heap.get(minIdx)){ //left<heap.size() means we're not tryna accesss something which isnt there
                minIdx=left;
            }
            if(right<heap.size() && heap.get(right)<heap.get(minIdx)){
                minIdx=right;
            }
            if(minIdx!=i){ //ie , things have been changes
                //swap current root with the one at the minIdx(minIdx contains the minimum number)
                int temp = heap.get(minIdx);
                heap.set(minIdx, heap.get(i));
                heap.set(i, temp);
                //now minIdx has the number which may need another heapify and so on
                heapify(minIdx);

            }
        }

        public boolean isEmpty(){
            return heap.size()==0;
        }

        //adding a node in heap function
        public void insert(int data){ //O(logn)
            heap.add(data); //gets added at the end

            int child = heap.size()-1; //the node is inserted at the end of the AL like yk
            int parent = (child -1)/2; //we find the parent for that child

            while(child>0 && heap.get(child) < heap.get(parent)) { //for min heap , parent is always smaller than the child
                //0 is the index of the root node, and the root has no parent.
                //child>0 means the root of the heap has already been swapped in the previous iteration , so there cannot be neither should be any other iterations further
                int temp = heap.get(parent);
                heap.set(parent , heap.get(child) );
                heap.set(child , temp);

                child=parent;
                parent=(child-1)/2;
            }
        }

        //peek simply means accessing the minimum value of heap for a MIN HEAP
        public int peek(){
            return heap.get(0);
        }

        public int delete(){ //deleting the minimum for a MIN HEAP
            int data = heap.get(0);
            //swap 1st with last node
            int temp = heap.get(heap.size()-1);
            heap.set(heap.size()-1, heap.get(0));
            heap.set(0, temp);
            //delete last node
            heap.remove(heap.size()-1);
            //heapify
            heapify(0);//calling heapify from root
            return data;

        }
    }
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(3);
        h.insert(4);
        h.insert(1);
        h.insert(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.delete();
        }
        
    }
}
