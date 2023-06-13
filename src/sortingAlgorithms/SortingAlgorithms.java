package sortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void bubbleSort(int[] arr) {
        bubbleSortHelper(arr, 1);
    }

    private static void bubbleSortHelper(int[] arr, int i) {
        if (i == arr.length) return;

        if (arr[i] < arr[i-1]) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;

            bubbleSortHelper(arr, 1);
        }

        bubbleSortHelper(arr, ++i);
    }

    public static void selectionSort(int[] arr) {
        selectionSortHelper(arr, 0);
    }

    private static void selectionSortHelper(int[] arr, int i) {
        if (i == arr.length) return;

        int minIndex = 0;
        int min = arr[i];

        for (int j = i; j < arr.length; j++) {
            if (arr[j] < min) {
                minIndex = j;
                min = arr[j];
            }
        }

        if (arr[i] > min) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        selectionSortHelper(arr, ++i);
    }



    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 4, 6, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
