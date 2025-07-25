import java.util.Stack;

import Backtracking.gridWays;

public class Revision {
   public static boolean checkPalindrome(String str){
   
      for(int i = 0  ; i<str.length()/2 ;i++){
         if(str.charAt(i)!=str.charAt(str.length()-i-1)){
            return false;
         }
      }    
      return true;  
   }

   public static void reverseArr(int arr[]){
      int i = 0;
      int j = arr.length-1;
      while(i<j){
         int temp = arr[i];
         arr[i]=arr[j];
         arr[j]=temp;
         i++;
         j--;
      }
   }

   public static int factorial(int n){
      if(n==0){
         return 1;
      }
      return factorial(n-1)*n;
   }

   public static int gridWays(int grid[][] , int rows, int cols){
      int count = 0 ; 

      
      if(rows==grid.length-1 && cols==grid[0].length-1){
         return 1;
      }
      
      if(rows<=grid.length-1){
         count+=gridWays(grid, rows+1, cols);//down
      }
      if(cols<=grid.length-1){
         count+=gridWays(grid , rows , cols+1);//right
      }
      
      return count;
   }

   public static boolean validParenthesis(String expression){
      Stack<Character> s = new Stack<>();
      boolean isValid= true;
      for(int i = 0 ; i< expression.length() ; i++){
         char currChar = expression.charAt(i);
         if(currChar == '(' || currChar == '{' || currChar == '[' ){
            s.push(currChar);
         }else{
            if(s.isEmpty()){
               return false;
            }
         
               if((currChar==')'&& s.pop()=='(') || (currChar=='}'&& s.pop()=='{') ||(currChar==']'&& s.pop()=='[')  ){
                isValid = true;
               }else{
                  isValid=false;
               }
            
         }
      }
      return isValid;

   }

   public static void main(String[] args) {
   //    String expresssion = "{}()[";
   //    System.out.println(validParenthesis(expresssion));

   // //  int arr[] = {1,2,3,4,5};
   // //  reverseArr(arr);
   // //  for(int i = 0  ; i<arr.length ; i++){
   // //    System.out.print(arr[i] + " ");
   // //  }
   // //  System.out.println();
   

   // // int grid[][]=new int[4][4];
   // // System.out.println(gridWays(grid , 0 , 0));

   int a = 6;
   System.out.println(~a|a);


}
}

