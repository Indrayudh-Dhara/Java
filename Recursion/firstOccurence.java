package Recursion;

public class firstOccurence {
    public static int firstOccurenceElement(int arr[] ,int si, int target){
        if(si>arr.length-1){
            return -1;
        }

        if(arr[si]!=target){
            return firstOccurenceElement(arr, si+1, target);
        }else{
            return si;
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,6,3,1,8,9};
        System.out.println(firstOccurenceElement(arr, 0,1));
    }
}
