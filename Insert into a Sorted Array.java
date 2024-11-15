public static int[] insertElement(int[] arr, int element) {
    int[] newArr = new int[arr.length + 1];
    int i = 0;
    while (i < arr.length && arr[i] < element) {
        newArr[i] = arr[i];
        i++;
    }
    newArr[i] = element;
    for (int j = i; j < arr.length; j++) {
        newArr[j + 1] = arr[j];
    }
    return newArr;
}
