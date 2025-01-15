import java.util.Arrays;
public class BubbleSort{
    static void bubbleSort(int arr[], int n){
        if(n==1)
            return;
        int count = 0;
        
        for(int i=0; i<n-1; i++)
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;               
            }
        if (count == 0)
            return;
        
        bubbleSort(arr, n-1);
    }
    public static void main(String[] args){
        int arr[] = {23,56,11,27,10,88};
        bubbleSort(arr, arr.length);
        
        System.out.println("Sorted Array : ");
        System.out.println(Arrays.toString(arr));   
        
    }
}
