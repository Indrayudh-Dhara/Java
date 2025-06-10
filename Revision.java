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

   public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    reverseArr(arr);
    for(int i = 0  ; i<arr.length ; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
   }
}
