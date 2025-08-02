package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    static class rottenOrange{
        int i;
        int j;
        int time;
        public rottenOrange(int i , int j , int time){
            this.i = i ;
            this.j = j;
            this.time = time;
        }
    }
    public static int code(int arr[][]){
        Queue<rottenOrange> q = new LinkedList<>();
        //initialize at 0th time
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr[0].length ; j++){
                if(arr[i][j]==2){
                    q.add(new rottenOrange(i, j, 1));
                }
            }
        }

        int maxTime = 0 ;
        //bfs
        while(!q.isEmpty()){
            rottenOrange orange = q.remove();
            //up
            int row = orange.i;
            int col = orange.j;
            int time = orange.time;
            //up
        if(row<arr.length && row>=0 && col<arr[0].length && col>=0){
            if(row-1>=0 && arr[row-1][col]==1 ){
                arr[row-1][col]=2;
                q.add(new rottenOrange(row-1, col, time+1));
                maxTime=Math.max(maxTime, time+1);
            }
            //down
            if(row+1<arr.length && arr[row+1][col]==1){
                arr[row+1][col]=2;
                q.add(new rottenOrange(row+1, col, time+1));
                maxTime=Math.max(maxTime, time+1);

            }
            //left
            if(col-1>=0 && arr[row][col-1]==1){
                arr[row][col-1]=2;
                q.add(new rottenOrange(row, col-1, time+1));
                maxTime=Math.max(maxTime, time+1);
                
            }
            //right
            if(col+1<arr[0].length && arr[row][col+1]==1){
                arr[row][col+1]=2;
                q.add(new rottenOrange(row, col+1, time+1));
                maxTime=Math.max(maxTime, time+1);

            }
        }

        }

        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr[0].length ; j++){
                if(arr[i][j]==1){
                    return -1;
                }
            }
        }

        return maxTime;


    }
    public static void main(String[] args) {
        int arr[][] = {{2,1,0,2,1},{0,0,1,2,1},{1,0,0,2,1}};
        System.out.println(code(arr));
    }
}
