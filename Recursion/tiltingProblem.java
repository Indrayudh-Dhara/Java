package Recursion;

public class tiltingProblem {

    //call stack
//     tilting(4)
// ├── tilting(2)   ← horizontal first
// │   ├── tilting(0) → 1
// │   └── tilting(1) → 1
// │   → returns 2
// └── tilting(3)   ← vertical second
//     ├── tilting(1) → 1
//     └── tilting(2)
//         ├── tilting(0) → 1
//         └── tilting(1) → 1
//         → returns 2
//     → returns 3

// → tilting(4) = 2 + 3 = 5



    public static int tilting(int n){
        //base case
        if(n==-0){
            return 1;
        }
        if(n==1){
            return 1;
        }

        //choices

        //horizontal
        int hor = tilting(n-2);

        //vertical
        int ver = tilting(n-1);

        return hor+ver;


    }

    




    public static void main(String[] args) {
        System.out.println(tilting(9));
    }
}
