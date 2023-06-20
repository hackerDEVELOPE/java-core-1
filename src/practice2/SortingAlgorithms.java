package practice2;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 3, 2, 1, 7, 3, 19, 2, 40})));
        System.out.println(Arrays.toString(selectionSort(new int[]{5, 3, 2, 1, 7, 3, 19, 2, 40})));
        System.out.println(Arrays.toString(insertionSort(new int[]{5, 3, 2, 1, 7, 3, 19, 2, 40})));
        quickSortLomuto(new int[]{5, 3, 2, 1, 7, 3, 19, 2, 40});
    }


    public static int[] bubbleSort(int[] arr) {
        int lenght = arr.length;
        while (lenght != 0) {

            int maxIndex = 0;
            for (int i = 1; i < lenght; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    maxIndex = i;
                }
            }
            lenght = maxIndex;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int sorted = i - 1;
            while (sorted > -1 && arr[sorted] > arr[sorted + 1]) {
                int temp = arr[sorted];
                arr[sorted] = arr[sorted + 1];
                arr[sorted + 1] = temp;
                sorted--;
            }
        }
        return arr;
    }

    public static int partOfSortHoara(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right++;
            }
        }
        return left;
    }

    public static void quickSortHoara(int[] arr, int start, int end){
        if (start>=end) return;
        int rightStart = partOfSortHoara(arr, start, end);
        quickSortHoara(arr, start, rightStart-1);
        quickSortHoara(arr, rightStart, end);
    }
    public static void quickSortHoara(int[] arr){
        quickSortHoara(arr, 0, arr.length-1);
    }
    public static int partOfSortLomuto (int[] arr, int start, int end){
        int left = start;
        for (int current = start; current < end; current++){
            if (arr[current]<= arr[end]){
                int temp = arr[left];
                arr[left] = arr[current];
                arr[current] = temp;
                left++;
            }
        }
        int temp = arr[left];
        arr[left] = arr[end];
        arr[end] = temp;
        return left;
    }
    public static void quickSortLomuto(int[] arr, int start, int end){
        if (start >= end) return;
        int rightStart = partOfSortLomuto(arr, start, end);
        quickSortLomuto(arr, start, rightStart-1);
        quickSortLomuto(arr, rightStart+1, end);
    }
    public static void quickSortLomuto(int[] arr){
        quickSortLomuto(arr, 0, arr.length-1);
    }
}
