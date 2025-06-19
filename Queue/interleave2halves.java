package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class interleave2halves {

    public static void interleave(Queue<Integer> q1){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q1.size();
        for(int i = 0 ; i<size/2 ; i++){
            firstHalf.add(q1.remove());
        }
        //at this point first half has 1 2 3 4 5 and second half(q) has 6 7 8 9 10
        //Now we use the original queue(second half q) , to do the interleave in itself 

        while (!firstHalf.isEmpty()) {
            //add first the front of the first half
            q1.add(firstHalf.remove());
            //add the front of the original (second half) after adding the front of first half in the same original queue
            q1.add(q1.remove());
        }
        //at this point the interchange is done

        }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);q1.add(3);q1.add(4);q1.add(5);q1.add(6);q1.add(7);q1.add(8);q1.add(9);q1.add(10);

        interleave(q1);
        System.out.println(q1);

    }
}
