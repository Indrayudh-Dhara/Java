package Heaps;
import java.util.Comparator;
import java.util.PriorityQueue;
public class priorityQueues {

    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(int rank , String name){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s){
            return this.rank-s.rank;
            //the below logic is predefined inside Priority Queue , (whatever compare to returns PQ changes those two object places based on that value)
            //negative means -> this < s (thus correct order)
            //positive means -> this > s (s to be given more priority and s comes before this)
            //equal means -> this==s (doesnt matter)
        }
    }
    //NOTES
    //using implements Comparable<Student> gives the ability for an object of a class to be compared 
    //Comparable is the parent interface which has a function compareTo , which the child class Student overrides using @Override
    // compareTo(Student s) means we will be comparing student object based on the logic written inside the compareTo (based on rank currently)
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //Comparator.reverseOrder() flips the comparison logic , without it (lower the integer higher the priority ) , with it (its the opp)
    
        //lets define a pq with takes prioritise objects
        PriorityQueue<Student> spq = new PriorityQueue<>(); //takes student and ranks them top priority to bottom according to their lowest ranks
    

        spq.add(new Student(4, "a"));
        spq.add(new Student(5, "b"));
        spq.add(new Student(2, "c"));
        spq.add(new Student(12, "d"));

        while(!spq.isEmpty()){
            System.out.println(spq.peek().name + "->" + spq.peek().rank);
            spq.remove();
        }
    }
}
