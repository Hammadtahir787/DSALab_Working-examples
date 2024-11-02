/*Q3. Write a program that accepts three numbers from the user and prints "increasing" if the
numbers are in increasing order, "decreasing" if the numbers are in decreasing order, and
"Neither increasing nor decreasing order" otherwise. (create a method to solve this problem)*/

import java.util.Scanner;
public class NumberOrder{
    public static String CheckOrder(int a, int b, int c){
        if(a<b && b<c){
            return "increasing order";
        }
        else if(a>b && b>c){
            return "decreasing Order";
        }
        else{
            return "Neither increasing nor decreasing";
        }
    }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the first number :");
            int num1 = sc.nextInt();
            System.out.println("Enter the Second number :");
            int num2 = sc.nextInt();
            System.out.println("Enter the Third number :");
            int num3 = sc.nextInt();

            String result = CheckOrder(num1, num2, num3);
            System.out.println(result);
            sc.close();
        }
    
}