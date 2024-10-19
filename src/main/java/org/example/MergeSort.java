package org.example;

import java.util.Arrays;

public class MergeSort {

    void mergeSort(int[] arr) {
        if(arr.length < 2) {
            return;
        }

        int midElement = (arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, midElement);
        int[] right = Arrays.copyOfRange(arr, midElement, arr.length);

        mergeSort(left);
        mergeSort(right);

        sort(arr, left, right);
    }

    void sort(int[] arr, int[] left, int[] right) {

        int i =0,j =0;
        int k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else if (left[i] == right[j]) {
                arr[k] = left[i];
                arr[k+1] = right[j];
                k+=2;
                i++;
                j++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] sourceArray = {1,2,4,7,0,4,3,4,5};
        MergeSort mergeSort = new MergeSort();

        mergeSort.mergeSort(sourceArray);

        Arrays.stream(sourceArray).forEach(System.out::println);
    }
}
