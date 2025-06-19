package Queue;

import java.util.LinkedList;
import java.util.Queue;

//IN this questions it was mentioned that its a Stream of characters , it means the string it not avaliable to us entirely 
//the characters commes on by one after and we need to find the non repeating characters for each level
//thus once a character has their frequency more than 1 it will never be the non repeating character for any further level it becomes useless (FIFO)
//thus we check and remove from the front as we need the FIRST non repeating character (thats what Stream refers to)  - FIFO


public class nonRepeatingStream {

    public static void nonRepeatingCharacter(String str){
        //array to store frequency of characters
        int freq[]=new int[26];
        //queue to allow stream of characters and FIFO pattern where we store current and FIRST non repeating characters
        Queue<Character> q = new LinkedList<>();
        //loop to iterate through the entire stream one character by another in a stream form
        for(int i = 0 ; i<str.length();i++){
            //we add the current to the queue
            q.add(str.charAt(i));
            //we increase the frequency of the current character
            freq[str.charAt(i)-'a']+=1;
            //we keep on check and remove throught the queue until we found our FIRST non repeating character
            while(!q.isEmpty() && freq[q.peek()-'a']!=1){
               q.remove();
            }
            //at this point either the queue's front has the First non repeating character for that level or is empty(no nonrepeating character)

            //case 1 - empty
            if(q.isEmpty()){
                System.out.println(-1);
            }else{
                //case 2 - non repeating character on front for the current level of stream
                System.out.println(q.peek());
            }
           
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        nonRepeatingCharacter(str);
    }
}
