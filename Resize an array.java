import java.util.Arrays;
public class ResizeArray{
    public static int[] resizeArray(int[] original,int newSize){
        int[] newArray=new int[newSize];
        for(int i=0; i<Math.min(original.length,newSize); i++){
            newArray[i]=original[i];
        }
        return newArray;
    }
    public static void main(String[] args){
        int[] originalArray={1,2,3,4,5};
        int[] resizedArray=resizeArray(originalArray,7);
        System.out.println("Original Array: "+Arrays.toString(originalArray));
        System.out.println("Resized Array: "+Arrays.toString(resizedArray));
    }
}