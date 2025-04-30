import java.util.*;
public class Matrices{

    public static void diagSum(int arr[][]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum=0;
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr.length ; j++){
                if(i==j || i+j==arr.length-1){
                    sum+=arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
    public static void staircaseSearch(int sortedArr[][],int key){
        int row = sortedArr.length-1;
        int col = 0;

        while(row>=0 && col<sortedArr[0].length){
            if(sortedArr[row][col]==key){
                System.out.println("Key is at ( "+ row + " , " + col + " )");
                break;
            }
            else if(sortedArr[row][col]>key){
                row--;
            }else{
                col++;
            }           
        };
        System.out.println("Key not in the array");
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[][]={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
        
        int sortedArr[][]={{10,20,30,40},
                           {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,50}};
        int key = 40;
       
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr.length ; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        staircaseSearch(sortedArr, key);
    }
}
