import java.util.Arrays;
public class MoveZeroes{
    public static void MoveZeroesToEnd(int[] arr){
        int nonZeroIndex=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                arr[nonZeroIndex]=arr[i];
                nonZeroIndex++;
            }
        }
        for(int i=nonZeroIndex; i<arr.length; i++){
            arr[i]=0;
        }
    }
    public static void main(String[] args){
        int[] arr={3,0,4,1,5,0,44,9,5};
        MoveZeroesToEnd(arr);
        System.out.println("After moving Zeroes to the end: "+
        Arrays.toString(arr));
    }
}