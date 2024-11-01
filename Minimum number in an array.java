import java.util.Scanner;
class CompareNumbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number: ");
        double num1 = sc.nextDouble();
        System.out.println("enter the second number: ");
        double num2 = sc.nextDouble();
        sc.close();
        
        int num1FloatingNum=(int)(num1 * 1000);
        int num2FloatingNum=(int)(num2 * 1000);
        if(num1FloatingNum == num2FloatingNum){
               System.out.println("The floating numbers are equal ");
        }
        else{
              System.out.println("The floating numbers are not equal ");

    }
}
}