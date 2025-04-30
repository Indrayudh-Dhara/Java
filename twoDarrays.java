public class twoDarrays {

    public static void tranpose(int arr[][]){
       
        //before transpose
        for(int i = 0 ; i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int rows = 2;
        int cols =3;
        int transpose[][]= new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                transpose[j][i]=arr[i][j];
            }
        }
        //after transpose
        for(int i = 0 ; i<transpose.length;i++){
            for(int j = 0;j<transpose[0].length;j++){
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
                 
    }
    
    public static void main(String[] args) {
        int[][] arr = { {1,4,9},{11,4,3} };
        tranpose(arr);
}
}
