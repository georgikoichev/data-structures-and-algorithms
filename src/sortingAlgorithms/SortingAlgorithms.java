package sortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        bubbleSortHelper(arr, 1);
    }

    private static void bubbleSortHelper(int[] arr, int i) {
        if (i == arr.length) return;

        if (arr[i] < arr[i-1]) {
            swap(arr, i, i-1);

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
            swap(arr, i, minIndex);
        }

        selectionSortHelper(arr, ++i);
    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int bottom, int top) {
        if (bottom < top) {
            int pivot = arr[top];

            int i = bottom - 1;

            for (int j = bottom; j <= top - 1; j++) {
                if (arr[j] <= pivot) {
                    i++;

                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, top);

            quickSortHelper(arr, bottom, i);
            quickSortHelper(arr, i + 2, top);
        }
    }

    public static void insertionSort(int[] arr) {
        insertionSortHelper(arr, 1, 1);
    }

    private static void insertionSortHelper(int[] arr, int i, int j) {
        if (i <= arr.length) {
            if (arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
                if (j == 1)
                    insertionSortHelper(arr, i, i);
                else
                    insertionSortHelper(arr, i, --j);
            }

            insertionSortHelper(arr, ++i, ++j);
        }
    }

    public static void heapSort(int[] arr) {
        int l = arr.length;

        for (int i = l / 2 - 1; i >= 0; i--) {
            heapify(arr, l, i);
        }

        for (int i = l - 1; i > 0; i--) {
            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int l, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < l && arr[left] > arr[largest])
            largest = left;

        if (right < l && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, l, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 1, 6, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
