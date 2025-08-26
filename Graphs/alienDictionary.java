package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class alienDictionary {


    public static void code( String[] words){

        HashSet<Character> hs = new HashSet<>();
        for(int i = 0 ;i<words.length ; i++){
            String word = words[i];
            for(char c : word.toCharArray()){
                hs.add(c);
            }
        }

        ArrayList<ArrayList<Character>> graph = new ArrayList<>();
        
       
        
        for(int i = 0 ;i<hs.size();  i++){
            graph.add(i , new ArrayList<>());
        }
        //create the graph based on the words array
        for(int i = 0 ; i<words.length-1 ; i++){ //we will take each consecutive pair of words and calculate the first changing character
            
            for(int j = 0 ; j<Math.min(words[i].length() , words[i+1].length()) ; j++){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    //now the character at words[i] is the index (the source) and the character at words[i+1] is the destination and they are basically treated as connected directed edges from src to dest
                    graph.get(words[i].charAt(j)-'a').add((words[i+1].charAt(j)));
                    break;
                }
            }

        }

            //created the graph 

            //TOP SORT USING KAHN

            //1. calculating indegree
            int[] indegree = new int[graph.size()];

            for(int j= 0 ;j<graph.size() ;j++){    
                for(int k = 0 ; k<graph.get(j).size() ; k++){
                    indegree[graph.get(j).get(k)-'a']++;
                }
            }
            //2.push the indegree zeros to the q and start bfs  

            Queue<Character> q = new LinkedList<>();

            for(int i = 0 ;i<indegree.length ; i++){
                if(indegree[i]==0){
                    q.add((char)(i+'a'));
                }
            }

            //bfs

            while(!q.isEmpty()){
                char curr = q.remove();
                System.out.print(curr);
                
                for(int k = 0 ;k<graph.get(curr-'a').size() ; k++){
                    indegree[graph.get(curr-'a').get(k)-'a'] --;
                    if(indegree[graph.get(curr-'a').get(k)-'a']==0){
                        q.add((char)(graph.get(curr-'a').get(k)));
                    }
                }
                System.out.print("->");
            }
            System.out.println();
            



        
    }
    public static void main(String[] args) {

        // String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        // int k = 4; // (meaning 4 distinct letters are used, say: a, b, c, d)
        // code( words);
        System.out.println(388/10);
    }
}
