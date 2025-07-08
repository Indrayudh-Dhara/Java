package Hashing;

import java.util.HashSet;

public class countDistinct {

    public static void code(int arr[]){
        HashSet<Integer> el = new HashSet<>();
        for(int i = 0 ; i<arr.length ; i++){
            el.add(arr[i]);
        }
        System.out.println(el);
    }
    public static void main(String[] args) {
        int arr[] = {4,3,2,5,6,7,3,4,2,1};
        code(arr);
    }
}
