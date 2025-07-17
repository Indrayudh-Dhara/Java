package Hashing;

import java.util.HashSet;

public class unionAndIntersection {

    public static void union(int arr1[] , int arr2[]){
        //union of two arr -> unique els from both of em
        HashSet<Integer> union = new HashSet<>();
        for(int arr : arr1){
            union.add(arr);
        }
        for(int arr: arr2){
            union.add(arr);
        }
        System.out.println(union.size()+ " Union is " + union);
    }

    public static void intersection(int arr1[] , int arr2[]){
        //intersection of two arr -> common els from both of em
        HashSet<Integer> intersection = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int arr : arr1){
            intersection.add(arr);
        }

        for(int arr: arr2){
            if(intersection.contains(arr)){
                result.add(arr);
            }
        }
        System.out.println(result.size() + " Intersection is " + result);
    }
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        union(arr1, arr2);
        intersection(arr1, arr2);
    }
}
