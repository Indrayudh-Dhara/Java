import java.util.*;
public class OOPS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Complex n1 = new Complex();
        System.out.println("Enter your real part for your 1st number");
        int real1= sc.nextInt();
        System.out.println("Enter your complex part for your 1st number");
        int complex1=sc.nextInt();
        System.out.println("Enter your real part for your 2st number");
        int real2=sc.nextInt();
        System.out.println("Enter your complex part for your 2st number");
        int complex2=sc.nextInt();
        n1.sum(real1, complex1, real2, complex2);
        n1.difference(real1, complex1, real2, complex2);
        n1.product(real1, complex1, real2, complex2);

        
    }
}

class Complex{
    void sum(int real1,int complex1,int real2,int complex2){
        int realSum = real1+real2;
        int complexSum = complex1+complex2;
        if (complexSum<0) {
            System.out.println(realSum + "j" + complexSum);
        }else{
        System.out.println(realSum + "+"+ "j" + complexSum);
        }
    }
    void difference(int real1,int complex1,int real2,int complex2){
        int realDiff=real2-real1;
        int complexDiff = complex2-complex1;
        if (complexDiff<0) {
            System.out.println(realDiff + "j" + complexDiff);
        }else{
        System.out.println(realDiff + "+"+ "j" + complexDiff);
        }
    }
    void product(int real1,int complex1,int real2,int complex2){
        int realPart = real1*real2 - complex1*complex2;
        int complexPart = real1*complex2 + real2*complex1;
        if (complexPart<0) {
            System.out.println(realPart + "j" + complexPart);
        }else{
        System.out.println(realPart + "+"+ "j" + complexPart);
        }
    }
}

// interface Herbivore{
//     void eatMeat();
// }

// interface Carnivore{
//     void eatPlant();
// }

// class Bear implements Herbivore imp{
//     void eatMeat(){
//         System.out.println("eat meat");
//     }

// }

// class Vehicle{
//     void print(){
//         System.out.println("vehicle");
//     }
// }

// class Car extends Vehicle{
//     void print(){
//         System.out.println("Car");
//     }
// }

