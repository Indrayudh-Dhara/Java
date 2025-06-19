package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class jobSqeuence {

    public static void code(int jobs[][]){
       
        Arrays.sort(jobs,Comparator.comparingDouble(o -> o[1]));
        
        //here 2d array is sorted in ascending according to the profit
        //we need high profit thus we start from the end
        //hardcode 1st 
        ArrayList<Integer> job = new ArrayList<>();
        int count = 1;
        int profit=jobs[jobs.length-1][1];//storing profit of the last (highest) job
        job.add(jobs.length-1); //adding index of the job with highest(last) profit
        for(int i = jobs.length-2 ; i>=0;i--){
            if(jobs[i][0]>count){
                count++;
                job.add(i);
                profit+=jobs[i][1];
            }
        }
        System.out.println("Max profit "+ profit);
        System.out.println("Jobs to be done " + job);
        System.out.println("Thus max no of job to be done " + count);
    }
    public static void main(String[] args) {
        int jobs[][]={{4,20},{1,10},{1,40},{1,30}};
        code(jobs);
    }
}
