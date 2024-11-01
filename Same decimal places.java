import java.util.Scanner;
class CompareNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number :");
        double num1 = scanner.nextDouble();
        System.out.println("Enter the Second number :");
        double num2 = scanner.nextDouble();
        scanner.close();

    int num1ThreeDecimalPlaces = (int)(num1 * 1000);
    int num2ThreeDecimalPlaces  = (int)(num2 * 1000);

    if(num1ThreeDecimalPlaces == num2ThreeDecimalPlaces){
        System.out.println("The floating numbers are equal");
    }
    else{
        System.out.println("The number are not same  ");
    }
  }

    @Override
    public String toString() {
        return "CompareNumbers []";
    }
}