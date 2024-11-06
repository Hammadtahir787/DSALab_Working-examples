public class SecondMax{
    public static int FindSecondMax(int[] array){
        if(array == null || array.length<2){
            throw new IllegalArgumentException("Array must have atleast 2 elements");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int num : array){
            if(num>max){
                secondMax=max;
                max=num;
            }
            else if(num>secondMax && num!=max){
              secondMax=num;
            }
        }
        return secondMax;
        
        
    }
    public static void main(String[]  args){
        int [] array={44,2,55,68,24,67,17};
        System.out.println("The Second Maximum value of the Array is:"+FindSecondMax(array));
    }
}