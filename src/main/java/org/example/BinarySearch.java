package org.example;

public class BinarySearch {


    int indexOfElementIterative(int[] arr, int searchElement )  {
        int mid = 1;
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {

            mid = (min + max)/2;


            if (searchElement == arr[mid]) {
                return mid;
            } else if( searchElement > arr[mid]) {
                min = mid+1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        BinarySearch search = new BinarySearch();
        int arr[] = {1,2,3,4,5,6,7,8,9};
        for(int i=0; i< arr.length; i++) {
            System.out.println(i + " at position - " + search.indexOfElementIterative(arr, i));
        }

        }
}
