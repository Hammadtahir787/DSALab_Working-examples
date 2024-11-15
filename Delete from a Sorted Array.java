public static int[] deleteElement(int[] arr, int element) {
    int index = binarySearch(arr, element);
    if (index == -1) {
        System.out.println("Element not found.");
        return arr;
    }
    int[] newArr = new int[arr.length - 1];
    for (int i = 0; i < index; i++) {
        newArr[i] = arr[i];
    }
    for (int i = index; i < newArr.length; i++) {
        newArr[i] = arr[i + 1];
    }
    return newArr;
}
