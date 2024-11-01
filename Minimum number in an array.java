class Main{
    public static void main(String[] args){
        int arr[] = {22,55,3,34,6,1,66,8};
        int min = findMin(arr);
        System.out.println("The minimum number in the array is :"+min);
    }
    public static int findMin(int[] arr){
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if (arr[i]<min){
                min = arr [i];
            }
        }
        return min;
    }
}
        
   
