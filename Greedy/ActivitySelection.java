package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection{

    public static void ActivitySelectionCode(int startTime[], int endTime[]){

        // //sorting (Only needed if the endTime is not sorted)

        // int activities[][]=new int[startTime.length][3]; //3 columns -one for storing original index , one for storing start time and another for end time for that activity
        // for(int i = 0 ; i<activities.length; i++){
        //     activities[i][0]=i; //storing index as when it gets sorted , we can track their original index
        //     activities[i][1]=startTime[i];
        //     activities[i][2]=endTime[i];
        // }

        // //lamba function
        // Arrays.sort(activities,Comparator.comparingDouble(o -> o[2])); //comparator is an interface that defines how to sort something , we defined that sorting is to be done by column 2(ending time)

        // //now just code the rest accordingly
        //..................




        int count = 0 ; 


        //selecting the first activity (hard coding)
        int lastEndTime=endTime[0]; //we need to track the lastIndex as it we need to use it to know if the current activity starts after the previous actitvity ended or not 
        count++;

        for(int i= 1 ; i <endTime.length ; i++){
            if(startTime[i]>=lastEndTime){
                lastEndTime=endTime[i];
                 count++; //only increase if valid activity
            }
           
        }
        System.out.println(count);
    }

    //if you need to print all the activities that can be done , you can take an ArrayList and add the indexes of the valid activities and run a loop later


    public static void main(String[] args) {
        
        int arr[]={1,3,0,5,8,5};
        int arr2[]={2,4,6,7,9,9};//sorted by end time
        ActivitySelectionCode(arr, arr2);
    }
}